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

    // read each search term from the config file
    // then make wiki API call with search term
 	String nextSearchTerm; 
 	String responseData ="";
  	while ((nextSearchTerm = br.readLine()) != null){
  	  responseData +=  WikiService.getArticle(nextSearchTerm);
  	  responseData += "\n\n";
  	} 

  	
  }
}


  