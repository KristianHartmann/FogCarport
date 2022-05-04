package dat.startcode.model.persistence;

import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.apache.poi.ss.usermodel.CellType.*;
import static org.apache.poi.ss.usermodel.CellType.STRING;

public class ExcelMapper {

    ConnectionPool connectionPool;

    public ExcelMapper(ConnectionPool connectionPool)
    {
        this.connectionPool = connectionPool;
    }

    public HashMap<Integer, String> getDanishPostcodes() {
        HashMap<Integer, String> zipcodesMap = null;
        try {
            //File inputstream to read a file
            FileInputStream file = new FileInputStream(("C:\\Users\\Kristian Hartmann\\IdeaProjects\\FogCarport\\Resources\\DenmarkZipcode.xlsx"));

            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Dataformatter that formats numeric cell values to a String
            DataFormatter formatter = new DataFormatter();

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();

            ArrayList<Integer> postcodes = new ArrayList<>();
            ArrayList<String> citynames = new ArrayList<>();
            zipcodesMap = new HashMap<>();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();

                int count = 0;
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    String formattedString = formatter.formatCellValue(cell);

                    if (count % 2 == 0) {
                        postcodes.add(Integer.valueOf(formattedString));
                    } else {
                        citynames.add(formattedString);
                    }
                    count++;
                }
            }

            Iterator<Integer> zipcodeIterator = postcodes.iterator();
            Iterator<String> citynamesIterator = citynames.iterator();

            while (zipcodeIterator.hasNext() && citynamesIterator.hasNext()) {
                zipcodesMap.put(zipcodeIterator.next(), citynamesIterator.next());
            }


            for (Map.Entry<Integer,String> entry : zipcodesMap.entrySet()) {
                System.out.println("key: " + entry.getKey() + " value" + entry.getValue());
            }


            file.close();
            return zipcodesMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return zipcodesMap;
    }

    public static void main(String[] args) {
        ExcelMapper mapper = new ExcelMapper(new ConnectionPool());
        HashMap<Integer, String> zipcodes = mapper.getDanishPostcodes();

        for(Map.Entry<Integer, String> entry : zipcodes.entrySet()) {
            System.out.println(entry.getKey() + " " +  entry.getValue());
        }
    }

    public void insertPostcodes(HashMap<Integer, String> map) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");
//        HashMap<Integer, String> map = getDanishPostcodes();

        String sql = "INSERT INTO `carport`.`zipcode` (`zipcode`, `city`) VALUES (?,?)";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                for (Map.Entry<Integer,String> entry : map.entrySet()){
                    ps.setInt(1, entry.getKey());
                    ps.setString(2, entry.getValue());
                    int rowsAffected = ps.executeUpdate();
                    if (rowsAffected == 1)
                    {
                        System.out.println("success");
                    } else
                    {
                        System.out.println("fail");
                    }
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Could not insert zipcodes");
        }
    }

}
