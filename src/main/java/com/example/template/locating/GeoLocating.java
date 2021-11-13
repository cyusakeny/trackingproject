package com.example.template.locating;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class GeoLocating {
    private static HttpURLConnection con;
    public static void main(String[] args) throws IOException {
        try{
            String query="http://ipwhois.app/json/197.243.61.202";
            URL url = new URL(query);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            StringBuilder content;
            try(BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream())
            )){
                String line;
                content = new StringBuilder();
                while ((line = in.readLine()) != null) {

                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
            JSONObject obj = new JSONObject(content.toString());
            String country = obj.getString("country");
            System.out.println("Country:"+country);
        }
        finally {
            con.disconnect();
        }
    }
}
