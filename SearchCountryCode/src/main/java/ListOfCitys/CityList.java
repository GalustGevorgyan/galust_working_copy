/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListOfCitys;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Locale;
import org.json.simple.parser.JSONParser;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.geonames.*;
import org.json.simple.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author seryozha
 */
public class CityList {

    public static void main(String[] args) throws Exception {
        String zone = "EU;Z";
        String cN = getCountryName(zone);
    }

    public static JSONObject getCityNameForCountry(String countryName, String zipName) {
        List<String> cities = new ArrayList<>();
        List<String> citiesList = new ArrayList<>();
        JSONObject obj = new JSONObject();
        try {
            WebService.setUserName("nane");
            ToponymSearchCriteria searchCriteria = new ToponymSearchCriteria();
            searchCriteria.setQ(countryName);
            ToponymSearchResult searchResult;
            searchResult = WebService.search(searchCriteria);
            for (int i = 0; i < searchResult.getToponyms().size(); ++i) {
                cities.add(searchResult.getToponyms().get(i).getName());
            }
            for (int j = 0; j < 3; ++j) {
                citiesList.add(cities.get(new Random().nextInt(cities.size())));
            }
            obj.put(zipName, citiesList.toArray());
            return obj;
        } catch (Exception ex) {
            Logger.getLogger(CityList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    private static String getCountryName(String zone) throws IOException {
        String[] arry = zone.split(";"); //EU;DE
        zone = arry[1];
        String[] locales = Locale.getISOCountries();
        String countryName = "";
        JSONArray countryWithCities = new JSONArray();
        Map<String, List<String>> countryWithCityNames = new HashMap<>();
        for (String countryCode : locales) {
            Locale obj = new Locale("", countryCode);
            System.out.println("Country Code = " + obj.getCountry()
                + ", Country Name = " + obj.getDisplayCountry());
            countryWithCities.add(getCityNameForCountry(obj.getCountry(), countryCode));
            if (obj.getCountry().equalsIgnoreCase(zone)) {
                countryName = obj.getDisplayCountry();
                break;
            }
        }
        System.out.println("-----json array --- " + countryWithCities.toJSONString());
        try (FileWriter file = new FileWriter("test.json")) {
            file.write(countryWithCities.toJSONString());
        }
        return countryName;
    }
}
