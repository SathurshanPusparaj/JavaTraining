package com.dox.memberencap;

public class Application {

    public static void main(String[] args) {
       // BusStation.Bus buses = new BusStation().new Bus();

        BusStation busStation = new BusStation();
        busStation.addBus("Green");
        busStation.addBus(busStation.new Bus("Red"));
        busStation.addBus(new BusStation().new Bus("Blue"));

        for(BusStation.Bus bus: busStation.getBuses()){
            System.out.println(bus);
        }
    }
}
