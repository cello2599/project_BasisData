package Entity;
import java.util.Date;
/**
 *
 * @author DEMITRIUS
 */
public class TransaksiEntity {
    private int id;
    private Date tgl_keluar;
    private int jumlah;
    private int id_peralatan;
    public TransaksiEntity(){}
    
    public int getId(){
        return id;
    }
    public Date getDate(){
        return tgl_keluar;
    }
    public int getJumlah(){
         return jumlah;
    }
    public int getId_peralatan(){
        return id_peralatan;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setDate(Date tgl_keluar){
        this.tgl_keluar=tgl_keluar;
    }
    public void setJumlah(int jumlah){
        this.jumlah=jumlah;
    }
    public void setIdPeralatan(int id_peralatan){
        this.id_peralatan=id_peralatan;
    }
}
