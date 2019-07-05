package WikiServices;

import java.net.URL;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.io.IOException;

abstract class Request{

  protected HttpURLConnection connection;
  
  public Request(String uri) throws MalformedURLException, IOException {
   connection = (HttpURLConnection) new URL(uri).openConnection();
   setRequiredHeaders();
  }
  
  public abstract String execute() throws IOException;
  public abstract String execute(String body) throws IOException;

  private void setRequiredHeaders() {
   connection.setRequestProperty("Accept", "application/json");
   connection.setRequestProperty("Content-Type", "application/json");
  }
}