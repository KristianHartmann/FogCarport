package dat.startcode.control;

import com.sun.net.httpserver.HttpContext;
import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.*;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.OrderItemMapper;
import dat.startcode.model.services.*;
import lombok.SneakyThrows;
import org.json.JSONObject;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet(name = "ProfileController", value = "/ProfileController")
public class ProfileController extends HttpServlet {

    private ConnectionPool connectionPool;

    public ProfileController() {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }


    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        ArrayList<Order> orderArrayList = OrderFacade.getAllOrderByUserID(connectionPool, user);
        context.setAttribute("orderArrayList", orderArrayList);
        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject jsonObject = new JSONObject();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        int orderId = Integer.parseInt(request.getParameter("orderID"));
        Order order = new Order(orderId, user);
        Orderitem orderitem = OrderItemFacade.getOrderItemByOrderId(order, connectionPool);
        PartsList list = new PartsList();
        list.setPartslist_id(orderitem.getPartslist_id());
        CarportRequest carportRequest = CarportRequestFacade.getRequestByPartsListID(connectionPool, list.getPartslist_id());
        boolean isShed = carportRequest.getToolbox_length() > 0 && carportRequest.getToolbox_width() > 0;
        list.setPartsListItemArrayList(PartsListItemFacade.getPartsListItems(connectionPool, list.getPartslist_id()));
        TopView topView = new TopView(carportRequest.getLength(), carportRequest.getWidth(), isShed, carportRequest.getToolbox_length(), carportRequest.getToolbox_width(), list);
        SideView sideView = new SideView(list, carportRequest.getLength(), carportRequest.getToolbox_length(), isShed);
        jsonObject.put("topview", topView.svgTopViewGen());
        jsonObject.put("sideview", sideView.svgSideGen());
        jsonObject.put("order", orderId);
        jsonObject.put("partslist", list);

        PrintWriter out = response.getWriter(); // vi får fat i en writer så vi kan skrive til vores response
        response.setContentType("application/json"); // vi sørger her for at vores response kan tage og håndtere json
        response.setCharacterEncoding("UTF-8"); // siger lidt sig selv sørger for at vi kan skrive i UTF-8
        out.print(jsonObject); // skriver vores string til vores response
        out.flush(); // commiter vores response

    }

}
