import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

import org.json.JSONObject;
import okhttp3.*;

public class IdentifySong {
    private static final String API_URL = "https://api.audd.io/";
    private static final String API_KEY = "YOUR_API_KEY";

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide the path to the audio file.");
            return;
        }

        String filePath = args[0];
        File audioFile = new File(filePath);

        try {
            byte[] fileContent = Files.readAllBytes(audioFile.toPath());
            String encodedString = Base64.getEncoder().encodeToString(fileContent);

            OkHttpClient client = new OkHttpClient();
            RequestBody formBody = new FormBody.Builder()
                    .add("api_token", API_KEY)
                    .add("audio", encodedString)
                    .build();

            Request request = new Request.Builder()
                    .url(API_URL)
                    .post(formBody)
                    .build();

            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();

            JSONObject json = new JSONObject(responseBody);
            if (json.has("result")) {
                JSONObject result = json.getJSONObject("result");
                String title = result.getString("title");
                String artist = result.getString("artist");
                System.out.println("Song identified: " + title + " by " + artist);
            } else {
                System.out.println("Song could not be identified.");
            }

        } catch (IOException e) {
            System.out.println("Error reading the file or making the request: " + e.getMessage());
        }
    }
}
