package Crud;

import Bean.Employees;
import java.util.*;
import java.sql.*;

public class CrudClass {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/employee", "abc", "123");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public static int save(Employees e) {
        int status = 0;
        try {
            Connection con = CrudClass.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into employees(name,email,phone) values (?,?,?)");
            ps.setString(1, e.getName());
            ps.setString(2, e.getEmail());
            ps.setInt(3, e.getPhone());
            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int update(Employees e) {
        int status = 0;
        try {
            Connection con = CrudClass.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "update employees set name=?,email=? where phone=?");
            ps.setString(1, e.getName());
            ps.setString(2, e.getEmail());
            ps.setInt(3, e.getPhone());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int delete(int phone) {
        int status = 0;
        try {
            Connection con = CrudClass.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from employees where phone=?");
            ps.setInt(1, phone);
            status = ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public static Employees getEmployeeById(int phone) {
        Employees e = new Employees();

        try {
            Connection con = CrudClass.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from employees where phone=?");
            ps.setInt(1, phone);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setName(rs.getString(2));
                e.setPhone(rs.getInt(3));
                e.setEmail(rs.getString(4));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }

    public static List<Employees> getAllEmployees() {
        List<Employees> list = new ArrayList<Employees>();
        try {
            Connection con = CrudClass.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from employees");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employees e = new Employees();
                e.setName(rs.getString(1));
                e.setPhone(rs.getInt(2));
                e.setEmail(rs.getString(3));

                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
