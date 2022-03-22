package EmployeMAnagement;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class EmployeeManagement {
    public EmployeeManagement() {
    }

    static void display(ArrayList<Employee> al) {
        System.out.println("\n            --------------Employee List---------------\n");
        System.out.println(String.format("%-10s%-15s%-10s%-20s%-10s", "ID", "Name", "salary", "contact-no", "Email-Id"));
        Iterator var2 = al.iterator();

        while(var2.hasNext()) {
            Employee e = (Employee)var2.next();
            System.out.println(String.format("%-5s%-20s%-10s%-15s%-10s", e.id, e.name, e.salary, e.contact_no, e.email_id));
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> al = new ArrayList();
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("C:/Users/deepanshusingh8/EmployeeDataList1.txt");
            if (f.exists()) {
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                al = (ArrayList)ois.readObject();
            }
        } catch (Exception var38) {
            System.out.println(var38);
        }

        while(true) {
            label246:
            while(true) {
                System.out.println("\n******Welcome to User Database******* \n");
                System.out.println("1). Add User Data \n2). List User Data \n3). Update User Data \n4). Delete User Data \n5). EXIT\n");
                System.out.println("Enter your choice : ");
                int ch = sc.nextInt();
                int id;
                switch(ch) {
                    case 1:
                        System.out.println("\nAdd the User Data for the Following fields \n");
                        System.out.println("User-ID :");
                        id = sc.nextInt();
                        System.out.println("Name :");
                        String name = sc.next();
                        System.out.println("Age :");
                       int Age = sc.nextInt();
                        System.out.println("Company-Name:");
                        String Cny=sc.next();
                        System.out.println("Designation:");
                        String ds=sc.next();
                        System.out.println("Salary :");
                        float Salary = sc.nextFloat();
                        System.out.println("Address :");
                        String Address = sc.next();
                        System.out.println("Phone Number :");
                        long pno=sc.nextLong();

                        try{
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employe","root","Dps12345701@");
                            String query = "insert into employedata(id,name,age,comapnay_name,designation,salary,adress,pno)"+ "values(?,?,?,?,?,?,?,?)";
                            //String query1 = "insert into login(id,password)"+ "values(?,?)";
                            PreparedStatement ps = con.prepareStatement(query);
                            //PreparedStatement ps1 = con.prepareStatement(query);
                            ps.setInt(1,id);
                            ps.setString(2,name);
                            ps.setFloat(3,Age);
                            ps.setString(4,Cny);
                            ps.setString(5,ds);
                            ps.setFloat(6,Salary);
                            ps.setString(7,Address);
                            ps.setLong(8,pno);


                            int i=ps.executeUpdate();
                            // ps1.executeUpdate();

                            if(i>0){
                                System.out.print("\n\n Data Inserted..\n\n");
                            }
                            else{
                                System.out.print("\n\n Data not Inserted..\n\n");
                            }

                        }catch(Exception e){
                            System.out.print(e);

                        }
//                        al.add(new Employee(id, name, salary, contact_no, email_id));
//                        display(al);
                        break;
                    case 2:
                        System.out.println("----------- User database records ------------------ ");
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employe", "root", "Dps12345701@");
                            Statement st = con.createStatement();
                            ResultSet rs = st.executeQuery("Select *from employedata");
                           while(rs.next()){
                               int id1 = rs.getInt("id");
                               String name1 = rs.getString("name");
                               int age1 = rs.getInt("age");
                               String cpn = rs.getString("comapnay_name");
                               String dsg = rs.getString("designation");
                               float sl = rs.getFloat("salary");
                               String ad = rs.getString("adress");
                               long pno1 = rs.getLong("pno");
                               System.out.format("%s ,%s, %s, %s, %s, %s, %s, %s" , id1,name1 , age1, cpn, dsg,sl,ad,pno1);
                               System.out.println();
                           }
                           st.close();
                        }catch(Exception e){

                        }


                        break;
                    case 3:
                        System.out.println("\nPlease enter the field that needs to be updated : ");

                        break;

                    case 4:
                        System.out.println("\nENTER THE RECORD THAT NEEDS TO BE DELETED:\n");
                        int id1 = sc.nextInt();
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employe", "root", "Dps12345701@");
                            Statement st = con.createStatement();
                            st.executeUpdate("delete from employedata where id = '"+id1+"'");
                            System.out.println("\ndata deleted successfully \n");

                        }
                        catch(Exception e){

                        }

                        break;

                    case 5:
                        try {
                            fos = new FileOutputStream(f);
                            oos = new ObjectOutputStream(fos);
                            oos.writeObject(al);
                        } catch (IOException var33) {
                            var33.printStackTrace();
                        } catch (Exception var34) {
                            var34.printStackTrace();
                        } finally {
                            try {
                                fis.close();
                                ois.close();
                                fos.close();
                                oos.close();
                            } catch (Exception var32) {
                                var32.printStackTrace();
                            }

                        }

                        System.out.println("\nYou have chosen EXIT !! Saving Files and closing the tool.");
                        sc.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("\nEnter a correct choice from the List :");
                }
            }
        }
    }
}
