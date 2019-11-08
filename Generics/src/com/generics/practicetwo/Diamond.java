package com.generics.practicetwo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Diamond {
    public static void main(String[] args) {

        //remove the boilerplate code around generic class instantiation

        List<String> list  = new ArrayList<>();

        //one limitation when creating Anonymous class
        Comparator<String> caseInsensitive = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareToIgnoreCase(s2);
            }
        };


    }
}
