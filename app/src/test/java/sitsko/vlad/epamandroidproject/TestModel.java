package sitsko.vlad.epamandroidproject;

import com.google.gson.Gson;

import org.junit.Test;

import sitsko.vlad.epamandroidproject.model.BasicModel;

public class TestModel {

    @Test
    public void test(){

        String basicModelJson =
                "{\"section\": \"automobiles\",\"num_results\": 2, \"results\": [\"section\": \"Business\",\"title\": \"Crash Scene Investigations, With Automakers on the Case\", \"abstract\": \"Special teams dispatched by a number of manufacturers glean valuable information on what happens to vehicles and their occupants after a crash.\",\"byline\": \"By TOM VOELK\",\"published_date\": \"2019-05-09T06:00:04-04:00\",\"multimedia\": [ {\"url\": \"https://static01.nyt.com/images/2019/05/09/business/09wheels-1/09wheels-1-thumbStandard.jpg\",\"format\": \"Standard Thumbnail\"}],\"short_url\": \"https://nyti.ms/2LykNf1\"}]}"
                ;

        String basicModelJson1 = "{\n" +
                "  \"section\": \"automobiles\",\n" +
                "  \"num_results\": 2,\n" +
                "  \"results\": " +
              //  "[\n" +
                "    {\n" +
                "      \"section\": \"Business\",\n" +
                "      \"title\": \"Crash Scene Investigations, With Automakers on the Case\",\n" +
                "      \"abstract\": \"Special teams dispatched by a number of manufacturers glean valuable information on what happens to vehicles and their occupants after a crash.\",\n" +
                "      \"byline\": \"By TOM VOELK\",\n" +
                "      \"published_date\": \"2019-05-09T06:00:04-04:00\",\n" +
                "      \"multimedia\": [\n" +
                "        {\n" +
                "          \"url\": \"https://static01.nyt.com/images/2019/05/09/business/09wheels-1/09wheels-1-thumbStandard.jpg\",\n" +
                "          \"format\": \"Standard Thumbnail\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"short_url\": \"https://nyti.ms/2LykNf1\"\n" +
                "    }\n" +
               // "  ]\n" +
                "}";

        Gson gson = new Gson();

        BasicModel basicModel = gson.fromJson(basicModelJson1, BasicModel.class);
        System.out.println("end");
    }
}
