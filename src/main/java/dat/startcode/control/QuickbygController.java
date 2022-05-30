package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.CarportRequest;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.services.CarportRequestFacade;
import dat.startcode.model.services.PersonFacade;
import dat.startcode.model.services.UserFacade;
import lombok.SneakyThrows;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "QuickbygController", value = "/QuickbygController")
public class QuickbygController extends HttpServlet {

    private final ConnectionPool connectionPool;

    public QuickbygController() {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("I HAVE BEEN SUMMONED");
//        int cplength = Integer.parseInt(request.getParameter("cplength"));
//        System.out.println(cplength);
//        int cpwidth = Integer.parseInt(request.getParameter("cpwidth"));
//        boolean isShed = request.getParameterMap().containsKey("isShed");
//        int toolLength = ((isShed) ? Integer.parseInt(request.getParameter("cpshedlength")) : 0);
//        int toolWidth = ((isShed) ? (int) Float.parseFloat(request.getParameter("cpshedwidth")) : 0);
        // String city = (String) request.getParameter("inputCity"); kan bruges fra DB
        String password = request.getParameter("inputPassword");
        int zipCode = Integer.parseInt(request.getParameter("inputZip"));
        String address = request.getParameter("inputAddress");
        String phoneNumber = request.getParameter("inputPhonenumber");
        String name = request.getParameter("inputName");
        String email = request.getParameter("inputEmail");
        String rooftype; // DETTE ER EN CHECK PÅ BOOLEAN

        if(request.getParameter("isRaised") == null){
            rooftype = "flat";
        } else{
            rooftype = "raised";
        }
            if (request.getParameter("requestCreateUserCheck") != null) {
                PersonFacade.createPerson(email, address, name, phoneNumber, zipCode, connectionPool);
                UserFacade.createUser(email, password, "customer", connectionPool);
            } else {
                PersonFacade.createPerson(email, address, name, phoneNumber, zipCode, connectionPool);
            }
        request.getRequestDispatcher("quickbyg.jsp").forward(request, response);
    }
}
