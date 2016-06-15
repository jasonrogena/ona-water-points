package beans;

import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.*;

/**
 * @author Jason Rogena - jasonrogena@gmail.com
 * @since v1.0-SNAPSHOT (15/06/2016)
 */
public class WaterPointTest {

    @Test
    public void waterPoint() throws Exception{
        try {
            new WaterPoint("Test", "2016-12-01", "yes");
        } catch (ParseException e) {
            assertTrue("Expected an initialized object, got a ParseException", false);
        }
    }

    @Test
    public void testIsBroken() throws Exception {
        WaterPoint waterPoint1 = new WaterPoint("Test", "2016-12-01", "yes");
        if(waterPoint1.isBroken() == false) {
            assertTrue(true);
        } else {
            assertTrue("Expected isBroken to be false", false);
        }

        WaterPoint waterPoint2 = new WaterPoint("Test", "2016-12-01", "no");
        if(waterPoint2.isBroken() == true) {
            assertTrue(true);
        } else {
            assertTrue("Expected isBroken to be true", false);
        }
    }
}