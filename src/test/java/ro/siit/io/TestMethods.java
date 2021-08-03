package ro.siit.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.net.URL;
import java.util.List;

class TestMethods {

    @Test
    void testPopulationForCountryPerYear() {
        try {
            var url = new URL("https://datahub.io/JohnSnowLabs/population-figures-by-country/r/0.csv");
            List<CountryData> items = MyMethods.generateListOfCountryDataFromURL(url);
            CountryData westBankAndGaza = items.get(193);
            CountryData aruba = items.get(0);
            CountryData bahamas = items.get(21);
            Assertions.assertEquals(Integer.valueOf(0), MyMethods.getPopulationForCountryPerYear(westBankAndGaza, 1988));
            Assertions.assertEquals(Integer.valueOf(54211), MyMethods.getPopulationForCountryPerYear(aruba, 1960));
            Assertions.assertEquals(Integer.valueOf(210661), MyMethods.getPopulationForCountryPerYear(bahamas, 1980));
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    @Test
    void testAveragePopulationForCountry() {
        try {
            var url = new URL("https://datahub.io/JohnSnowLabs/population-figures-by-country/r/0.csv");
            List<CountryData> items = MyMethods.generateListOfCountryDataFromURL(url);
            CountryData westBankAndGaza = items.get(193);
            CountryData aruba = items.get(0);
            CountryData bahamas = items.get(21);
            Assertions.assertEquals(Integer.valueOf(3198660), MyMethods.getAveragePopulationForCountry(westBankAndGaza));
            Assertions.assertEquals(Integer.valueOf(74712), MyMethods.getAveragePopulationForCountry(aruba));
            Assertions.assertEquals(Integer.valueOf(249515), MyMethods.getAveragePopulationForCountry(bahamas));
        } catch (IOException e) {
            System.err.println(e);
        }

    }

    @ParameterizedTest
    @ValueSource(ints = {1960, 1990, 2000, 2010, 2016})
    void testPopulationForCountryPerYearWithParameters(final int input) {
        try {
            var url = new URL("https://datahub.io/JohnSnowLabs/population-figures-by-country/r/0.csv");
            List<CountryData> items = MyMethods.generateListOfCountryDataFromURL(url);
            CountryData westBankAndGaza = items.get(193);
            ;
            switch (input) {
                case 1960 -> Assertions.assertEquals(Integer.valueOf(0), MyMethods.getPopulationForCountryPerYear(westBankAndGaza, input));
                case 1990 -> Assertions.assertEquals(Integer.valueOf(1978248), MyMethods.getPopulationForCountryPerYear(westBankAndGaza, input));
                case 2000 -> Assertions.assertEquals(Integer.valueOf(2922153), MyMethods.getPopulationForCountryPerYear(westBankAndGaza, input));
                case 2010 -> Assertions.assertEquals(Integer.valueOf(3811102), MyMethods.getPopulationForCountryPerYear(westBankAndGaza, input));
                case 2016 -> Assertions.assertEquals(Integer.valueOf(4551566), MyMethods.getPopulationForCountryPerYear(westBankAndGaza, input));
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {193, 0, 211, 262, 198})
    void testAveragePopulationForCountriesWithParameters(final int input) {
        try {
            var url = new URL("https://datahub.io/JohnSnowLabs/population-figures-by-country/r/0.csv");
            List<CountryData> items = MyMethods.generateListOfCountryDataFromURL(url);
            CountryData countries = items.get(input);
            ;
            switch (input) {
                case 193 -> Assertions.assertEquals(Integer.valueOf(3198660), MyMethods.getAveragePopulationForCountry(countries));
                case 0 -> Assertions.assertEquals(Integer.valueOf(74712), MyMethods.getAveragePopulationForCountry(countries));
                case 211 -> Assertions.assertEquals(Integer.valueOf(7435070), MyMethods.getAveragePopulationForCountry(countries));
                case 262 -> Assertions.assertEquals(Integer.valueOf(9396634), MyMethods.getAveragePopulationForCountry(countries));
                case 198 -> Assertions.assertEquals(Integer.valueOf(21243017), MyMethods.getAveragePopulationForCountry(countries));
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
