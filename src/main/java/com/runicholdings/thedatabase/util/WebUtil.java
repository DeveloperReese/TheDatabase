package com.runicholdings.thedatabase.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

public class WebUtil {

    public static HashMap<String, String> getList() {
        HashMap<String, String> toReturn = new HashMap<>();
        try {

            URL url = new URL("https://api.thedatabase.cc/getBanList.php");

            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            String line = reader.readLine();

            String[] lineSplit = line.split("\\|");

            for (String str : lineSplit) {
                String[] split = str.split(",");

                String reason = StringUtil.stringBuilder(split, 1, true).replace("||", "");

                toReturn.put(split[0], reason);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return toReturn;
    }
}
