import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;


public class Load {
    

    public ArrayList<Buildings> getBuildings() throws SQLException{

        ArrayList<Buildings> buildingList = new ArrayList<>();

        String user = "root";
        String password = "";
        String url ="jdbc:mariadb://localhost:3306/argus";
        Connection conn = DriverManager.getConnection(url, user, password);
        
        String sql = "select * from buildings";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            Buildings build = new Buildings();

                build.id = rs.getInt("id");
                build.city = rs.getString("city");
                build.address = rs.getString("address");
                build.usage = rs.getString("busage");
                build.size = rs.getInt("size");
                build.price = rs.getDouble("price");

            buildingList.add(build);
            // System.out.println(rs.getString("city"));
        }
        conn.close();
        return buildingList;
    }
}
