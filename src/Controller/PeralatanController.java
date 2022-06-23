
package Controller;
import Entity.PeralatanEntity;
import java.util.ArrayList;
/**
 *
 * @author DEMITRIUS
 */
public class PeralatanController {
    public void insertData(String nama,int stok,int id_jenis,int id_ukuran){
        PeralatanEntity peralatan = new PeralatanEntity();
        peralatan.setId(0);
        peralatan.setNama(nama);
        peralatan.setStok(stok);
        peralatan.setIdJenis(id_jenis);
        peralatan.setIdUkuran(id_ukuran);
        AllObjectModel.peralatanModel.insertData(peralatan);
    }
    public void updateNamaPeralatan(String nama,int id){
        AllObjectModel.peralatanModel.updateNama(nama, id);
    }
    public void updateStok(int jum,int id){
        AllObjectModel.peralatanModel.updateStok(jum, id);
    }
    public void updateStokTam(int jum,int id){
        AllObjectModel.peralatanModel.updateStokTam(jum, id);
    }
    public void deleteData(int id){
        AllObjectModel.peralatanModel.DeletePeralatan(id);
    }
    
    public ArrayList<PeralatanEntity> getDataPeralatan(){
        return AllObjectModel.peralatanModel.getPeralatan();
    }
    
}
