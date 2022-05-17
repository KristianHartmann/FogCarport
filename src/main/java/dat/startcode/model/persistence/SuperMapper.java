package dat.startcode.model.persistence;
import dat.startcode.model.entities.Orderitem;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.SQLException;

import static dat.startcode.model.persistence.SQLStatements.*;

public abstract class SuperMapper {
    ConnectionPool connectionPool;

    public SuperMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

}
