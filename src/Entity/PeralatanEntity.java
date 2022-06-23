package Entity;

/**
 *
 * @author DEMITRIUS
 */
public class PeralatanEntity {
    private int id;
    private String nama;
    private int stok;
    private int id_jenis;
    private int id_ukuran;
    
   public PeralatanEntity(){}
   
   public int getId(){
       return id;
   }
   public String getNama(){
       return nama;
   }
   public int getStok(){
       return stok;
   }
   public int getIdJenis(){
       return id_jenis;
   }
   public int getIdUkuran(){
       return id_ukuran;
   }
   public void setId(int id){
       this.id=id;
   }
   public void setNama(String nama){
       this.nama=nama;
   }
   public void setStok(int stok){
       this.stok=stok;
   }
   public void setIdJenis(int id_jenis){
       this.id_jenis=id_jenis;
   }
   public void setIdUkuran(int id_ukuran){
       this.id_ukuran=id_ukuran;
   }
}
