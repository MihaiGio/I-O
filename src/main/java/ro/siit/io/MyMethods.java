package ro.siit.io;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.*;

public final class MyMethods {

    private MyMethods() {
    }

    public static List<CountryData> generateListOfCountryDataFromURL(final URL source) {
        List<CountryData> lines = new ArrayList<>();
        try {
            URLConnection connection = source.openConnection();
            String line;
            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                line = br.readLine();
                var firstRow = Arrays.asList(line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1));
                List<String> keyList = new ArrayList<>();
                keyList.addAll(firstRow);
                keyList.remove(0);
                keyList.remove(0);
                String acc = "";
                for (String s : keyList) {
                    String l = s.substring(5);
                    acc = acc + "," + l;
                }
                List<String> formattingKeys = Arrays.asList(acc.split(","));
                List<String> finalStringValues = new ArrayList<>();
                finalStringValues.addAll(formattingKeys);
                finalStringValues.remove(0);
                List<Integer> integerKey = new ArrayList<>();
                for (String s : finalStringValues) {
                    integerKey.add(Integer.parseInt(s));
                }
                while ((line = br.readLine()) != null) {
                    List<Map<Integer, String>> mapList = new ArrayList<>();
                    Map<Integer, String> map = new HashMap<>();
                    List<String> valueList = new ArrayList<>();
                    var values = Arrays.asList(line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1));
                    valueList.addAll(values);
                    valueList.remove(0);
                    valueList.remove(0);
                    Iterator<Integer> it1 = integerKey.iterator();
                    Iterator<String> it2 = valueList.iterator();
                    while (it1.hasNext() && it2.hasNext()) {
                        map.put(it1.next(), it2.next());
                    }
                    Collections.addAll(mapList, map);
                    var abc = new CountryData(values.get(0), mapList);
                    lines.add(abc);
                }
            } catch (Exception e) {
                System.err.println(e);
            }
        } catch (IOException i) {
            System.err.println(i);
        }
        return lines;
    }

    public static Integer getPopulationForCountryPerYear(final CountryData country, final int year) {
        Map<Integer, String> map = country.getKeyValue().get(0);
        String populationString = map.remove(year);
        Integer population = 0;
        try {
            population = Integer.parseInt(populationString);
            return population;
        } catch (NumberFormatException e) {
            System.out.println("No population for this year.");
        }
        return population;
    }

    public static Integer getAveragePopulationForCountry(final CountryData country) {
        Map<Integer, String> map = country.getKeyValue().get(0);
        Collection<String> values = map.values();
        List<String> stringValues = new ArrayList<>();
        stringValues.addAll(values);
        stringValues.removeAll(Arrays.asList("", null));
        List<Integer> intList = new ArrayList<>();
        for (String s : stringValues) {
            intList.add(Integer.parseInt(s));
        }
        double doubleValues = intList.stream().mapToDouble(i -> i).average().orElse(0.0);
        int intValues = (int)doubleValues;
        return intValues;
    }

}
