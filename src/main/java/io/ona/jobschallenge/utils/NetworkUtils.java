package io.ona.jobschallenge.utils;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * This class holds utility methods for network actions
 *
 * @author Jason Rogena - jasonrogena@gmail.com
 * @since v1.0-SNAPSHOT (15/06/2016)
 */
public class NetworkUtils {

    /**
     * This method gets a JSONObject from a URL
     *
     * @param url
     * @return
     * @throws IOException
     * @throws JSONException
     */
    public static JSONArray readJSONFromUrl(String url) throws IOException, JSONException {
        InputStream inputStream = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            StringBuilder stringBuilder = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                stringBuilder.append((char) cp);
            }
            String jsonText = stringBuilder.toString();
            JSONArray json = new JSONArray(jsonText);
            return json;
        } finally {
            inputStream.close();
        }
    }
}
