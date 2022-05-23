package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.services.PersonFacade;
import dat.startcode.model.services.UserFacade;
import lombok.SneakyThrows;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "QuickbygController", value = "/QuickbygController")
public class QuickbygController extends HttpServlet {

    private ConnectionPool connectionPool;

    public QuickbygController() {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("inputPassword");
        int zipCode = Integer.parseInt(request.getParameter("inputZip"));
        // String city = (String) request.getParameter("inputCity"); kan bruges fra DB
        String address = request.getParameter("inputAddress");
        String phoneNumber = request.getParameter("inputPhonenumber");
        String name = request.getParameter("inputName");
        String email = request.getParameter("inputEmail");


        if(request.getParameter("submitPerson") != null) {
            if (request.getParameter("requestCreateUserCheck") != null) {
                PersonFacade.createPerson(email, address, name, phoneNumber, zipCode, connectionPool);
                UserFacade.createUser(email, password, "customer", connectionPool);
            } else {
                PersonFacade.createPerson(email, address, name, phoneNumber, zipCode, connectionPool);
            }
        }

    }
}
