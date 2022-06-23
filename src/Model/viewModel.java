
package Model;
import Entity.viewEntity;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author DEMITRIUS
 */
public class viewModel extends ModelAbstract{
    private String sql;
    public ArrayList<viewEntity> getDetailTrans(){
   ArrayList<viewEntity> view = new ArrayList<>();
    
    try{
        Statement stat = conn.createStatement();
        sql = "SELECT transaksi.tgl_barang_keluar, transaksi.jumlah, peralatan.nama_peralatan, jenis_peralatan.nama_jenisPeralatan, ukuran_peralatan.ukuranPeralatan "
                + "from transaksi inner join peralatan "
                + "on transaksi.id_peralatan=peralatan.id_peralatan "
                + "inner join jenis_peralatan "
                + "on jenis_peralatan.id_jenisPeralatan=peralatan.id_jenisPeralatan "
                + "inner join ukuran_peralatan "
                + "on ukuran_peralatan.id_ukuran=peralatan.id_ukuran "
                + "order by transaksi.id_transaksi asc";
        ResultSet rs = stat.executeQuery(sql);
        while(rs.next()){
            viewEntity vw = new viewEntity();
            vw.setNamPer(rs.getString("nama_peralatan"));
            vw.setTgl(rs.getDate("tgl_barang_keluar"));
            vw.setJum(rs.getInt("jumlah"));
            vw.setNamJen(rs.getString("nama_jenisPeralatan"));
            vw.setUkr(rs.getInt("ukuranPeralatan"));
            
          
            view.add(vw);
        }
    }catch(SQLException e){
        System.out.println(e);
    }
    return view;
}
   public ArrayList<viewEntity>getDetailStok(){
       ArrayList<viewEntity> view = new ArrayList<>();
       
       try{
        Statement stat = conn.createStatement();
        sql = "SELECT p.nama_peralatan, p.stok, j.nama_jenisPeralatan, u.ukuranPeralatan "
                + "from peralatan p inner join jenis_peralatan j "
                + "on p.id_jenisPeralatan=j.id_jenisPeralatan "
                + "inner join ukuran_peralatan u "
                + "on u.id_ukuran=p.id_ukuran";
        ResultSet rs = stat.executeQuery(sql);
        while(rs.next()){
            viewEntity vw = new viewEntity();
            vw.setNamPer(rs.getString("nama_peralatan"));
            vw.setStok(rs.getInt("stok"));
            vw.setNamJen(rs.getString("nama_jenisPeralatan"));
            vw.setUkr(rs.getInt("ukuranPeralatan"));
            
          
            view.add(vw);
        }
    }catch(SQLException e){
        System.out.println(e);
    }
    return view;
   }
    
}
