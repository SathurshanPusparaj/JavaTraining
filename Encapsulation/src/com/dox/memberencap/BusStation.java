package com.dox.memberencap;

import java.util.ArrayList;

public class BusStation {
    private ArrayList<Bus> buses;

   /* public ArrayList<Bus> getBuses() {
        return buses;
    }*/

    public ArrayList<Bus> getBuses(){
        for(Bus bus:buses){
            //validate(bus.getColor());
            colorvalidate(bus.getColor());
        }
        return  buses;
    }

    public void setBuses(ArrayList<Bus> buses) {
        this.buses = buses;
    }

    public BusStation(){
        buses = new ArrayList<>();
    }
    public BusStation(String color) {
        buses.add(new Bus(color));
    }

    public void addBus(String color){
        buses.add(new Bus(color));
    }

    public void addBus(Bus bus){
        buses.add(bus);
    }

    public void validate(String color){//3rd level encapsulation

        class BusValidator{
            public void validate(){
                if("Red".equalsIgnoreCase(color)){
                    System.out.println("valid");
                }else{
                    System.out.println("invalid");
                }
            }
        }

        new BusValidator().validate();
    }

    public void colorvalidate(String color){//4th level encapsulation

        new Object(){
            public void validate(){
                if("Red".equalsIgnoreCase(color)){
                    System.out.println("valid");
                }else{
                    System.out.println("invalid");
                }
            }
        }.validate();//without create instance
    }


    class Bus {//2nd level encapsulation member class encapsulation
        private String color;

        public Bus() {
        }

        public Bus(String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Bus{" +
                    "color='" + color + '\'' +
                    '}';
        }
    }
}
