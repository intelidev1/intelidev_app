/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intelidev.dao;

import br.com.intelidev.entity.Dados;
import br.com.intelidev.entity.StreamDados;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.net.ssl.HttpsURLConnection;
import org.apache.commons.codec.binary.Base64;




/**
 *
 * @author diogenes
 */
public class DadosDao {
    
    public DadosDao(){
    
    }
    
    
    public List<Dados> get_stream_data(String stream_api, String user,String pass) {
        
        HttpsURLConnection conn = null;
        List<Dados> list_return = new ArrayList<>();
        int i;

        try {
            // Create url to the Device Cloud server for a given web service request
            //00000000-00000000-00409DFF-FF6064F8/xbee.analog/[00:13:A2:00:40:E6:5A:88]!/AD1
            ObjectMapper mapper = new ObjectMapper();
            URL url = new URL("https://devicecloud.digi.com/ws/v1/streams/history/"+stream_api);
            //URL url = new URL("https://devicecloud.digi.com/ws/v1/streams/history/00000000-00000000-00409DFF-FF6064F8/xbee.analog/[00:13:A2:00:40:E6:5A:88]!/AD1");
            conn = (HttpsURLConnection) url.openConnection(); 
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("GET"); 
            
            // Build authentication string
            String userpassword = user + ":" + pass;
            System.out.println(userpassword);

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
	// Convert JSON string to Object
            StreamDados stream = mapper.readValue(responseContent, StreamDados.class);
            //System.out.println(stream.getList());
            System.out.println(stream.getList().size());
            for(i=0;i<stream.getList().size();i++){
                list_return.add(stream.getList().get(i));
                //System.out.println("ts: "+ stream.getList().get(i).getTimestamp() + "Value: " + stream.getList().get(i).getValue());
                        
            }
            
            
        } catch (Exception e) {
            // Print any exceptions that occur
            System.out.println("br.com.intelidev.dao.DadosDao.get_stream_data() e" + e);
        } finally {
            if (conn != null)
                conn.disconnect();
        }
        
        return list_return;
    }        
    
    
    
    
}
