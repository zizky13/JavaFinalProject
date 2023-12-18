//import sql driver
import com.sun.source.tree.WhileLoopTree;

import java.sql.*;
import java.io.*;


public class belajarMySQL {

    //setting up constant to connect to DB
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; //define which driver to use (differ each DB)
    static final String DB_URL = "jdbc:mysql://localhost:3306/zikar"; //define the address of DB that we want to connect
    static final String USER = "zikar"; //username of DB
    static final String PASS = "abarsiaevil32"; //password of DB

    //setup connection parameter
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;

    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);

    public static void main(String[] args) {
        //trying connection to DB
        //should be encapsulated within try - catch
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement(); //create statement object to execute SQL Query
            while(!conn.isClosed()){
                showMenu();
            }
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void showMenu(){
        System.out.println("========= MENU UTAMA =========");
        System.out.println("1. Insert Data");
        System.out.println("2. Show Data");
        System.out.println("3. Edit Data");
        System.out.println("4. Delete Data");
        System.out.println("0. Keluar");
        System.out.println("");
        System.out.print("Pilihan> ");

        try {
            int pilihan = Integer.parseInt(input.readLine());

            switch (pilihan) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    insertBuku();
                    break;
                case 2:
                    showData();
                    break;
                case 3:
                    updateBuku();
                    break;
                case 4:
                    deleteBuku();
                    break;
                default:
                    System.out.println("Pilihan salah!!");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    static void showData(){
        String sql = "SELECT * FROM buku";
        try{
            rs = stmt.executeQuery(sql);
            System.out.println("+--------------------------------+");
            System.out.println("|    DATA BUKU DI PERPUSTAKAAN   |");
            System.out.println("+--------------------------------+");
            while (rs.next()){
                int idbuku = rs.getInt("id_buku");
                String judul = rs.getString("judul");
                String pengarang = rs.getString("pengarang");

                System.out.println(String.format("%d. %s -- (%s)", idbuku, judul, pengarang));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    static void insertBuku(){
        try{
            //ambil input user
            System.out.print("Judul: ");
            String judul = input.readLine().trim();
            System.out.print("Pengarang: ");
            String pengarang = input.readLine().trim();

            //query simpan
            String sql = "INSERT INTO buku (judul, pengarang) VALUE ('%s', '%s')";
            sql = String.format(sql,judul,pengarang);

            //simpan buku
            stmt.execute(sql);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    static void updateBuku(){
        try{
            System.out.print("ID yang mau diedit: ");
            int idBuku = Integer.parseInt(input.readLine());
            System.out.print("Judul: ");
            String judul = input.readLine().trim();
            System.out.print("Pengarang: ");
            String pengarang = input.readLine().trim();

            //query update
            String sql = "UPDATE buku SET JUDUL='%s', pengarang='%s' WHERE id_buku=%d";
            sql = String.format(sql, judul, pengarang, idBuku);

            //update data buku
            stmt.execute(sql);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    static void deleteBuku() {
        try {

            // ambil input dari user
            System.out.print("ID yang mau dihapus: ");
            int idBuku = Integer.parseInt(input.readLine());

            // buat query hapus
            String sql = String.format("DELETE FROM buku WHERE id_buku=%d", idBuku);
            // hapus data
            stmt.execute(sql);

            System.out.println("Data telah terhapus...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
