package com.dox.encap;

public class Application {
    public static void main(String[] args) {
        for(Bus bus: BusStation.buses){
            System.out.println(bus);
        }
    }
}
