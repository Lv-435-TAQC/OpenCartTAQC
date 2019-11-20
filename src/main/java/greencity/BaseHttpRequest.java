package greencity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class BaseHttpRequest {
    URL url ;
    HttpURLConnection connection ;

    public BaseHttpRequest(String url){
        try {
            this.url = new URL(url);
            this.connection = (HttpURLConnection) this.url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setHeader(String method, Map<String,String> property){
        try {
            connection.setRequestMethod(method);
        } catch (ProtocolException e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, String> el : property.entrySet()) {
            connection.setRequestProperty(el.getKey(), el.getValue());
        }
    }

    public void sendRequest(String body) {
        String s = body;
        connection.setDoOutput(true);
        try (
                OutputStream os = connection.getOutputStream()) {
            byte[] input = s.getBytes("utf-8");
            os.write(input, 0, input.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getResponse(){
//        JSONObject jsonObject = null;
        StringBuilder response = new StringBuilder();
        try (
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(connection.getInputStream(), "utf-8"))) {

            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
//            System.out.println(response.toString());
//            jsonObject = new JSONObject(response.toString());

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.toString();
    }
    public  JSONObject getResponseJsonObject(){
        return new JSONObject(this.getResponse());
    }
    public JSONArray getResponseJsonArray(){
        return new JSONArray(this.getResponse());
    }
}