package name.sergeychibunin.app;

public class RSSTool {

    public void get(String uri) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();

        HttpResponse<String> response =
                client.send(request, BodyHandlers.ofString());

        System.out.println(response.body());
    }
}