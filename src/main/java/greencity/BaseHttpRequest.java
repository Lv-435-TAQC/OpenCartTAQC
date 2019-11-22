package greencity;

import com.sun.org.apache.xpath.internal.functions.FuncSubstring;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.sound.midi.SoundbankResource;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class BaseHttpRequest {
    URL url;
    HttpURLConnection connection;
    Integer statusCode;
    String response;

    public BaseHttpRequest(String url) {
        try {
            this.url = new URL(url);
            this.connection = (HttpURLConnection) this.url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setHeader(String method, Map<String, String> property) {
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
            byte[] input = s.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void getResponse() {
        StringBuilder response = new StringBuilder();
        try (
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        setResponse(response.toString());
    }

    public JSONObject getResponseJsonObject() {
        return new JSONObject(this.response);
    }

    public JSONArray getResponseJsonArray() {
        return new JSONArray(this.response);
    }
    public String getResponseString(){
        return this.response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
    public Integer getStatuusCode()
    {
        try {
            return this.connection.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}