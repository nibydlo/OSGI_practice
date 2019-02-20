package com.krylov.osgi;

import org.osgi.service.component.annotations.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component(
        service = MediaPortal.class,
        immediate = true
)
public class AifImpl extends MediaPortalAbstract implements MediaPortal {

    public String getMediaName() {
        return "aif";
    }

    public List<String> getNewsNames() {
        List<String> res = new ArrayList<>();
        try {
            URL url = new URL("http://www.aif.ru/rss/news.php");
            URLConnection urlConnection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            Pattern p = Pattern.compile("<title><!\\[CDATA\\[(.*?)]");
            for (String line; (line = reader.readLine()) != null; ) {
                Matcher m = p.matcher(line);
                while (m.find()) {
                    String s = m.group();
                    res.add(s.substring(16, s.length() - 1));
                }
            }
        } catch (MalformedURLException e) {
            System.err.println("Can't find url for aif: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Problems with input from aif: " + e.getMessage());
        }
        return res;
    }
}
