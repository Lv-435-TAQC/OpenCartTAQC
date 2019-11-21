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
import java.util.Map;

public class BaseHttpRequest {
    CloseableHttpClient httpClient = HttpClients.createDefault();
    HttpRequestBase httpRequestBase;
    String response;
    String statusLine;
    int statusCode;
    private String url;

    public BaseHttpRequest(String url, String method) {
        this.url = url;
        switch (method) {
            case "GET": {
                httpRequestBase = new HttpGet(url);
                break;
            }
            case "POST": {
                httpRequestBase = new HttpPost(url);
                break;
            }
            case "PUT": {
                httpRequestBase = new HttpPut(url);
                break;
            }
            case "PATCH": {
                httpRequestBase = new HttpPatch(url);
                break;
            }
            case "DELETE": {
                httpRequestBase = new HttpDelete(url);
                break;
            }
        }
        this.url = url;
    }

    public void setHeader(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpRequestBase.addHeader(entry.getKey(), entry.getValue());
        }
    }

    public String sendRequest() {
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

    public String sendRequestWithBody( String body) {
        StringEntity stringEntity = null;
        try {
            stringEntity = new StringEntity(body);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

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

    public String getResponseString() {
        return response;
    }

    public JSONObject getResponseJsonObject() {
        return new JSONObject(this.response);
    }

    public JSONArray getResponseJsonArray() {
        return new JSONArray(this.response);
    }
}