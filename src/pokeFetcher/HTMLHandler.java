package pokeFetcher;
import java.io.*;
import java.net.*;

public class HTMLHandler {
	public HTMLHandler(){
		
	}
	
	public static String getHTML(String urlToRead) throws Exception {
      StringBuilder result = new StringBuilder();
      
      URL url = new URL(urlToRead);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB;     rv:1.9.2.13) Gecko/20101203 Firefox/3.6.13 (.NET CLR 3.5.30729)");
      
      InputStreamReader streamReader = new InputStreamReader(conn.getInputStream());
      BufferedReader reader = new BufferedReader(streamReader);
      String data = reader.readLine();
      while (data!= null) {
         result.append(data);
         data = reader.readLine();
      }
      reader.close();
      return result.toString();
   }

}
