
package Entity;
import java.util.Date;
/**
 *
 * @author DEMITRIUS
 */
public class viewEntity {
    private Date tgl;
    private int jum,stok,ukr;
    private String namPer,namJen;
    public viewEntity(){}
    
    public void setTgl(Date tgl){
        this.tgl=tgl;
    }
    public void setJum(int jum){
        this.jum=jum;
    }
    public void setNamPer(String namPer){
        this.namPer=namPer;
    }
    public void setNamJen(String namJen){
        this.namJen=namJen;
    }
    public void setStok(int stok){
        this.stok=stok;
    }
    public void setUkr(int ukr){
        this.ukr=ukr;
    }
    public Date getTgl(){
        return tgl;
    }
    public int getJum(){
        return jum;
    }
    public String getNamPer(){
        return namPer;
    }
    public int getStok(){
        return stok;
    }
    public String getNamJen(){
        return namJen;
    }
    public int getUkr(){
        return ukr;
    }
}
