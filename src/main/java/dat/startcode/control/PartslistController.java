package dat.startcode.control;

import dat.startcode.model.entities.CarportRequest;
import dat.startcode.model.entities.PartsList;
import dat.startcode.model.entities.PartsListItem;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.CarportRequestMapper;
import dat.startcode.model.persistence.SuperMapper;
import dat.startcode.model.services.PartslistGenerator;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class PartslistController extends Command{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException, SQLException {
        ServletContext context = request.getServletContext();
        CarportRequestMapper carportRequestMapper = new CarportRequestMapper(super.connectionPool);
        PartslistGenerator generator = new PartslistGenerator(super.connectionPool);
        CarportRequest carportRequest = carportRequestMapper.getCarportRequestById(1);
        PartsList partsList = generator.generatePartsList(carportRequest);
        context.setAttribute("partsList", partsList.getPartsListItemArrayList());
        return "partslist";
    }
}
