package SampleProject;

import GoogleServices.*;
import WikiServices.*;

import java.io.File; 
import java.io.BufferedReader;
import java.io.FileReader;


public class SampleProject{
 
  public static void main(String[] args) throws Exception{
    String configFilePath = "src/main/config/config";      
    File file = new File(configFilePath);
        
    BufferedReader br = new BufferedReader(new FileReader(file)); 
    String nextSearchTerm; 
    String responseBodyData ="";

    //read each search term from the config
    while ((nextSearchTerm = br.readLine()) != null){
     responseBodyData += "Search Term: " + nextSearchTerm +"\n";
     responseBodyData += WikiService.getArticle(nextSearchTerm);
     responseBodyData += "\n\n";
    } 

    //create new google doc and dump responseBodyData in doc
    GoogleDocsService gd = new GoogleDocsService();
    String id = gd.createNewDoc("SampleProjectDumpDoc",responseBodyData);
    System.out.println("Google doc created , document id: " + id + "\n");
  }
}