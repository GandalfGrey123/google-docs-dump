package WikiServices;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;

class Response {
  private int statusCode;
  private String result;
  private BufferedReader bodyReader;
  private HttpURLConnection connection;

  public Response(HttpURLConnection connection) throws IOException {
    this.result = "";
    this.connection = connection;
    this.createReader();
    if(statusCode!=406){ this.read(); }
  }

  public int getStatusCode() {
    return this.statusCode;
  }

  public String getBody() {
    return this.result;
  }

  private void createReader() {
    try {
      this.statusCode = connection.getResponseCode();
      if(connection.getResponseCode() == 406){
        return;
      }
      this.bodyReader = new BufferedReader(
         new InputStreamReader(connection.getInputStream())
      );
    } catch (IOException ioex) {
      this.bodyReader = new BufferedReader(
        new InputStreamReader(connection.getErrorStream())
      );
    }
  }

  private void read() throws IOException {
    String line;
    while ((line = bodyReader.readLine()) != null) {
      this.result = this.result + line;
    }
  }
}