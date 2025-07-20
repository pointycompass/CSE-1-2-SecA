package others;

import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestHttpClient {
    public static void main(String[] args) throws Exception {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI("https://cse.buet.ac.bd/nsyss2021/")).build();
        HttpResponse<InputStream> httpResponse = httpClient.send(httpRequest,
                HttpResponse.BodyHandlers.ofInputStream());
        // HttpResponse<String> httpResponse = httpClient.send(httpRequest,
        // HttpResponse.BodyHandlers.ofString());
        // HttpResponse<Stream<String>> httpResponse = httpClient.send(httpRequest,
        // HttpResponse.BodyHandlers.ofLines());
        System.out.println(httpResponse.statusCode());
        System.out.println(httpRequest.method());
        HttpHeaders httpHeaders = httpResponse.headers();
        Map<String, List<String>> headerMap = httpHeaders.map();
        Set<String> headerKeys = headerMap.keySet();
        for (String key : headerKeys) {
            System.out.println(key + ", " + headerMap.get(key));
        }
        InputStream inputStream = httpResponse.body();
        int c;
        while ((c = inputStream.read()) != -1) {
            System.out.print((char) c);
        }
        // System.out.println(httpResponse.body());
        // httpResponse.body().forEach(e -> System.out.println(e));
    }
}
