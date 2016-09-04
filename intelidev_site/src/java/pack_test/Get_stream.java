/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack_test;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import java.util.Scanner;

/* Can replace this with any base 64 encoder for basic authentication. For java 6 
 * installations on Sun's JRE you can use "sun.misc.BASE64Encoder" however this will 
 * not work in some installations (using OpenJDK).  Java mail 
 * (javax.mail.internet.MimeUtility) also contains a Base 64 encoder in Java 6.  A 
 * public domain version exists at http://iharder.sourceforge.net/current/java/base64/
 */
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author diogenes
 */
public class Get_stream {
  private static final String username = ""; // put your Device Cloud username here
    private static final String password = ""; // put your Device Cloud password here

    /**
     * Run the web service request
     */
    //public static void main(String[] args) {
    public void main() {
        HttpsURLConnection conn = null;

        try {
            // Create url to the Device Cloud server for a given web service request
            URL url = new URL("https://devicecloud.digi.com/ws/v1/streams/history/00000000-00000000-00409DFF-FF6064F8/xbee.analog/[00:13:A2:00:40:E6:5A:88]!/AD1");
            conn = (HttpsURLConnection) url.openConnection(); 
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("GET"); 
            
            // Build authentication string
            String userpassword = username + ":" + password;

            // can change this to use a different base64 encoder
            String encodedAuthorization = Base64.encodeBase64String(userpassword.getBytes()).trim();

            // set request headers
            conn.setRequestProperty("Authorization", "Basic "
                    + encodedAuthorization);
// Get input stream from response and convert to String
            InputStream is = conn.getInputStream();

            Scanner isScanner = new Scanner(is);
            StringBuffer buf = new StringBuffer();
            while (isScanner.hasNextLine()) {
                buf.append(isScanner.nextLine() + "\n");
            }
            String responseContent = buf.toString();

            // add line returns between tags to make it a bit more readable
            responseContent = responseContent.replaceAll("><", ">\n<");

            // Output response to standard out
            System.out.println(responseContent);
        } catch (Exception e) {
            // Print any exceptions that occur
            e.printStackTrace();
        } finally {
            if (conn != null)
                conn.disconnect();
        }
    }    
}
