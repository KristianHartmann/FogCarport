package dat.startcode.control;

import com.sun.net.httpserver.HttpContext;
import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.*;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.OrderItemMapper;
import dat.startcode.model.services.*;
import lombok.SneakyThrows;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProfileController", value = "/ProfileController")
public class ProfileController extends HttpServlet {

    private ConnectionPool connectionPool;

    public ProfileController()
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }


    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        ArrayList<Order> orderArrayList = OrderFacade.getAllOrderByUserID(connectionPool,user);
        context.setAttribute("orderArrayList", orderArrayList);
        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        int orderId = Integer.parseInt(request.getParameter("orderIDButton"));
        if(request.getParameter("StykListeKnap") != null){
            Order order = new Order(orderId, user);
            request.setAttribute("orderID", orderId);
            Orderitem orderitem = OrderItemFacade.getOrderItemByOrderId(order, connectionPool);
            PartsList list = new PartsList();
            CarportRequest carportRequest = CarportRequestFacade.getRequestByPartsListID(connectionPool, list.getPartslist_id());
            list.setPartsListItemArrayList(PartsListItemFacade.getPartsListItems(connectionPool, orderitem.getPartslist_id()));
            context.setAttribute("partsListItemArray", list.getPartsListItemArrayList());
        }

        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }

}
