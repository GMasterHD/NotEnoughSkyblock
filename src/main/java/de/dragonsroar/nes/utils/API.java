package de.dragonsroar.nes.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import de.dragonsroar.nes.NotEnoughSkyblock;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class API {
    private static DefaultHttpClient client = new DefaultHttpClient();

    public static JsonObject get(String surl) {
        try {
            URL url = new URL(surl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Nes/1.0");

            if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
                String input;
                StringBuilder response = new StringBuilder();

                while((input = in.readLine()) != null) {
                    response.append(input);
                }
                in.close();
                
                Gson gson = new Gson();
                return gson.fromJson(response.toString(), JsonObject.class);
            }
        } catch(IOException e) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(NotEnoughSkyblock.ERROR_COLOR + "An error has occured. See logs for more details."));
            e.printStackTrace();
        }

        return new JsonObject();
    }
}
