package dat.startcode.model.persistence;

public class SQLStatements {

    public static String x = "";

    // delete
    public static String deleteOrderItem = "DELETE FROM orderitem WHERE order_id = ?;";
    public static String deleteOrder = "DELETE FROM `order` WHERE order_id = ?;";


    // select
    public static String selectCarportRequestByID = "select * from carport.carport_request where carport_request_id = ?";
    public static String selectAllCarportRequest = "SELECT * FROM carport.carport_request;";
    public static String selectAllUser = "select * from carport.user";
    public static String selectAllPerson = "select p.email, p.address, p.`name`, p.phonenumber, p.zipcode, z.city\n" +
            "            FROM person p\n" +
            "            INNER JOIN zipcode z on p.zipcode = z.zipcode";
    public static String selectAllOrderFromUserId = "select * from carport.order where user_id = ?";
    public static String selectAllOrder = "select * from carport.order";
    public static String selectMaxOrder = "SELECT MAX(order_id) FROM carport.order;";
    public static String selectAllParts = "SELECT * FROM parts";
    public static String selectUserFromEmailAndPassword = "SELECT * FROM user WHERE email = ? AND password = ?";
    public static String selectAllUserFromUserID= "select * from carport.user where user_id = ?";
    public static String selectUserIDFromEmail= "select user_id from carport.user where email = ?";
    public static String selectAllFromPersonByEmail= "select p.email, p.address, p.`name`, p.phonenumber, p.zipcode, z.city\n" +
            "FROM person p\n" +
            "INNER JOIN zipcode z on p.zipcode = z.zipcode\n" +
            "where p.email = '?'";
    public static String selectPartsListItemsFromID= "SELECT DISTINCT pli.amount, pli.`description`, p.`name`, p.`description`, p.length, p.unit, p.price\n" +
            "FROM partslistitem pli\n" +
            "INNER JOIN parts p ON pli.parts_id = p.parts_id\n" +
            "WHERE pli.partslistitem_id = ?";


    // insert
    public static String insertPerson = "INSERT INTO `carport`.`person` (`email`, `address`, `name`, `phonenumber`, `zipcode`) VALUES  (?,?,?,?,?)";
    public static String insertOrder = "INSERT INTO carport.order (user_id) VALUES (?);";
    public static String insertUser = "insert into `user` (email, password, role) values (?,?,?);";
    public static String insertCarportRequest = "insert into carport.carport_request (length, width, rooftype, roofpitch, toolbox_length, toolbox_width, email) values (?,?,?,?,?,?,?);";
    public static String insertPartsList = "insert into carport.partslist(carport_request_id) values (?)";
    public static String insertPartsListItem = "INSERT INTO partslistitem (amount, description, partslist_id, parts_id) VALUES (?, ?, ?, ?);";
    public static String insertOrderItem = "INSERT INTO `carport`.`orderitem` (`partslist_id`, `price`, `order_id`) VALUES ('?', '?', '?');";

    // update
    public static String  updateUserPasswordById= "UPDATE carport.user SET password = '?' WHERE carport.user.id = '?'";
    public static String  removeUserBalance = "UPDATE `carport`.`user` SET balance = balance - ? WHERE user_id = ?;";
    public static String  addUserBalanace = "UPDATE `carport`.`user` SET balance = balance + ? WHERE user_id = ?;";


}
