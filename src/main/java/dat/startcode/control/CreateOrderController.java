package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.persistence.ConnectionPool;
import lombok.SneakyThrows;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CreateOrderController", value = "/CreateOrderController")
public class CreateOrderController extends HttpServlet {
    private final ConnectionPool connectionPool;

    public CreateOrderController() {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String carportWidth = (String) request.getAttribute("cpwidth");
        String carportLength = (String) request.getAttribute("cplength");
        String shedWidth = (String) request.getAttribute("cpshedwidth");
        String shedLength = (String) request.getAttribute("cpshedlength");
        boolean isRaised = (boolean) request.getAttribute("isRaised");
        boolean isShed = (boolean) request.getAttribute("isShed");
        String roofAngle = (String) request.getAttribute("roofangle");




    }
}
