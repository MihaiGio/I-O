Write an algorithm which is able to read CSV data from a URL. The data we're interested in is about country population by year. You can read such data from the following URL: https://datahub.io/JohnSnowLabs/population-figures-by-country/r/0.csv

The first row is the header, describing each column in the following rows. Here's how it looks like:

Country,Country_Code,Year_1960,Year_1961,Year_1962,Year_1963,Year_1964,Year_1965,Year_1966,Year_1967,Year_1968,Year_1969,Year_1970,Year_1971,Year_1972,Year_1973,Year_1974,Year_1975,Year_1976,Year_1977,Year_1978,Year_1979,Year_1980,Year_1981,Year_1982,Year_1983,Year_1984,Year_1985,Year_1986,Year_1987,Year_1988,Year_1989,Year_1990,Year_1991,Year_1992,Year_1993,Year_1994,Year_1995,Year_1996,Year_1997,Year_1998,Year_1999,Year_2000,Year_2001,Year_2002,Year_2003,Year_2004,Year_2005,Year_2006,Year_2007,Year_2008,Year_2009,Year_2010,Year_2011,Year_2012,Year_2013,Year_2014,Year_2015,Year_2016
One example row is the following:

Romania,ROU,18406905,18555250,18676550,18797850,18919126,19031576,19215450,19534242,19799831,20009141,20250398,20461567,20657957,20835681,21029429,21293583,21551634,21756096,21951464,22090488,22242653,22415169,22515389,22588790,22655940,22755427,22859269,22949430,23057662,23161458,23201835,23001155,22794284,22763280,22730211,22684270,22619004,22553978,22507344,22472040,22442971,22131970,21730496,21574326,21451748,21319685,21193760,20882982,20537875,20367487,20246871,20147528,20058035,19983693,19908979,19815481,19705301
Write a method which receives a java.net.URL object as parameter. Please consult the documentation for the URL class: https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/net/URL.html

The method will then retrieve an InputStream from that URL. Find the appropriate method in the URL documentation. Using that InputStream you are now able to read information from that network location. Since CSV data is actually a piece of text, please use the appropriate class to read strings from the stream (think about the types of data we learned about when dealing with input/output: bytes streams, characters streams, text streams).

Once you have the lines of text, you have to parse them, so that you can use the information. For that, please design the domain model: let's say you will have a type CountryData, which represents the data from a CSV row. This type will have a field country and a map which holds the pairs (year, population) for each year present in the CSV.

Be careful when you parse the data to extract the country, some country names are presented in this form: "Korea, Rep.". This requires some more thinking to get it right.

The method will return a list of CountryData objects.

Write another method which receives a CountryData object, and a number representing a year as parameters. It returns the population of that country for the specified year.

Write another method which receives a CountryData object as parameter and returns the average population of that country, considering all the years.

Write unit tests which verify the last two methods described. Please don't write a main() method; I'm only interested in how well can you test your methods using JUnit 5.

Grading criteria
Grading Criteria:

the URL class is properly used
the IO API is correctly used - the decorated classes are correctly instantiated
the content of the remote file is read line by line (not byte by byte and not character by character)
exceptions are correctly handled
try-with-resources is used
Java style guidelines are followed
source code is properly formatted
private GitHub repository
Git repository in Moodle
interfaces are favored over implementations
collections are properly used
collection streams are properly used
lambda expressions are properly used
