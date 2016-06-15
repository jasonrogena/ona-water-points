package utils;

import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Jason Rogena - jasonrogena@gmail.com
 * @since v1.0-SNAPSHOT (15/06/2016)
 */
public class NetworkUtilsTest {
    private final String VALID_JSON_URL = "https://raw.githubusercontent.com/onaio/ona-tech/master/data/water_points.json";
    private final String INVALID_JSON_URL = "https://www.google.com";
    private final String INVALID_URL = "fdsaffdsfdfdfdsdsdsd";

    @Test
    public void testReadJSONFromUrl() throws Exception {
        try {
            assertThat(NetworkUtils.readJSONFromUrl(VALID_JSON_URL), CoreMatchers.instanceOf(JSONObject.class));
        } catch (Exception e) {
            assertTrue("Expected a JSONObject, got an Exception", false);
        }
    }

    @Test
    public void testReadJsonFromUrlIOException() {
        try {
            NetworkUtils.readJSONFromUrl(INVALID_URL);
            assertTrue("Expected an IOException, got a valid result", false);
        } catch (IOException e) {
            assertTrue(true);
        } catch (JSONException e) {
            assertTrue("Expected an IOException, got a JSONException", false);
        }
    }

    @Test
    public void testReadJsonFromUrlJSONException() {
        try {
            NetworkUtils.readJSONFromUrl(INVALID_JSON_URL);
            assertTrue("Expected an JSONException, got a valid result", false);
        } catch (IOException e) {
            assertTrue("Expected an JSONException, got a JSONException", false);
        } catch (JSONException e) {
            assertTrue(true);
        }
    }
}