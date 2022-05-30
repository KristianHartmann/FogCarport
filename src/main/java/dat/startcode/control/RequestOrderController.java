package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.CarportRequest;
import dat.startcode.model.entities.PartsList;
import dat.startcode.model.entities.Person;
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

    private final ConnectionPool connectionPool;

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
        PartslistGenerator generator = new PartslistGenerator(connectionPool);
        PartsList list;
        User user = null;
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
        CarportRequest carportRequest;
        if(isRequest.equals("request")){
            String email = request.getParameter("inputEmail");
            String name = request.getParameter("inputName");
            String phonenr = request.getParameter("inputPhonenumber");
            String address = request.getParameter("inputAddress");
            int zip = Integer.parseInt(request.getParameter("inputZip"));

            boolean createUser = request.getParameterMap().containsKey("requestCreateUserCheck");
            PersonFacade.createPerson(email, address, name, phonenr, zip, connectionPool);
            if(createUser){
                String password = request.getParameter("inputPassword");
                user = new User("customer", password, email);
                UserFacade.createUser(user.getEmail(), user.getPassword(), user.getRole(), connectionPool);
                carportRequest = new CarportRequest(cplength, cpwidth, rooftype, roofPitch, toolLength, toolWidth, user);
            }else {
                carportRequest = new CarportRequest(cplength, cpwidth, rooftype, roofPitch, toolLength, toolWidth, email);
            }
            CarportRequestFacade.createCartportRequestEmail(connectionPool,carportRequest, email);
            jsonObject.put("request", "true");
        }else{
            user = (User) session.getAttribute("user");
            carportRequest = new CarportRequest(cplength, cpwidth, rooftype, roofPitch, toolLength, toolWidth, user);
            CarportRequestFacade.createCartportRequest(connectionPool,carportRequest);
            carportRequest.setCarport_request_id(CarportRequestFacade.getNewestCarportRequest(connectionPool));
            PartsListFacade.createPartsList(connectionPool, carportRequest);
            list = generator.generateFlatroofPartsList(carportRequest);
            list.setPartslist_id(PartsListFacade.getNewestPartsList(connectionPool));
            OrderFacade.createFullOrder(connectionPool, user, carportRequest, list);
            jsonObject.put("request", "false");
            SideView sideView = new SideView(list, cplength, toolLength, isShed);
            TopView topview = new TopView(cplength, cpwidth, isShed, toolLength, toolWidth, list);
            jsonObject.put("sideview", sideView.svgSideGen());
            jsonObject.put("topview", topview.svgTopViewGen());
        }

        PrintWriter out = response.getWriter(); // vi får fat i en writer så vi kan skrive til vores response
        response.setContentType("application/json"); // vi sørger her for at vores response kan tage og håndtere json
        response.setCharacterEncoding("UTF-8"); // siger lidt sig selv sørger for at vi kan skrive i UTF-8
        out.print(jsonObject); // skriver vores string til vores response
        out.flush(); // commiter vores response
    }
}
