package Utilities;

import org.openqa.selenium.print.PrintOptions;

import javax.swing.plaf.PanelUI;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readConfig {
    Properties properties;
    public readConfig(){
        File src=new File("C:\\Users\\Administrator\\IdeaProjects\\eBankingProject\\configuration\\config.properties");
        try {
            FileInputStream fin =new FileInputStream(src);
            properties=new Properties();
            properties.load(fin);
        } catch (Exception e) {
            System.out.println("Error is : " +e.getMessage());
        }
    }
   public String chrome()
   {
       String Chrome=properties.getProperty("Chromepath");
       return Chrome;

   }
   public String fireFox(){
        String firefox=properties.getProperty("Firefoxpath");
        return firefox;
   }
   public String edgeDriver(){
        String Edge=properties.getProperty("IEpath");
        return Edge;
   }
   public String url(){
        String Url=properties.getProperty("baseUrl");
        return Url;
   }
   public String Uname()
   {
       String UserName=properties.getProperty("userName");
       return UserName;
   }
   public String psw(){
        String pass=properties.getProperty("Password");
        return pass;
   }

}
