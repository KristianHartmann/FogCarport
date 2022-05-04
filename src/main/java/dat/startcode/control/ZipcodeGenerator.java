package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.ExcelMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class ZipcodeGenerator extends Command {

    private ConnectionPool connectionPool;

    public ZipcodeGenerator()
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {
        ExcelMapper mapper = new ExcelMapper(connectionPool);
        HashMap<Integer, String> hashmap = mapper.getDanishPostcodes();

        mapper.insertPostcodes(hashmap);

        return "index";
    }
}
