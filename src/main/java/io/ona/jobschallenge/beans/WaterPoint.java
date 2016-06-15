package io.ona.jobschallenge.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Carrier class for a water point
 *
 * @author Jason Rogena - jasonrogena@gmail.com
 * @since v1.0-SNAPSHOT (15/06/2016)
 */
public class WaterPoint {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private static final String IS_WORKING_POSITIVE = "yes";
    private final String id;
    private final Date lastUpdate;
    private final boolean isBroken;


    public WaterPoint(String id, String lastUpdate, String isWorking) throws ParseException {
        if(id == null) id = "";

        this.id = id;//TODO: clean the id
        this.lastUpdate = DATE_FORMAT.parse(lastUpdate);
        if(isWorking != null && isWorking.equals(IS_WORKING_POSITIVE)) {
            isBroken = false;
        } else {
            isBroken = true;
        }
    }

    public String getId() {
        return id;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    /**
     * This method returns true if the water point is not functional
     *
     * @return  TRUE if water point is not functional
     */
    public boolean isBroken() {
        return isBroken;
    }
}
