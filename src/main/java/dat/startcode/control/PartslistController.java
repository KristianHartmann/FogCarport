package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.CarportRequest;
import dat.startcode.model.entities.PartsList;
import dat.startcode.model.entities.PartsListItem;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.CarportRequestMapper;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.MapperFacade;
import dat.startcode.model.persistence.SuperMapper;
import dat.startcode.model.services.CarportRequestFacade;
import dat.startcode.model.services.PartsListFacade;
import dat.startcode.model.services.PartslistGenerator;
import lombok.SneakyThrows;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "PartslistController", value = "/PartslistController")
public class PartslistController extends HttpServlet {
    private ConnectionPool connectionPool;

    public PartslistController() {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = request.getServletContext();
//        int carportWidth =(int)  request.getAttribute("carportWidth");
//        int carportLength= (int)  request.getAttribute("carportLength");
//        int toolbox_Width = (int)  request.getAttribute("toolbox_Width");
//        int toolbox_length = (int) request.getAttribute("toolbox_length");
        CarportRequest carportRequest = new CarportRequest(500, 750, 0, 0);
        PartsList partsList = PartsListFacade.getPartsList(connectionPool, carportRequest);
        context.setAttribute("partsList", partsList.getPartsListItemArrayList());
        request.getRequestDispatcher("carport.jsp").forward(request, response);

    }

}
