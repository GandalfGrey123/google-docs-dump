package GoogleServices;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

import com.google.api.services.docs.v1.Docs;
import com.google.api.services.docs.v1.model.Document;

import com.google.api.services.docs.v1.model.Request;
import com.google.api.services.docs.v1.model.BatchUpdateDocumentRequest;
import com.google.api.services.docs.v1.model.BatchUpdateDocumentResponse;
import com.google.api.services.docs.v1.model.Location;
import com.google.api.services.docs.v1.model.InsertTextRequest;

import java.io.IOException;
import java.security.GeneralSecurityException;

import java.util.List;
import java.util.ArrayList;


public class GoogleDocsService extends GoogleService{    

   private Docs googleDocService;
   private final NetHttpTransport HTTP_TRANSPORT;

   public GoogleDocsService() throws IOException , GeneralSecurityException{
    HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
    googleDocService = new Docs.Builder(HTTP_TRANSPORT, getServiceJsonFactory(), getCredentials(HTTP_TRANSPORT))
            .setApplicationName("SampleProject")
            .build();
   }

   public void createNewDoc(String documentName) throws IOException{
     Document doc = new Document().setTitle(documentName);
              doc = googleDocService.documents().create(doc).execute();    
   }  
   
  public String createNewDoc(String documentName, String documentBodyText) throws IOException{
            Document doc = new Document().setTitle(documentName);                                                  
            doc = googleDocService.documents().create(doc).execute();


            List<Request> requests = new ArrayList<>();
            requests.add(new Request().setInsertText(new InsertTextRequest()
                    .setText(documentBodyText)
                    .setLocation(new Location().setIndex(1))));

            BatchUpdateDocumentRequest body = new BatchUpdateDocumentRequest().setRequests(requests);          
            BatchUpdateDocumentResponse response = googleDocService.documents()
                    .batchUpdate(doc.getDocumentId(), body).execute();

   return doc.getDocumentId();
  }
}