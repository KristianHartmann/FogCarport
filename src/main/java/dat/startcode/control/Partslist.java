//package dat.startcode.control;
//
//import dat.startcode.model.config.ApplicationStart;
//import dat.startcode.model.entities.Parts;
//import dat.startcode.model.exceptions.DatabaseException;
//import dat.startcode.model.persistence.ConnectionPool;
//import dat.startcode.model.persistence.PartsMapper;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.ArrayList;
//
//public class Partslist extends Command{
//
//    private ConnectionPool connectionPool;
//
//    public Partslist()
//    {
//        this.connectionPool = ApplicationStart.getConnectionPool();
//    }
//
//    @Override
//    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {
//
//
//        ArrayList<Parts> partsArrayList = new ArrayList<>();
//        PartsMapper partsMapper = new PartsMapper(connectionPool);
//        partsArrayList = partsMapper.getParts();
//        System.out.println(partsArrayList);
//
//    return "partslist";
//    }
//}
