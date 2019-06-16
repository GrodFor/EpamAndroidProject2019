package sitsko.vlad.epamandroidproject.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ReadJsonFromFile {

    public static String loadJSONFromAsset(InputStream is) {
        String json = null;

        try {
            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;

    }
}
