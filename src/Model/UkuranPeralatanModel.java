package Model;
import Entity.UkuranPeralatanEntity;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author DEMITRIUS
 */
public class UkuranPeralatanModel extends ModelAbstract {
    private String sql;
    public void insertData(UkuranPeralatanEntity ukr){
        try{
        sql = "INSERT INTO ukuran_peralatan (id_ukuran,ukuranPeralatan) Values (?,?)";
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setInt(1,ukr.getIdUkuran());
        stat.setInt(2,ukr.getUkuran());
        
        
        int rows = stat.executeUpdate();
        if(rows > 0){
            System.err.println(rows + "input berhasil");
        }
        else {
            System.out.println(" ");
        }
        }catch (SQLException e){
        System.out.println("GAGAL INPUT DATA");
    }
    }
    public void updateUkuran(int ukuran, int id){
    try{
        sql = "update ukuran_peralatan SET ukuranPeralatan =? WHERE id_ukuran =?";
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setInt(1, ukuran);
        stat.setInt(2, id);
        int result= stat.executeUpdate();
        if(result > 0){
            System.err.println("Update Ukuran berhasil !!!");
        }
        else {
            System.out.println("GAGAL Mengubah Ukuran !!!");
        }
    }catch (SQLException e){
        e.printStackTrace();
    }
}
    public void DeleteUkuran(int id){
        try{
            sql = "DELETE FROM ukuran_peralatan WHERE id_ukuran = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            
            int result= stat.executeUpdate();
        if(result > 0){
            System.err.println("Update Ukuran berhasil !!!");
        }
        else {
            System.out.println("GAGAL Menghapus Ukuran !!!");
        }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<UkuranPeralatanEntity> getData(){
        ArrayList<UkuranPeralatanEntity> ukuran = new ArrayList<>();
        try{
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM ukuran_peralatan";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                UkuranPeralatanEntity ukr = new UkuranPeralatanEntity();
                ukr.setIdUkuran(rs.getInt("id_ukuran"));
                ukr.setUkuran(rs.getInt("ukuranPeralatan"));
                
                ukuran.add(ukr);
            }   
        }catch(SQLException e){
            System.out.println(e);
        }
        return ukuran;
    }
}
