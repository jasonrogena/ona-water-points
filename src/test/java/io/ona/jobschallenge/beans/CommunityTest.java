package io.ona.jobschallenge.beans;

import org.json.JSONArray;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertTrue;

/**
 * @author Jason Rogena - jasonrogena@gmail.com
 * @since v1.0-SNAPSHOT (15/06/2016)
 */
public class CommunityTest {

    @Test
    public void testAddWaterPoint() throws Exception {
        try {
            Community community = new Community("Test");
            community.addWaterPoint(new WaterPoint("Test", "2016-06-21", "yes"));
            community.addWaterPoint(new WaterPoint("Test", "2016-06-21", "no"));
            assertTrue(true);
        } catch (ParseException e) {
            assertTrue("Expected one water point, got an ParseException", false);
        }
    }

    @Test
    public void testInitCommunities() throws Exception {
        String twoUniqueVillagesString = "[{\"water_pay\":\"no\",\"respondent\":\"community\",\"research_asst_name\":\"Haruna Mohammed\",\"water_used_season\":\"year_round\",\"_bamboo_dataset_id\":\"\",\"_deleted_at\":null,\"water_point_condition\":\"functioning\",\"_xform_id_string\":\"_08_Water_points_CV\",\"other_point_1km\":\"no\",\"_attachments\":[\"north_ghana/attachments/1351696546452.jpg\"],\"communities_villages\":\"Gumaryili\",\"end\":\"2012-11-12T11:46:32.454Z\",\"animal_number\":\"more_500\",\"water_point_id\":\"xxx\",\"start\":\"2012-10-31T15:11:04.618Z\",\"water_connected\":\"no\",\"water_manager_name\":\"community members\",\"_status\":\"submitted_via_web\",\"enum_id_1\":\"5\",\"water_lift_mechanism\":\"no\",\"districts_divisions\":\"northern\",\"_uuid\":\"f8bcee72d7a0400fb99ae11bbf804010\",\"grid\":\"grid_further_500_m\",\"date\":\"2012-10-31\",\"formhub/uuid\":\"4d41d54d134c4bfa9078571addd819b9\",\"road_available\":\"no\",\"water_functioning\":\"yes\",\"_submission_time\":\"2012-11-13T07:13:57\",\"signal\":\"low\",\"water_source_type\":\"dam_dugout\",\"_geolocation\":[\"10.1892764\",\"-0.66410362\"],\"water_point_image\":\"1351696546452.jpg\",\"water_point_geocode\":\"10.1892764 -0.66410362 155.10000610351563 5.0\",\"deviceid\":\"355047040123780\",\"locations_wards\":\"west_mamprusi\",\"water_manager\":\"community\",\"water_developer\":\"community\",\"_id\":381705,\"animal_point\":\"yes\"},{\"water_pay\":\"no\",\"respondent\":\"community\",\"research_asst_name\":\"Haruna Mohammed\",\"water_used_season\":\"year_round\",\"_bamboo_dataset_id\":\"\",\"_deleted_at\":null,\"water_point_condition\":\"functioning\",\"_xform_id_string\":\"_08_Water_points_CV\",\"other_point_1km\":\"no\",\"_attachments\":[\"north_ghana/attachments/1351696546452.jpg\"],\"communities_villages\":\"Gumaryili\",\"end\":\"2012-11-12T11:46:32.454Z\",\"animal_number\":\"more_500\",\"water_point_id\":\"xxx\",\"start\":\"2012-10-31T15:11:04.618Z\",\"water_connected\":\"no\",\"water_manager_name\":\"community members\",\"_status\":\"submitted_via_web\",\"enum_id_1\":\"5\",\"water_lift_mechanism\":\"no\",\"districts_divisions\":\"northern\",\"_uuid\":\"f8bcee72d7a0400fb99ae11bbf804010\",\"grid\":\"grid_further_500_m\",\"date\":\"2012-10-31\",\"formhub/uuid\":\"4d41d54d134c4bfa9078571addd819b9\",\"road_available\":\"no\",\"water_functioning\":\"yes\",\"_submission_time\":\"2012-11-13T07:13:57\",\"signal\":\"low\",\"water_source_type\":\"dam_dugout\",\"_geolocation\":[\"10.1892764\",\"-0.66410362\"],\"water_point_image\":\"1351696546452.jpg\",\"water_point_geocode\":\"10.1892764 -0.66410362 155.10000610351563 5.0\",\"deviceid\":\"355047040123780\",\"locations_wards\":\"west_mamprusi\",\"water_manager\":\"community\",\"water_developer\":\"community\",\"_id\":381705,\"animal_point\":\"yes\"},{\"water_pay\":\"no\",\"respondent\":\"community\",\"research_asst_name\":\"Haruna Mohmmed\",\"water_used_season\":\"year_round\",\"_xform_id_string\":\"_08_Water_points_CV\",\"_bamboo_dataset_id\":\"\",\"_deleted_at\":null,\"water_point_condition\":\"functioning\",\"water_mechanism_plate\":\"no\",\"other_point_1km\":\"yes\",\"_attachments\":[\"north_ghana/attachments/1351701849971.jpg\"],\"water_lift_mechanism_type\":\"manual_power\",\"water_point_image\":\"1351701849971.jpg\",\"end\":\"2012-11-12T11:49:36.619Z\",\"animal_number\":\"50_to_500\",\"water_point_id\":\"xxx\",\"start\":\"2012-10-31T16:41:49.738Z\",\"water_connected\":\"no\",\"water_manager_name\":\"Amadu Salifu\",\"_status\":\"submitted_via_web\",\"enum_id_1\":\"5\",\"water_lift_mechanism\":\"yes\",\"districts_divisions\":\"northern\",\"_uuid\":\"c2f6b298955f47ab9f177bee1214141d\",\"road_type\":\"gravel\",\"grid\":\"grid_further_500_m\",\"date\":\"2012-10-31\",\"communities_villages\":\"Selinvoya\",\"formhub/uuid\":\"4d41d54d134c4bfa9078571addd819b9\",\"road_available\":\"yes\",\"water_functioning\":\"yes\",\"_submission_time\":\"2012-11-13T07:14:04\",\"signal\":\"high\",\"water_source_type\":\"unprotected_well\",\"_geolocation\":[\"10.28173052\",\"-0.56901122\"],\"water_point_geocode\":\"10.28173052 -0.56901122 201.89999389648438 5.0\",\"deviceid\":\"355047040123780\",\"locations_wards\":\"west_mamprusi\",\"water_manager\":\"individual\",\"water_developer\":\"community\",\"_id\":381706,\"animal_point\":\"yes\"}]";
        JSONArray data = new JSONArray(twoUniqueVillagesString);
        ArrayList<Community> communities = Community.initCommunities(data);
        if(communities.size() == 2) {
            assertTrue(true);
        } else {
            assertTrue("Expected two unique communities", false);
        }
    }


    @Test
    public void getCommunityDataWrongException() throws Exception{
        try {
            Community community = new Community("");
            assertTrue("Failed to catch community with a blank name", false);
        } catch (Community.DataWrongException e) {
            assertTrue(true);
        }

        try {
            Community community = new Community(null);
            assertTrue("Failed to catch community with a null", false);
        } catch (Community.DataWrongException e) {
            assertTrue(true);
        }

        try {
            Community community = new Community("  ");
            assertTrue("Failed to catch community with a whitespace name", false);
        } catch (Community.DataWrongException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testGetNoFunctionalWaterPoints() throws Exception {
        Community community = new Community("Test");
        community.addWaterPoint(new WaterPoint("Test", "2016-06-21", "yes"));
        community.addWaterPoint(new WaterPoint("Test", "2016-06-21", "no"));
        if(community.getNoFunctionalWaterPoints() == 1) {
            assertTrue(true);
        } else {
            assertTrue("Expected added one water point", false);
        }
    }

    @Test
    public void testGetNoNonFunctionalWaterPoints() throws Exception {
        Community community = new Community("Test");
        community.addWaterPoint(new WaterPoint("Test", "2016-06-21", "yes"));
        community.addWaterPoint(new WaterPoint("Test", "2016-06-21", "no"));
        if(community.getNoNonFunctionalWaterPoints() == 1) {
            assertTrue(true);
        } else {
            assertTrue("Expected added one water point", false);
        }
    }

    @Test
    public void testGetNoWaterPoints() throws Exception {
        Community community = new Community("Test");
        community.addWaterPoint(new WaterPoint("Test", "2016-06-21", "yes"));
        community.addWaterPoint(new WaterPoint("Test", "2016-06-21", "no"));
        if(community.getNoWaterPoints() == 2) {
            assertTrue(true);
        } else {
            assertTrue("Expected two water points", false);
        }
    }

    @Test
    public void testGetRatioBrokenWaterPoints() throws Exception {
        Community community1 = new Community("Test");
        community1.addWaterPoint(new WaterPoint("Test", "2016-06-21", "yes"));
        community1.addWaterPoint(new WaterPoint("Test", "2016-06-21", "no"));
        if(community1.getRatioBrokenWaterPoints() == 0.5d) {
            assertTrue(true);
        } else {
            assertTrue("Expected a ratio of 0.5", false);
        }

        Community community2 = new Community("Test");
        community2.addWaterPoint(new WaterPoint("Test", "2016-06-21", "yes"));
        if(community2.getRatioBrokenWaterPoints() == 0d) {
            assertTrue(true);
        } else {
            assertTrue("Expected a ratio of zero", false);
        }

        Community community3 = new Community("Test");
        community3.addWaterPoint(new WaterPoint("Test", "2016-06-21", "no"));
        if(community3.getRatioBrokenWaterPoints() == 1d) {
            assertTrue(true);
        } else {
            assertTrue("Expected a ratio of one", false);
        }
    }

    @Test
    public void testCompareTo() throws Exception {
        ArrayList<Community> communities = new ArrayList<Community>();
        Community community1 = new Community("Test1");
        community1.addWaterPoint(new WaterPoint("Test", "2016-06-21", "yes"));//0.5
        community1.addWaterPoint(new WaterPoint("Test", "2016-06-21", "no"));
        communities.add(community1);

        Community community2 = new Community("Test2");
        community2.addWaterPoint(new WaterPoint("Test", "2016-06-21", "yes"));//0
        communities.add(community2);

        Community community3 = new Community("Test3");
        community3.addWaterPoint(new WaterPoint("Test", "2016-06-21", "no"));//1
        communities.add(community3);

        Collections.sort(communities);

        if(communities.get(0).getName().equals("Test2") && communities.get(2).getName().equals("Test3")) {
            assertTrue(true);
        } else {
            assertTrue("Community sorting based on percentage of water points not working not correct", false);
        }
    }
}