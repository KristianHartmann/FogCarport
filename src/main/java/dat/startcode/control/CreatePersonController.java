package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.PersonMapper;
import dat.startcode.model.persistence.UserMapper;
import dat.startcode.model.services.PersonFacade;
import dat.startcode.model.services.UserFacade;
import lombok.SneakyThrows;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CreatePersonController", value = "/CreatePersonController")
public class CreatePersonController extends HttpServlet {
    private ConnectionPool connectionPool;

    public CreatePersonController()
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = (String) request.getParameter("inputPassword");
        int zipCode = Integer.parseInt(request.getParameter("inputZip"));
        // String city = (String) request.getParameter("inputCity"); kan bruges fra DB
        String address = (String) request.getParameter("inputAddress");
        String phoneNumber = (String) request.getParameter("inputPhonenumber");
        String name = (String) request.getParameter("inputName");
        String email = (String) request.getParameter("inputEmail");


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
