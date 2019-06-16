package sitsko.vlad.epamandroidproject;

import com.google.gson.Gson;

import org.junit.Test;

import java.io.InputStream;
import java.util.Objects;

import sitsko.vlad.epamandroidproject.model.BasicModel;
import sitsko.vlad.epamandroidproject.util.ReadJsonFromFile;

public class TestModel {

    @Test
    public void test() {

        Gson gson = new Gson();

        InputStream is = (this.getClass().getClassLoader()).getResourceAsStream("response.json");

        String s = ReadJsonFromFile.loadJSONFromAsset(is);
        System.out.println(s);

        BasicModel basicModel = gson.fromJson(s, BasicModel.class);

        System.out.println("end");
    }
}
