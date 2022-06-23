package Model;
import java.sql.*;
import Entity.TransaksiEntity;
import Entity.JenisPeralatanEntity;
import Entity.UkuranPeralatanEntity;
import Entity.PeralatanEntity;
import java.time.LocalDate;
import java.util.Date;
import java.util.ArrayList;
/**
 *
 * @author DEMITRIUS
 */
public class TransaksiModel extends ModelAbstract {
    private String sql;
    
    public void insertTransaksi(TransaksiEntity trans){
        try{
            
        sql =String.format( "INSERT INTO transaksi (id_transaksi,tgl_barang_keluar,jumlah,id_peralatan) Values " +
                "('%s',now(),'%s','%s');",
                trans.getId(),
                trans.getJumlah(),
                trans.getId_peralatan()
        );
        PreparedStatement stat = conn.prepareStatement(sql);
        int rows = stat.executeUpdate();
        if(rows>0){
        System.out.println("Berhasil Menambah transaksi");
        }
        else{
        System.out.println("Gagal Menambah transaksi");    
        }
       }catch (SQLException e){
        e.printStackTrace();
    }
        
    }
   public void updateTransaksi(int jumlah, int id){
    try{
        sql = "update transaksi SET jumlah =? WHERE id_transaksi =?";
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setInt(1, jumlah);
        stat.setInt(2, id);
        stat.executeUpdate();
    }catch (SQLException e){
        System.out.println("GAGAL Mengubah Jumlah Transaksi !!!");
        e.printStackTrace();
    }
    }
   
   
}
