package Model;
import Entity.AdminEntity;
/**
 *
 * @author DEMITRIUS
 */
public class AdminModel {
    private static AdminEntity[] admin = new AdminEntity[1];
    
    public void insert(String[] nama,String[] password){
        admin[0] = new AdminEntity(nama[0],password[0]);
    }
    public AdminEntity getAdmin(){
        return admin[0];
    }
    public boolean cekadmin(String nama,String password){
        if(admin[0].getNama().equals(nama)&&admin[0].getPassword().equals(password)){
            System.err.println("Login anda Berhasil!");
            
            return true;
        }
        else{
            System.err.println("Login anda Tidak Berhasil!");
            return false;
        }
     }
}
