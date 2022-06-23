package Helper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author DEMITRIUS
 */
public class KoneksiDb {
    public static Statement stmt = null;
    public static ResultSet rs;
    
    public static Connection getConnection(){
        Connection conn = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/db_peralatanmesin";
        String user = "root";
        String pass = "";
        
        try{
            Class.forName(driver);
            conn=DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
            //System.out.print("Berhasil Koneksi Database");
        }catch(Exception e){
            System.out.println("Gagal Koneksi Database");
            e.printStackTrace();
        }
        return conn;
    }
}

