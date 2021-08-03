package ro.siit.io;

import java.util.List;
import java.util.Map;

public class CountryData {

    private final List<Map<Integer, String>> keyValue;
    private final String country;

    public CountryData(final String country, final List<Map<Integer, String>> keyValue) {
        this.country = country;
        this.keyValue = keyValue;
    }

    public List<Map<Integer, String>> getKeyValue() {
        return keyValue;
    }

    @Override
    public String toString() {
        return "country= " + country +
                " keyValue=" + keyValue;
    }
}
