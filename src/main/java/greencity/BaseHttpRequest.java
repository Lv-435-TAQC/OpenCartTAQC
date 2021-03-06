package greencity;

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
    Map<String, String> requestHeaders = new HashMap();
    private CloseableHttpClient httpClient;
    private HttpRequestBase httpRequestBase;
    private String response;
    private int statusCode;

    public BaseHttpRequest() {
        httpClient = HttpClients.createDefault();
    }

    public void setRequestHeaders(Map<String, String> requestHeaders) {

        this.requestHeaders = requestHeaders;
    }

    public String getRequest(String url) {
        httpRequestBase = new HttpGet(url);
        this.requestHeaders.forEach((key, value) -> httpRequestBase.setHeader(key, value));
        try (CloseableHttpResponse response = httpClient.execute(httpRequestBase)) {
            this.response = response.toString();
            this.statusCode = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
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
        try {
            stringEntity = new StringEntity(body);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        httpRequestBase.setEntity(stringEntity);
        this.requestHeaders.forEach((key, value) -> httpRequestBase.setHeader(key, value));
        httpRequestBase.setHeader("Content-type", "application/json");
        try (CloseableHttpResponse response = httpClient.execute(httpRequestBase)) {
            this.response = response.toString();
            this.statusCode = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
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
        this.requestHeaders.forEach((key, value) -> httpRequestBase.setHeader(key, value));
        httpRequestBase.setHeader("Content-type", "application/json");
        httpRequestBase.setEntity(stringEntity);
        try (CloseableHttpResponse response = httpClient.execute(httpRequestBase)) {
            this.response = response.toString();
            this.statusCode = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
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
        this.requestHeaders.forEach((key, value) -> httpRequestBase.setHeader(key, value));
        httpRequestBase.setHeader("Content-type", "application/json");
        try (CloseableHttpResponse response = httpClient.execute(httpRequestBase)) {
            this.response = response.toString();
            this.statusCode = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
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

    public String closeRequest(String url) {
        httpRequestBase = new HttpDelete(url);
        return httpRequestBase.toString();
    }

    public String deleteRequest(String url) {
        HttpDelete httpRequestBase = new HttpDelete(url);
        this.requestHeaders.forEach((key, value) -> httpRequestBase.setHeader(key, value));
        httpRequestBase.setHeader("Content-type", "application/json");
        try (CloseableHttpResponse response = httpClient.execute(httpRequestBase)) {
            this.response = response.toString();
            this.statusCode = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
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

    public String getResponse() {
        return this.response;
    }

    public int getStatusCode() {
        return this.statusCode;
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