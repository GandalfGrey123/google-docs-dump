package GoogleServices;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.docs.v1.Docs;
import com.google.api.services.docs.v1.model.Document;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class GoogleDocsService extends GoogleService{    

   private Docs googleDocService;
   private final NetHttpTransport HTTP_TRANSPORT;

   GoogleDocsService() throws IOException , GeneralSecurityException{
    HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
    googleDocService = new Docs.Builder(HTTP_TRANSPORT, getServiceJsonFactory(), getCredentials(HTTP_TRANSPORT))
            .setApplicationName("SampleProject")
            .build();
   }

   public void createNewDoc(String documentName) throws IOException{
     Document doc = new Document().setTitle(documentName);
              doc = googleDocService.documents().create(doc).execute();
   }
}