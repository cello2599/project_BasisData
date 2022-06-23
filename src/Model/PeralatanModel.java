
package Model;
import Entity.PeralatanEntity;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author DEMITRIUS
 */
public class PeralatanModel extends ModelAbstract{
    private String sql;
    
    public ArrayList<PeralatanEntity> getPeralatan(){
   ArrayList<PeralatanEntity> peralatan= new ArrayList<>();
    
    try{
        Statement stat = conn.createStatement();
        sql = "SELECT *FROM peralatan";
        ResultSet rs = stat.executeQuery(sql);
        while(rs.next()){
            PeralatanEntity prl = new PeralatanEntity();
            prl.setId(rs.getInt("id_peralatan"));
            prl.setNama(rs.getString("nama_peralatan"));
            prl.setStok(rs.getInt("stok"));
            prl.setIdJenis(rs.getInt("id_jenisPeralatan"));
            prl.setIdUkuran(rs.getInt("id_ukuran"));
          
            peralatan.add(prl);
        }
    }catch(SQLException e){
        System.out.println(e);
    }
    return peralatan;
}

public void insertData(PeralatanEntity prltEntity){
    try{
        sql = "INSERT INTO peralatan (id_peralatan,nama_peralatan,stok,id_jenisPeralatan,id_ukuran) Values(?,?,?,?,?)";
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setInt(1, prltEntity.getId());
        stat.setString(2, prltEntity.getNama());
        stat.setInt(3, prltEntity.getStok());
        stat.setInt(4, prltEntity.getIdJenis());
        stat.setInt(5, prltEntity.getIdUkuran());
       
        
        int rows = stat.executeUpdate();
        if(rows > 0){
            System.err.println(rows + "input berhasil !!!");
        }
        else {
            System.out.println("GAGAL INPUT DATA");
        }
    }catch (SQLException e){
        System.out.println("GAGAL INPUT DATA");
    }
}



public void updateNama(String nama, int id){
    try{
        sql = "update peralatan SET nama_peralatan =? WHERE id_peralatan =?";
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setString(1, nama);
        stat.setInt(2, id);
        
       int rows = stat.executeUpdate();
        if(rows > 0){
            System.err.println(rows + "update berhasil !!!");
        }
        else {
            System.out.println(" ");
        }
    }catch (SQLException e){
        System.out.println("GAGAL UBAH Nama Peralatan !!!");
        e.printStackTrace();
    }
}
public void updateStok(int jum, int id){
    try{
        sql = "update peralatan SET stok=stok-? WHERE id_peralatan =?";
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setInt(1, jum);
        stat.setInt(2, id);
        int rows = stat.executeUpdate();
        if(rows > 0){
            System.err.println("Stok barang berkurang!!!");
        }
        else {
            System.out.println("GAGAL UBAH stok");
        }
    }catch (SQLException e){
        System.out.println("GAGAL UBAH stok !!!");
        e.printStackTrace();
    }
}
public void updateStokTam(int jum, int id){
    try{
        sql = "update peralatan SET stok=stok+? WHERE id_peralatan =?";
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setInt(1, jum);
        stat.setInt(2, id);
        int rows = stat.executeUpdate();
        if(rows > 0){
            System.err.println("Stok barang bertambah!!!");
        }
        else {
            System.out.println(" ");
        }
    }catch (SQLException e){
        System.out.println("GAGAL UBAH stok !!!");
        e.printStackTrace();
    }
}
public void DeletePeralatan(int id){
    try{
            sql = "DELETE FROM peralatan WHERE id_peralatan = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
           int rows = stat.executeUpdate();
        if(rows > 0){
            System.err.println("Delete berhasil!!!");
        }
        else {
            System.out.println(" ");
        }
        }catch(SQLException e){
            System.out.println("GAGAL Menghapus Peralatan !!!");
            e.printStackTrace();
        }
}
}
