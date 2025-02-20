package org.datastructures.hashmap;

import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<String, String> birdCensus = new HashMap<>();

        birdCensus.put("mandarin duck", "Central Park Pond");
        birdCensus.put("monk parakeet", "Brooklyn College");
        birdCensus.put("horned owl", "Pelham Bay Park");

        birdCensus.remove("mandarin duck");

        System.out.println(birdCensus.get("mandarin duck"));
        System.out.println(birdCensus.get("monk parakeet"));
        System.out.println(birdCensus.get("horned owl"));

    }
}
