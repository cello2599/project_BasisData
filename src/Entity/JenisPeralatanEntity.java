
package Entity;

/**
 *
 * @author DEMITRIUS
 */
public class JenisPeralatanEntity {
    private int id_jenis;
    private String nama;
    
    public JenisPeralatanEntity(){}
    
    public int getIdJenis(){
        return id_jenis;
    }
    public String getNama(){
        return nama;
    }
    public void setIdJenis(int id_jenis){
        this.id_jenis=id_jenis;
    }
    public void setNama(String nama){
        this.nama=nama;
    }
}
