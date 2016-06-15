package io.ona.jobschallenge;

import io.ona.jobschallenge.beans.Community;
import org.json.JSONArray;
import org.json.JSONObject;
import io.ona.jobschallenge.utils.NetworkUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * io.ona.jobschallenge.Main entry class
 *
 * @author Jason Rogena - jasonrogena@gmail.com
 * @since v1.0-SNAPSHOT (15/06/2016)
 */
public class Main {
    public static final String DEFAULT_INPUT_URL = "https://raw.githubusercontent.com/onaio/ona-tech/master/data/water_points.json";
    public static void main(String[] args) {
        String inputUrl = DEFAULT_INPUT_URL;
        if(args.length == 1) {
            inputUrl = args[0];
        }

        String result = calculate(inputUrl);
        System.out.println("\n\nInput URL is : "+inputUrl+"\n");
        System.out.println("Output is :");
        System.out.println(result+"\n\n");
    }

    /**
     * Responsible for calculating the community water point values
     *
     * @param inputUrl  URL from where the water point data should be gotten
     *
     * @return  JSON encoded string representing the values or NULL if an error occurres
     */
    private static String calculate(String inputUrl) {
        if(inputUrl != null) {
            try {
                JSONArray rawData = NetworkUtils.readJSONFromUrl(inputUrl);
                ArrayList<Community> communities = Community.initCommunities(rawData);

                Collections.sort(communities, Collections.reverseOrder());

                JSONObject response = new JSONObject();
                int totalFunctional = 0;
                JSONObject commWaterPoints = new JSONObject();
                JSONArray commRanking = new JSONArray();

                for(Community currCommunity : communities) {
                    totalFunctional = totalFunctional + currCommunity.getNoFunctionalWaterPoints();
                    commWaterPoints.put(currCommunity.getName(), currCommunity.getNoWaterPoints());
                    commRanking.put(currCommunity.getName());
                }

                response.put("number_functional", totalFunctional);
                response.put("number_water_points", commWaterPoints);
                response.put("community_ranking", commRanking);
                return response.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}
