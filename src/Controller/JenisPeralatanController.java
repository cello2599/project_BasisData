
package Controller;
import Entity.JenisPeralatanEntity;
import java.util.ArrayList;
/**
 *
 * @author DEMITRIUS
 */
public class JenisPeralatanController {
    public ArrayList<JenisPeralatanEntity> getDataJenis(){
        return AllObjectModel.jenisPeralatanModel.getData();
    }
    public void insertJenisPrltn(String jenis){
        JenisPeralatanEntity jns = new JenisPeralatanEntity();
        jns.setIdJenis(0);
        jns.setNama(jenis);
        AllObjectModel.jenisPeralatanModel.insertData(jns);
    }
    public void updateJenis(String nama,int id){
        AllObjectModel.jenisPeralatanModel.updateNama(nama, id);
    }
    public void deleteJenis(int id){
        AllObjectModel.jenisPeralatanModel.DeleteJenis(id);
    }
}
