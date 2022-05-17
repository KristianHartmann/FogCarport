package dat.startcode.model.persistence;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MapperFacade extends SuperMapper {
    CarportRequestMapper carportRequestMapper = new CarportRequestMapper(connectionPool);
    OrderItemMapper orderItemMapper = new OrderItemMapper(connectionPool);
    PartsListItemMapper partsListItemMapper = new PartsListItemMapper(connectionPool);
    PartsListMapper partsListMapper = new PartsListMapper(connectionPool);
    PartsMapper partsMapper = new PartsMapper(connectionPool);
    UserMapper userMapper = new UserMapper(connectionPool);

    public MapperFacade(ConnectionPool connectionPool) {
        super(connectionPool);
    }


}
