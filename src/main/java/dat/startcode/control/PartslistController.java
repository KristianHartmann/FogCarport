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
import dat.startcode.model.services.PartslistGenerator;

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

@WebServlet(name = "PartslistController", value = "/PartslistController")
public class PartslistController extends HttpServlet {
    private ConnectionPool connectionPool;

    public PartslistController()
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        MapperFacade facade = new MapperFacade(connectionPool);
        PartslistGenerator generator = new PartslistGenerator(connectionPool);

        CarportRequest carportRequest = null;
        try {
            carportRequest = facade.getCarportRequestMapper().getCarportRequestById(1); //skal IKKE HARDCODES
            PartsList partsList = generator.generateFlatroofPartsList(carportRequest);
            context.setAttribute("partsList", partsList.getPartsListItemArrayList());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (DatabaseException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
