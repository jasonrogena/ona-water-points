/**
 * Main entry class
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

        }
        return null;
    }


}
