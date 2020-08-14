/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Log;

/**
 *
 * @author DATA PC
 */
import java.io.*;  
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
public class Logs { 
     
    public static void MakeLog(String action) throws IOException{
        FileWriter writer = new FileWriter("C:\\Users\\DATA PC\\Documents\\NetBeansProjects\\JavaTutorials\\src\\java\\Log\\Logs.txt",true);  
    BufferedWriter buffer = new BufferedWriter(writer);  
    buffer.write("*) Date---> "  +LocalDate.now()+" "+ LocalTime.now()+ " <-----> Action-----> "+ action );
    buffer.newLine();
    buffer.close();  
    String Success = "**** Logging *****";
//    System.out.println (Success);
    }
    
} 
