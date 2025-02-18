package org.datastructures.hashmap;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        HashMap aboutMe = new HashMap(3);
        aboutMe.assign("myFavoriteColor", "brown");
        System.out.println(aboutMe.retrieve("myFavoriteColor"));
    }
}
