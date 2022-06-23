package Controller;
import Entity.UkuranPeralatanEntity;
import java.util.ArrayList;
/**
 *
 * @author DEMITRIUS
 */
public class UkuranPeralatanController {
    public void insertUkrPrltn(int ukuran){
        UkuranPeralatanEntity ukr = new UkuranPeralatanEntity();
        ukr.setIdUkuran(0);
        ukr.setUkuran(ukuran);
        AllObjectModel.ukuranPeralatanModel.insertData(ukr);
    }
    public void updateUkuran(int ukuran,int id){
        AllObjectModel.ukuranPeralatanModel.updateUkuran(ukuran, id);
    }
    public void deleteUkuran(int id){
        AllObjectModel.ukuranPeralatanModel.DeleteUkuran(id);
    }
    public ArrayList<UkuranPeralatanEntity>getUkuran(){
        return AllObjectModel.ukuranPeralatanModel.getData();
    }
}
