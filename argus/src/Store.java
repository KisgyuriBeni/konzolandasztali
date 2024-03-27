import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


public class Store {

    public void save(ArrayList<Buildings> buildingList) throws SQLException{
        String user = "root";
        String password = "";
        String url = "jdbc:mariadb://localhost:3306/argus";

        Connection conn = DriverManager.getConnection(url, user, password);
        String sql = """
            insert into buildings 
            (id,city,address,busage,size,price)
            values
            (?,?,?,?,?,?)
            """;

        for (Buildings buildings : buildingList) {
            PreparedStatement ps =  conn.prepareStatement(sql);
            ps.setInt(1, buildings.id); 
            ps.setString(2, buildings.city);
            ps.setString(3, buildings.address);
            ps.setString(4, buildings.usage);
            ps.setInt(5, buildings.size); 
            ps.setDouble(6, buildings.price);
            ps.execute();
        }
        conn.close();
    } 
}
