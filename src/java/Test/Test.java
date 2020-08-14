package Test;

import Bean.Employees;
import Crud.CrudClass;
import Log.Logs;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException {
        CrudClass cc = new CrudClass();
        Logs logs = new Logs();
        LocalDate date = LocalDate.now();
//        inserting data into db
        Employees emp2 = new Employees();
        emp2.setName("Tosin");
        emp2.setEmail("Tosin@gmail.com");
        emp2.setPhone(33445);
        int status1 = cc.save(emp2);
        if (status1 == 1) {
            logs.MakeLog("Saving New Employees Data!!!");
            System.out.println(status1 + " New Data Has Been Inserted ");
        } else {
            logs.MakeLog("No New Data Was Saved!!!");
        }

        //editing data in db
        Employees emp3 = new Employees();
        emp3.setName("Tosin Lawal");
        emp3.setEmail("Seyi@gmail.com");
        emp3.setPhone(33445);
        int status2 = cc.update(emp3);
        if (status2 == 1) {
            logs.MakeLog("Editing An Employees Data!!!");
             System.out.println(status2 + " Data Has Been Edited ");
        } else {
            logs.MakeLog("No Data Was Edited!!!");
        }

        //deleting data from db
        int phone = 333445;
        int status3 = cc.delete(phone);
        if (status3 == 1) {
            logs.MakeLog("Deleted An Employees Data!!!");
        } else {
            logs.MakeLog("No Data Was Deleted!!!");
        }
        System.out.println(status3 + " Employee Data Was Deleted");

        //getting data from db
        List<Employees> emp = new ArrayList<Employees>();
        emp = cc.getAllEmployees();
        if (emp.size() >= 1) {
            logs.MakeLog("Fetching All Employees Data!!!");
             System.out.println(emp.size() + " Result Found");
        }else{
             logs.MakeLog("No Data Was Fetched!!!");
        }
        for (Employees element : emp) {
            System.out.println(element.name);
           
        }

    }
}
