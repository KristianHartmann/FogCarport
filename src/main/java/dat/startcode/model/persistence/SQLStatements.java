package dat.startcode.model.persistence;

public class SQLStatements {

    public static String x = "";

    // delete
    public static String deleteOrderItem = "DELETE FROM orderitem WHERE order_id = ?;";
    public static String deleteOrder = "DELETE FROM `order` WHERE order_id = ?;";


    // select
    public static String selectCarportRequestByID = "select * from carport.carport_request where carport_request_id = ?";
    public static String selectAllUser = "select * from carport.user";
    public static String selectAllOrderFromUserId = "select * from carport.order where user_id = ?";
    public static String selectAllOrder = "select * from carport.order";
    public static String selectMaxOrder = "SELECT MAX(order_id) FROM carport.order;";
    public static String selectAllParts = "SELECT * FROM parts";
    public static String selectUserFromEmailAndPassword = "SELECT * FROM user WHERE email = ? AND password = ?";
    public static String selectAllUserFromUserID= "select * from carport.user where user_id = ?";


    // insert
    public static String createPerson = "INSERT INTO `carport`.`person` (`email`, `address`, `name`, `phonenumber`, `zipcode`) VALUES  (?,?,?,?,?)";
    public static String createOrder = "INSERT INTO carport.order (user_id) VALUES (?);";
    public static String insertUser = "insert into user (email, password, role) values (?,?,?);";

    //Create
    public static String createCarportRequest = "insert into carport.carport_request (length, width, rooftype, roofpitch, toolbox_length, toolbox_width, email) values (?,?,?,?,?,?,?);";

    // update
    public static String  updateUserPasswordById= "UPDATE carport.user SET password = '?' WHERE carport.user.id = '?'";

}
