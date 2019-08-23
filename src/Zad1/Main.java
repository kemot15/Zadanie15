package Zad1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            String path = "country.csv";
            Map<String, Country> countryMap = getCountryMap(path);
            System.out.println(getStatistic(countryMap));
        } catch (IOException e) {
            System.out.println("Sprawdz czy z plikiem wszystko OK");
        }
    }

    private static Map<String, Country> getCountryMap (String path) throws IOException {
        FileReader fr = new FileReader(new File(path));
        BufferedReader br = new BufferedReader(fr);
        Map<String, Country> countryMap = new HashMap<>();
        Country country;
        String line = null;
        while ( (line = br.readLine()) != null){
            String[] split = line.split(";");
             country = new Country(split[0], split[1], Integer.valueOf(split[2]));
            countryMap.put(country.getId(),country);
        }
        br.close();
        return countryMap;
    }

    private static String getStatistic (Map countryMap){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj kod kraju, ktory chcesz wyswietlic");
        String id = scanner.nextLine().toUpperCase();
        scanner.close();
        if (countryMap.containsKey(id))
            return countryMap.get(id).toString();
        else
            return "Brak takiego kraju";
    }
}
