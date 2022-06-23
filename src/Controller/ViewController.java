
package Controller;
import Entity.viewEntity;
import java.util.ArrayList;
/**
 *
 * @author DEMITRIUS
 */
public class ViewController {
    public ArrayList<viewEntity> viewDetailTrans(){
        return AllObjectModel.view.getDetailTrans();
    }
    public ArrayList<viewEntity>viewDetailStok(){
        return AllObjectModel.view.getDetailStok();
    }
}
