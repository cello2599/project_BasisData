package Model;
import Entity.JenisPeralatanEntity;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author DEMITRIUS
 */
public class JenisPeralatanModel extends ModelAbstract {
    private String sql;
    
    public ArrayList<JenisPeralatanEntity> getData(){
        ArrayList<JenisPeralatanEntity> jns = new ArrayList<>();
        try{
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM jenis_peralatan";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                JenisPeralatanEntity jnsPrl = new JenisPeralatanEntity();
                jnsPrl.setIdJenis(rs.getInt("id_jenisPeralatan"));
                jnsPrl.setNama(rs.getString("nama_jenisPeralatan"));
                
                jns.add(jnsPrl);
            }   
        }catch(SQLException e){
            System.out.println(e);
        }
        return jns;
    }
    public void insertData(JenisPeralatanEntity jnsPrl){
        try{
        sql = "INSERT INTO jenis_peralatan (id_jenisPeralatan,nama_jenisPeralatan) Values (?,?)";
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setInt(1,jnsPrl.getIdJenis());
        stat.setString(2,jnsPrl.getNama());
        
        int result= stat.executeUpdate();
        if(result > 0){
            System.err.println("Insert Jenis peralatan berhasil !!!");
        }
        else {
            System.out.println("GAGAL INPUT DATA");
        }
        }catch (SQLException e){
            e.printStackTrace();
    }
    }
    public void updateNama(String nama, int id){
    try{
        sql = "update jenis_peralatan SET nama_jenisPeralatan =? WHERE id_jenisPeralatan =?";
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setString(1, nama);
        stat.setInt(2, id);
        int result = stat.executeUpdate();
        if(result > 0){
            System.err.println(result + "data ter update");
        }
        else {
            System.out.println("GAGAL INPUT DATA");
        }
        
    }catch (SQLException e){
        e.printStackTrace();
    }
}
    public void DeleteJenis(int id){
        try{
            sql = "DELETE FROM jenis_peralatan WHERE id_jenisPeralatan = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            int result = stat.executeUpdate();
        if(result > 0){
            System.err.println(result + "data di delete");
        }
        else {
            System.out.println("GAGAL Menghapus jenis Peralatan !!!");
        }
        }catch(SQLException e){
            System.out.println("GAGAL Menghapus jenis Peralatan !!!");
            e.printStackTrace();
        }
    }
}
