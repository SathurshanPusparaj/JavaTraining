package com.dox.encap;

import java.util.ArrayList;

public class BusStation {
    public static ArrayList<Bus> buses;

    static {
        buses = new ArrayList<>();
        buses.add((new Bus("Red")));
        buses.add((new Bus("Green")));
        buses.add((new Bus("White")));
        buses.add((new Bus("Blue")));
        buses.add((new Bus("Pink")));
    }
}
