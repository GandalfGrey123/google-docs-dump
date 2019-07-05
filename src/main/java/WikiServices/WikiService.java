package WikiServices;

import java.io.IOException;

public class WikiService{ 
 public static String getArticle(String searchTerm) throws IOException{
  String uri = String.format(
   "https://en.wikipedia.org/w/api.php?action=opensearch&search=%s&limit=0&format=json",
    searchTerm
  ); 
  //return json string from get response body
  return new Get(uri).execute();
 }
}