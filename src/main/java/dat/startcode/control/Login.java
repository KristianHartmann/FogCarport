package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.services.UserFacade;
import dat.startcode.model.persistence.ConnectionPool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    private ConnectionPool connectionPool;

    public Login()
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("user", null); // adding empty user object to session scope
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = null;
        try {
            user = UserFacade.login(username, password, connectionPool);
        } catch (DatabaseException e) {
            throw new RuntimeException(e);
        }
        session = request.getSession();
        session.setAttribute("user", user); // adding user object to session scope
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}