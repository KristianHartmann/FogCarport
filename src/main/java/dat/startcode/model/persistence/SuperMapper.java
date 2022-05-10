package dat.startcode.model.persistence;
import static dat.startcode.model.persistence.SQLStatements.*;

public class SuperMapper {
    ConnectionPool connectionPool;

    public SuperMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

}
