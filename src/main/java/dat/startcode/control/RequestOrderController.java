package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.CarportRequest;
import dat.startcode.model.entities.PartsList;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.services.*;
import lombok.SneakyThrows;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "RequestOrderController", value = "/RequestOrderController")
public class RequestOrderController extends HttpServlet {

    private ConnectionPool connectionPool;

    public RequestOrderController() {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // no caching
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0); // Proxies.
        String isRequest = request.getParameter("isRequestHidden");

        JSONObject jsonObject = new JSONObject();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        PartslistGenerator generator = new PartslistGenerator(connectionPool);

        int cplength = Integer.parseInt(request.getParameter("cplength"));
        int cpwidth = Integer.parseInt(request.getParameter("cpwidth"));
        boolean isShed = request.getParameterMap().containsKey("isShed");
        int toolLength = ((isShed) ? Integer.parseInt(request.getParameter("cpshedlength")) : 0);
        int toolWidth = ((isShed) ? (int) Float.parseFloat(request.getParameter("cpshedwidth")) : 0);
        String rooftype;
        if(request.getParameter("isRaised") == null){
            rooftype = "flat";
        } else{
            rooftype = "raised";
        }
        int roofPitch = 0;
        CarportRequest carportRequest = new CarportRequest(cplength, cpwidth, rooftype, roofPitch, toolLength, toolWidth, user);
        PartsList list = generator.generateFlatroofPartsList(carportRequest);
        SideView sideView = new SideView(list, cplength, toolLength, isShed);
        TopView topview = new TopView(cplength, cpwidth, isShed, toolLength, toolWidth, list);
        jsonObject.put("sideview", sideView.svgSideGen());
        jsonObject.put("topview", topview.svgTopViewGen());

        if (isRequest.equals("request")){
            CarportRequestFacade.createCartportRequest(connectionPool,carportRequest);
            carportRequest.setCarport_request_id(CarportRequestFacade.getNewestCarportRequest(connectionPool));
            PartsListFacade.createPartsList(connectionPool, carportRequest);
            jsonObject.put("request", "true");
        }else if (isRequest.equals("order")){
            list.setPartslist_id(PartsListFacade.getNewestPartsList(connectionPool));
            OrderFacade.createFullOrder(connectionPool, user, carportRequest, list);
            jsonObject.put("request", "false");
        }else{
            throw new SQLException("noget gik galt med dit hidden input");
        }

        PrintWriter out = response.getWriter(); // vi får fat i en writer så vi kan skrive til vores response
        response.setContentType("application/json"); // vi sørger her for at vores response kan tage og håndtere json
        response.setCharacterEncoding("UTF-8"); // siger lidt sig selv sørger for at vi kan skrive i UTF-8
        out.print(jsonObject); // skriver vores string til vores response
        out.flush(); // commiter vores response
    }
}
