package Entity;

/**
 *
 * @author DEMITRIUS
 */
public class AdminEntity {
    private String nama;
    private String password;
    
    public AdminEntity(String nama,String password){
    this.nama=nama;
    this.password=password;
    }
    
    public String getNama(){
        return nama;
    }
    public String getPassword(){
        return password;
    }
    public void setNama(String nama){
        this.nama=nama;
    }
    public void setPassword(String password){
        this.password=password;
    }
}
