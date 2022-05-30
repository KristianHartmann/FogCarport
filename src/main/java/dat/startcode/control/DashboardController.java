package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.*;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.UserMapper;
import dat.startcode.model.services.*;
import lombok.SneakyThrows;

import javax.lang.model.type.ArrayType;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

@WebServlet(name = "Dashboard", value = "/Dashboard")
public class DashboardController extends HttpServlet {
    private final ConnectionPool connectionPool;

    public DashboardController() {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        ArrayList<Person> personArrayList = PersonFacade.getAllPersons(connectionPool);
        ArrayList<CarportRequest> carportRequestArrayList = CarportRequestFacade.getAllCarportRequests(connectionPool);

        Iterator<CarportRequest> i = carportRequestArrayList.iterator();
        while (i.hasNext()) {
            CarportRequest c = i.next();
            if (CarportRequestFacade.isRequestApproved(connectionPool, c.getCarport_request_id())) {
                i.remove();
            }
        }

        ArrayList<Order> orderArrayList = OrderFacade.getAllOrder(connectionPool);
        context.setAttribute("personArrayList", personArrayList);
        context.setAttribute("carportRequestArrayList", carportRequestArrayList);
        context.setAttribute("orderArrayList", orderArrayList);
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("Handle");
        int requestID = Integer.parseInt(request.getParameter("orderID"));
        if (command.equals("Godkend")) {
            CarportRequest carportRequest = CarportRequestFacade.getCarportRequestByID(connectionPool, requestID);
            PartsList partsList = PartsListFacade.getPartsList(connectionPool, carportRequest);
            User user = null;


            if (UserFacade.getUserByEmail(connectionPool, carportRequest.getEmail()) == null) {
                UserFacade.createUser(carportRequest.getEmail(), "123", "customer", connectionPool);
                user = UserFacade.getUserByEmail(connectionPool, carportRequest.getEmail());
                OrderFacade.createFullOrder(connectionPool, user, carportRequest, partsList);
            } else {
                user = UserFacade.getUserByEmail(connectionPool, carportRequest.getEmail());
                OrderFacade.createFullOrder(connectionPool, UserFacade.getUserByEmail(connectionPool, carportRequest.getEmail()), carportRequest, partsList);
            }
            int orderID = OrderFacade.getNewestOrderID(connectionPool);
            Orderitem orderitem = OrderItemFacade.getOrderItemByOrderId(orderID, connectionPool);
            UserFacade.removeBalanace(connectionPool, orderitem.getPrice(), user);
        } else if (command.equals("Annuller")) {
            CarportRequestFacade.deleteOrder(connectionPool, requestID);
        }
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }

}