package EmployeLogin;

import java.sql.*;
import java.util.*;

public class Employe {
    public static void main(String[] args) {
        int choice = 0;
        while(choice!=8008) {
            System.out.println("Welcome to the Employee Managment System");
            System.out.println("Please Authenticate System:");
            System.out.print("Enter Choice : \n 1 : Login \n 2 : Sign up \n 3 : Exit \n");
            int menu = 0;
            Scanner scn = new Scanner(System.in);
            menu = scn.nextInt();
            switch (menu) {
                case 1 -> {
                    boolean result = login();
                    if(result) {
                        System.out.print("Login success");
                    } else {
                        System.out.print("Login failed 11 ");
                        System.out.println("");
                    }
                }
                case 2 -> signup();
                case 3 -> choice = 8008;
            }

        }

    }
    static boolean login(){
        boolean loginSuccesfull=false;
        Scanner scn = new Scanner(System.in);
        String id1="",pass="";
        String id="",password="";
        System.out.print("Enter User Id :");
        id=scn.nextLine();
        System.out.print("Enter Password :");
        password=scn.nextLine();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employe","root","Dps12345701@");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select *from login");

            while(rs.next())
            {
                id1 = rs.getString(1);
                pass = rs.getString(2);

            }
            if(id.equals(id1) && password.equals(pass)) {
                loginSuccesfull = true;
            }
            else {
                loginSuccesfull = false;
            }
        }catch(Exception e){
            System.out.print(e);

        }

        return loginSuccesfull;
    }
    static void signup()
    {
        int loop = 0;
        int code =0;
        String id="",password="",name="";
        while(loop!=8008)
        {
            Scanner scn = new Scanner(System.in);
            System.out.print("signup : two-step verification : \n");
            code = scn.nextInt();
            if(code==8008)
            {
                Scanner data = new Scanner(System.in);
                System.out.print("Enter Id :");
                id = data.nextLine();
                System.out.print("Enter password :");
                password = data.nextLine();
                System.out.print("Enter name");
                name = data.nextLine();
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employe","root","Dps12345701@");
                    String query = "insert into signup(id,password,name)"+ "values(?,?,?)";
                    String query1 = "insert into login(id,password)"+ "values(?,?)";
                    PreparedStatement ps = con.prepareStatement(query);
                    PreparedStatement ps1 = con.prepareStatement(query1);
                    ps.setString(1,id);
                    ps.setString(2,password);
                    ps.setString(3,name);
                    ps1.setString(1,id);
                    ps1.setString(2,password);


                    int i=ps.executeUpdate();
                    ps1.executeUpdate();

                    if(i>0){
                        System.out.print("\n\n Data Inserted..\n\n");
                    }
                    else{
                        System.out.print("\n\n Data not Inserted..\n\n");
                    }

                }catch(Exception e){
                    System.out.print(e);

                }

            }
            else{
            System.out.print("wrong pin code\n\n");

           }
        }
    }
}
