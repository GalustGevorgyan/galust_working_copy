/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.di.bi.nextgen.installattribution.searchcountrycode;

import org.json.simple.parser.JSONParser;
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;

/**
 *
 * @author seryozha
 */
public class SearchCountryCode {

    public static void main(String[] args) throws Exception {
        Map<String, String> map = CSVReader();
        List<String> miss = new ArrayList<>();
        List<String[]> data = new ArrayList<>();
        String csv = "infinity.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(csv));
        List<String[]> outList = new ArrayList<>();
        JSONArray arry = ReadJson();
        for (String key : map.keySet()) {
            String[] arr = key.split(";");
            boolean isf = false;
            for (int i = 0; i < arry.length(); ++i) {
                JSONObject o = arry.getJSONObject(i);
                if (arr.length > 1) {
                    if (o.keySet().contains(arr[1].toUpperCase())) {
                        System.out.println("arr[]1" + arr[1]);
                        System.out.println("o.keySet() " + o.keySet());
                        System.out.println(" bu " + o.keySet().contains(arr[1].toUpperCase()));
                        JSONArray arryC = o.getJSONArray(arr[1].toUpperCase());
                        for (int j = 0; j < arryC.length(); ++j) {
                            String[] tmp = {map.get(key) + "," + key + ";" + arryC.getString(j)};
                            outList.add(tmp);
                        }
                        isf = true;
                        break;
                    }
                }
            }
            if (!isf) {
                miss.add(key);
                isf = false;
            }
        }
        writer.writeAll(outList);
        writer.close();
        System.out.println("Miissing" + miss);

    }

    public static org.json.JSONArray ReadJson() throws FileNotFoundException, IOException, ParseException {
        JSONParser parser = new JSONParser();
        File configFile = new File("test.json");
        String fileConfigurationContent = readFile(configFile.getPath());
        org.json.JSONArray jsonObj = new org.json.JSONArray(fileConfigurationContent);
        System.out.println("------------------------" + jsonObj.toString());
        Map<String, Object> map = new HashMap();
        return jsonObj;
    }

    public static Map<String, String> CSVReader() {
        CSVReader reader = null;
        Map<String, String> map = new HashMap<>();
        try {
            reader = new CSVReader(new FileReader("infinity3_and.csv"));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                map.put(nextLine[1], nextLine[0]);
            }
            reader.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        System.out.println("------------------------" + map.keySet().toString());
        return map;

    }

    public static String readFile(String filename) {
        String result = "";
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(filename));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            result = sb.toString();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SearchCountryCode.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SearchCountryCode.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
