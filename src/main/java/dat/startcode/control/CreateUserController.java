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

@WebServlet(name = "CreateUserController", value = "/CreateUserController")
public class CreateUserController extends HttpServlet {
    private final ConnectionPool connectionPool;

    public CreateUserController() {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String phonenumber = request.getParameter("phonenumber");
        String address = request.getParameter("address");
        int zipcode = Integer.parseInt(request.getParameter("zipcode"));
        String password = request.getParameter("password");

        PersonFacade.createPerson(email,address,name,phonenumber,zipcode, connectionPool);
        UserFacade.createUser(email, password, "customer", connectionPool);
        request.getRequestDispatcher("index.jsp").forward(request,response);


    }
}
