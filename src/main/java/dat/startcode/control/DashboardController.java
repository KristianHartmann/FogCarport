package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.CarportRequest;
import dat.startcode.model.entities.Order;
import dat.startcode.model.entities.Person;
import dat.startcode.model.entities.User;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.services.CarportRequestFacade;
import dat.startcode.model.services.OrderFacade;
import dat.startcode.model.services.PersonFacade;
import dat.startcode.model.services.UserFacade;
import lombok.SneakyThrows;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Dashboard", value = "/Dashboard")
public class DashboardController extends HttpServlet {
    private ConnectionPool connectionPool;

    public DashboardController() {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        ArrayList<Person> personArrayList = PersonFacade.getAllPersons(connectionPool);
        ArrayList<CarportRequest> carportRequestArrayList = CarportRequestFacade.getAllCarportRequests(connectionPool);
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
        int requestID = Integer.parseInt(request.getParameter("requestID"));
        CarportRequest carportRequest = CarportRequestFacade.getCarportRequestByID(connectionPool, requestID);
        User user = carportRequest.getUser();

    }
}