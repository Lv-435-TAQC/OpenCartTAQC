package greencity;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class BaseHttpRequest {
    private CloseableHttpClient httpClient;
    private HttpRequestBase httpRequestBase;
    private String response;
    private String statusLine;
    private int statusCode;
    
    private HashMap<String, String> requestHeaders = new HashMap();
    
    public HashMap<String, String> getRequestHeaders() {
        return requestHeaders;
    }
    
    public void setRequestHeaders(HashMap<String, String> requestHeaders) {
        this.requestHeaders = requestHeaders;
    }
    
    public BaseHttpRequest() {
        httpClient = HttpClients.createDefault();
    }

    public String getRequest(String url) {
        httpRequestBase = new HttpGet(url);
        this.requestHeaders.forEach((key, value)-> httpRequestBase.setHeader(key, value));
        try (CloseableHttpResponse response = httpClient.execute(httpRequestBase)) {
            this.response = response.toString();
            this.statusCode = response.getStatusLine().getStatusCode();
            this.statusLine = response.getStatusLine().toString();
            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
            if (entity != null) {
                this.response = EntityUtils.toString(entity);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.response;
    }

    public String postRequest(String url, String body) {
        HttpPost httpRequestBase = new HttpPost(url);
        StringEntity stringEntity = null;
        System.out.println(body);
        try {
            stringEntity = new StringEntity(body);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        httpRequestBase.setEntity(stringEntity);

        this.requestHeaders.forEach((key, value)-> httpRequestBase.setHeader(key, value));
        try (CloseableHttpResponse response = httpClient.execute(httpRequestBase)) {
            this.response = response.toString();
            this.statusCode = response.getStatusLine().getStatusCode();
            this.statusLine = response.getStatusLine().toString();
            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
            if (entity != null) {
                this.response = EntityUtils.toString(entity);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.response;
    }


    public String putRequest(String url, String body) {
        HttpPut httpRequestBase = new HttpPut(url);
        StringEntity stringEntity = null;
        try {
            stringEntity = new StringEntity(body);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        this.requestHeaders.forEach((key, value)-> httpRequestBase.setHeader(key, value));
        httpRequestBase.setEntity(stringEntity);
        try (CloseableHttpResponse response = httpClient.execute(httpRequestBase)) {
            this.response = response.toString();
            this.statusCode = response.getStatusLine().getStatusCode();
            this.statusLine = response.getStatusLine().toString();
            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
            if (entity != null) {
                this.response = EntityUtils.toString(entity);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.response;
    }

    public String patchRequest(String url, String body) {
        HttpPatch httpRequestBase = new HttpPatch(url);

        StringEntity stringEntity = null;
        try {
            stringEntity = new StringEntity(body);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        httpRequestBase.setEntity(stringEntity);
        this.requestHeaders.forEach((key, value)-> httpRequestBase.setHeader(key, value));
        try (CloseableHttpResponse response = httpClient.execute(httpRequestBase)) {
            this.response = response.toString();
            this.statusCode = response.getStatusLine().getStatusCode();
            this.statusLine = response.getStatusLine().toString();
            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
            if (entity != null) {
                this.response = EntityUtils.toString(entity);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.response;
    }


    public String deleteRequest(String url) {
        httpRequestBase = new HttpDelete(url);
        return this.response;
    }

    public String getResponse() {
        return this.response;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    private void close() throws IOException {
        httpClient.close();
    }

    public String parseJsonObject(String key) {
        JSONObject json = new JSONObject(response);
        return json.get(key).toString();
    }

    public String parseJsonArrays(String key, String nameOfParagraph) {
        JSONObject json = new JSONObject(response);
        return json.getJSONArray(nameOfParagraph).getJSONObject(0).getString(key);
    }

    public JSONObject getResponseJsonObject() {
        return new JSONObject(this.response);
    }

    public JSONArray getResponseJsonArray() {
        return new JSONArray(this.response);
    }
}