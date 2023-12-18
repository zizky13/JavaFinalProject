import com.sun.source.tree.WhileLoopTree;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class recreateMySQL {
    static String jdbc = "com.mysql.cj.jdbc.Driver";
    static String db_url = "jdbc:mysql://localhost:3306/zikar";
    static String user = "zikar";
    static String pass = "abarsiaevil32";

    static Connection conn;
    static Statement state;
    static ResultSet rs;

    public static void main(String[] args) {
        try {
            Class.forName(jdbc);
            conn = DriverManager.getConnection(db_url,user,pass);
            state = conn.createStatement();
            while (!conn.isClosed()){
                showMenu();
            }

            state.close();
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    static void showMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("============ MENU UTAMA ===========");
        System.out.println("1. Insert Username and Password");
        System.out.println("2. Check registered user");
        System.out.println("3. Update registered user");
        System.out.print("Pilihan> ");

        try{
            int pilihan = sc.nextInt();

            switch (pilihan){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    insertUser();
                    break;
                case 2:
                    showUser();
                    break;
                case 3:
                    updateUser();
                    break;
                default:
                    System.out.println("Pilihan salah!");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    static void insertUser(){
        Scanner sc = new Scanner(System.in);
        //reading user input
        try {
            System.out.println("Username: ");
            String username = sc.nextLine().trim();

            System.out.println("Password: ");
            String password = sc.nextLine().trim();

            //query simpan
            String sql = "INSERT INTO user (username, password) VALUE ('%s', '%s')";
            sql = String.format(sql, username, password);

            //simpan username
            state.execute(sql);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    static void showUser(){
        String sql = "SELECT * FROM user";
        try{
            rs = state.executeQuery(sql);
            System.out.println("+----------------------------------+");
            System.out.println("|        DATA USER TERSIMPAN       |");
            System.out.println("+----------------------------------+");
            while (rs.next()){
                int idUser = rs.getInt("id_user");
                String username = rs.getString("username");
                String password = rs.getString("password");

                System.out.println(String.format("%d. %s -- (%s)", idUser, username,password));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    static void updateUser(){
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("ID yang mau diedit: ");
            int idUser = sc.nextInt();
            sc.nextLine();

            System.out.println("Username: ");
            String username = sc.nextLine();


            System.out.println("Password: ");
            String password = sc.nextLine();

            String sql = "UPDATE user SET username='%s', password='%s' WHERE id_user = %d";
            sql = String.format(sql, username,password,idUser);

            state.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
