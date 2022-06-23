package Controller;
import Entity.TransaksiEntity;
import java.util.ArrayList;
/**
 *
 * @author DEMITRIUS
 */
public class TransaksiController {
    public void insertTransaksi(int jumlah,int id){
        TransaksiEntity trans = new TransaksiEntity();
        trans.setId(0);
        trans.setDate(null);
        trans.setJumlah(jumlah);
        trans.setIdPeralatan(id);
        AllObjectModel.transaksiModel.insertTransaksi(trans);
    }
    public void updateTransaksi(int jumlah,int id){
        AllObjectModel.transaksiModel.updateTransaksi(jumlah, id);
    }
}
