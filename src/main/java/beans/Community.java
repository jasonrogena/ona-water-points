package beans;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Carrier class for a community (village)
 *
 * @author Jason Rogena - jasonrogena@gmail.com
 * @since v1.0-SNAPSHOT (15/06/2016)
 */
public class Community implements Comparator<Community>, Comparable<Community> {
    private final String name;
    private final ArrayList<WaterPoint> functionalWaterPoints;
    private final ArrayList<WaterPoint> nonFunctionalWaterPoints;

    /**
     * Default constructor
     *
     * @param name  Name of the community/village
     * @throws DataWrongException
     */
    public Community(String name) throws DataWrongException{
        if(name == null) name = "";
        name = name.trim();
        if(name.length() > 0) {
            this.name = name;
            this.functionalWaterPoints = new ArrayList<WaterPoint>();
            this.nonFunctionalWaterPoints = new ArrayList<WaterPoint>();
        } else {
            throw new DataWrongException();
        }
    }

    /**
     * This method adds a water point to the community
     *
     * @param newWaterPoint The water point to be added
     */
    public void addWaterPoint(WaterPoint newWaterPoint) {
        if(newWaterPoint.isBroken() == true) {
            nonFunctionalWaterPoints.add(newWaterPoint);
        } else {
            functionalWaterPoints.add(newWaterPoint);
        }
    }

    /**
     * This method converts a JSONArray containing a list of waterpoints into communities (villages)
     *
     * @param rawData   The JSONArray containing waterpoints
     * @return  A list of communities
     */
    public static ArrayList<Community> initCommunities(JSONArray rawData) {
        HashMap<String, Community> communities = new HashMap<String, Community>();

        for(int i = 0; i < rawData.length(); i++) {
            JSONObject currRecord = rawData.getJSONObject(i);
            if(currRecord.has("communities_villages")) {
                try {
                    Community currCommunity = new Community(currRecord.getString("communities_villages"));
                    final String currName = currCommunity.name;
                    if(!communities.containsKey(currName)) {
                        communities.put(currName, currCommunity);
                    }

                    try {
                        WaterPoint currWaterPoint = new WaterPoint(currRecord.getString("water_point_id"), currRecord.getString("date"), currRecord.getString("water_functioning"));
                        communities.get(currName).addWaterPoint(currWaterPoint);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                } catch (DataWrongException e) {
                    e.printStackTrace();
                }
            }
        }

        return new ArrayList<Community>(communities.values());
    }

    public int getNoFunctionalWaterPoints() {
        return functionalWaterPoints.size();
    }

    public int getNoNonFunctionalWaterPoints() {
        return nonFunctionalWaterPoints.size();
    }

    public int getNoWaterPoints() {
        return getNoFunctionalWaterPoints() + getNoNonFunctionalWaterPoints();
    }

    /**
     * This method gets the ratio between broken water points to all all water points
     *
     * @return The ratio between number of broken water points and water points
     */
    public double getRatioBrokenWaterPoints() {
        int total = getNoWaterPoints();
        if(total > 0) {
            return ((double)getNoNonFunctionalWaterPoints()) / total;
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    public int compareTo(Community o) {
        return Double.compare(getRatioBrokenWaterPoints(), o.getRatioBrokenWaterPoints());
    }

    public int compare(Community o1, Community o2) {
        return o1.compareTo(o2);
    }

    public static class DataWrongException extends Exception {}
}
