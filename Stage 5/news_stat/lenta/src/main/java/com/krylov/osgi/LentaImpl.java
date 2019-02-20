package com.krylov.osgi;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;

@Component(
        service = MediaPortal.class,
        immediate = true
)
public class LentaImpl extends MediaPortalAbstract implements MediaPortal {

    public String getMediaName() {
        return "lenta.ru";
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            return new JSONObject(jsonText);
        } finally {
            is.close();
        }
    }

    public List<String> getNewsNames() {
        ArrayList<String> res = new ArrayList<String>();
        try {
            JSONArray array = readJsonFromUrl("https://api.lenta.ru/lists/latest").getJSONArray("headlines");
            for (int i = 0; i < array.length(); i++) {
                JSONObject o = array.getJSONObject(i);
                if (o.get("type").equals("news")) {
                    res.add((String) o.getJSONObject("info").get("title"));
                }
            }
        } catch (IOException e) {
            System.err.println("Can't read news from lenta.ru: " + e.getMessage());
        }
        return res;
    }

}
