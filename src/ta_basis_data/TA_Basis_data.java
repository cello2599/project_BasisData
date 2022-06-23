package ta_basis_data;
import Controller.PeralatanController;
import Controller.JenisPeralatanController;
import Controller.UkuranPeralatanController;
import Controller.TransaksiController;
import Controller.ViewController;
import Model.AdminModel;
import Entity.*;
import Helper.KoneksiDb;
import java.util.Scanner;
/**
 *
 * @author DEMITRIUS
 */
public class TA_Basis_data {
public static PeralatanController peralatan = new PeralatanController();
public static JenisPeralatanController jnsPeralatan = new JenisPeralatanController();
public static UkuranPeralatanController ukrPeralatan = new UkuranPeralatanController();
public static TransaksiController transPeralatan = new TransaksiController();
public static ViewController view = new ViewController();
public static AdminModel admin = new AdminModel();
public static boolean cek;
public static Scanner input = new Scanner(System.in);
public static int pil,pilIn,pilUp,pilDel,pilView;
    public static void main(String[] args) {
        dataAdmin();
        System.out.println("+-------------------------------+");
        System.out.println("|     SELAMAT DATANG            |");
        System.out.println("|     LOGIN                     |");
        System.out.println("Nama : ");
        String nama = input.next();
        System.out.println("Password :");
        String password = input.next();
        cek=admin.cekadmin(nama, password);
        while(cek){
       do{
        System.out.println("+-------------------------------+");
        System.out.println("|     DATA PERALATAN CELO       |");
        System.out.println("+-------------------------------+");
        System.out.println("| 1. Insert Data                |");
        System.out.println("| 2. Update Data                |");
        System.out.println("| 3. Delete Data                |");
        System.out.println("| 4. View transaksi             |");
        System.out.println("| 5. Exit Menu                  |");
        System.out.print("Masukan pilihan : ");
        pil = input.nextInt();
                
           switch (pil){
               case 1 ->{
                   insert();
               }
               case 2->{
                   update();
                   }
               case 3 ->{
                   Delete();
               }
               case 4 ->{
                   view();        
               }
           }
       }while(pil<=4 && pil != 5 ); 
        System.err.print("ANDA TELAH KELUAR DARI SISTEM ");
        cek=false;
        }
    };
    
    static void dataAdmin(){
        String nama[] = {"marcelo"};
        String pass[]= {"123"};
        admin.insert(nama, pass);
    }
    
    static void insert(){
        do{
        System.out.println("------------------------");
        System.out.println("1. insert peralatan");
        System.out.println("2. insert Jenis peralatan");
        System.out.println("3. insert ukuran peralatan");
        System.out.println("4. insert transaksi");
        System.out.println("5. EXIT");
        System.out.println("Pilih insert :");
        pilIn = input.nextInt();
           switch(pilIn){ 
               case 1 ->{
        dataJenis();
        System.out.println("------------------------");
        dataUkuran();
        System.out.println("------------------------");
        System.out.print("Nama Peralatan : ");
        String nama = input.nextLine();
        nama +=input.nextLine();
        System.out.print("Stok : ");
        int stok = input.nextInt();
        System.out.print("id jenis peralatan : ");
        int id_jenis = input.nextInt();
        System.out.print("id ukuran peralatan : ");
        int id_ukuran= input.nextInt();
        peralatan.insertData(nama,stok,id_jenis,id_ukuran);   
    }
               case 2 -> {
        System.out.println("------------------------"); 
        System.out.print("Jenis peralatan : ");
        String jenis = input.nextLine();
        jenis +=input.nextLine();
        jnsPeralatan.insertJenisPrltn(jenis);
    }
               case 3-> {
        System.out.println("------------------------"); 
        System.out.print("Ukuran Peralatan : ");
        int ukr = input.nextInt();
        ukrPeralatan.insertUkrPrltn(ukr);   
    }
               case 4-> {
        dataPeralatan();
        System.out.println("------------------------");
        System.out.print("Jumlah peralatan : ");
        int jum = input.nextInt();
        System.out.print("id peralatan : ");
        int id = input.nextInt();
        transPeralatan.insertTransaksi(jum, id);
        peralatan.updateStok(jum, id);
               }
           }
        }while(pilIn!=5 && pilIn <5);
    }
    
    static void update(){
        do{
        System.out.println("------------------------");
        System.out.println("1. Update peralatan");
        System.out.println("2. Update Jenis peralatan");
        System.out.println("3. Update ukuran peralatan");
        System.out.println("4. Update Stok(tambah stok)");
        System.out.println("5. EXIT");
        System.out.println("Pilih update :");
        pilUp = input.nextInt();
            switch(pilUp){
                case 1 ->{
        dataPeralatan();
        System.out.println("------------------------");
        System.out.print("id peralatan  : ");
        int id = input.nextInt();
        System.out.print("Masukkan Nama Peralatan terbaru: ");
        String nama = input.nextLine();
        nama += input.nextLine();
        peralatan.updateNamaPeralatan(nama, id);
                }
                case 2->{
        dataJenis();
        System.out.println("------------------------");
        System.out.print(" id jenis peralatan  : ");
        int id = input.nextInt();
        System.out.print("Masukkan Nama Jenis Peralatan terbaru: ");
        String nama = input.nextLine();
        nama +=input.nextLine();
        jnsPeralatan.updateJenis(nama, id);
                }
                case 3 ->{
        dataUkuran();
        System.out.println("------------------------");
        System.out.print(" id ukuran peralatan  : ");
        int id = input.nextInt();
        System.out.print("Masukkan Ukuran Peralatan terbaru: ");
        int ukr = input.nextInt();
        ukrPeralatan.updateUkuran(ukr, id);
                }
                case 4 ->{
        dataPeralatan();
        System.out.println("------------------------");
        System.out.print("id peralatan  : ");
        int id = input.nextInt();
        System.out.print("Jumlah stok yang masuk : ");
        int jum = input.nextInt();
        peralatan.updateStokTam(jum, id);
                }
            }
        }while(pilUp < 5 && pilUp !=5);
    }
    
    static void Delete(){
    do{
        System.out.println("------------------------");
        System.out.println("1. Delete peralatan");
        System.out.println("2. Delete Jenis peralatan");
        System.out.println("3. Delete ukuran peralatan");
        System.out.println("4. EXIT");
        System.out.println("Pilih delete :");
        pilDel = input.nextInt();
            switch(pilDel){
                case 1->{
        dataPeralatan();
        System.out.println("------------------------");
        System.out.print("id peralatan yang ingin dihapus : ");
        int id = input.nextInt();
        peralatan.deleteData(id);
                }
                case 2->{
        dataJenis();
        System.out.println("------------------------");
        System.out.print("id jenis peralatan yang ingin dihapus  : ");
        int id = input.nextInt();
        jnsPeralatan.deleteJenis(id);
                }
                case 3->{
        dataUkuran();
        System.out.println("------------------------");
        System.out.print("id Ukuran peralatan yang ingin dihapus : ");
        int id = input.nextInt();
        ukrPeralatan.deleteUkuran(id);
                }
            }
    }while(pilDel<=4 && pilDel !=4);
    }
    
   static void view(){
    do{
        System.out.println("------------------------");
        System.out.println("1. View Detail Transaksi");
        System.out.println("2. View Detail Stok");
        System.out.println("3. EXIT");
        System.out.println("Pilih View :");
        pilView = input.nextInt();
        switch(pilView){
            case 1 ->{
                viewDetailTrans();
            }
            case 2 ->{
                viewDetailStok();
            }
        }
    }while(pilView != 3 && pilView < 3);
    }
   
    static void dataPeralatan(){
    for(PeralatanEntity prlt : peralatan.getDataPeralatan()){
                System.out.println("------------------------");
                System.out.println("id peralatan = "+ prlt.getId());
                System.out.println("Nama Peralatan = "+ prlt.getNama());
                System.out.println("Stok = "+ prlt.getStok());
                System.out.println("id jenis peralatan = "+ prlt.getIdJenis());
                System.out.println("id ukuran = "+ prlt.getIdUkuran());
                }
    }
    
    static void dataJenis(){
                System.out.println("||Data Jenis Peralatan||");
                for(JenisPeralatanEntity jnsprlt : jnsPeralatan.getDataJenis()){
                System.out.println("------------------------");
                System.out.println("id jenis peralatan = "+ jnsprlt.getIdJenis());
                System.out.println("Jenis Peralatan = "+ jnsprlt.getNama());
                }
    }
    
    static void dataUkuran(){
                System.out.println("||Data Ukuran Peralatan||");
                for(UkuranPeralatanEntity ukr : ukrPeralatan.getUkuran()){
                System.out.println("------------------------");
                System.out.println("id ukuran = "+ ukr.getIdUkuran());
                System.out.println("ukuran Peralatan = "+ ukr.getUkuran());
                }
    }
    
    static void viewDetailTrans(){
        System.out.println("|| Detail Transaksi ||");
        for(viewEntity vw : view.viewDetailTrans()){
        System.out.println("------------------------");
        System.out.println("nama peralatan = "+ vw.getNamPer());
        System.out.println("tgl barang keluar : "+ vw.getTgl());
        System.out.println("Jumlah Peralatan = "+ vw.getJum());
        System.out.println("Jenis Peralatan = "+ vw.getNamJen());
        System.out.println("Ukuran peralatan "+ vw.getUkr());
        }
    }
    
    static void viewDetailStok(){
        System.out.println("|| Detail Stok Peralatan ||");
        for(viewEntity vw : view.viewDetailStok()){
        System.out.println("------------------------");
        System.out.println("nama peralatan = "+ vw.getNamPer());
        System.out.println("Stok peralatan : "+ vw.getStok());
        System.out.println("Jenis Peralatan = "+ vw.getNamJen());
        System.out.println("Ukuran peralatan "+ vw.getUkr());
        }
    }
}

