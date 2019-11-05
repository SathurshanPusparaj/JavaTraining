package com.generices.practiceone;

public class Application {
    public static void main(String[] args) {
        Car car = new Car();
        Bus bus = new Bus();

        Dog dog = new Dog();

        Vehicle<Car> carVehicle = new Vehicle<>(car);
        carVehicle.drive();

        Vehicle<Bus> busVehicle = new Vehicle<>(bus);
        busVehicle.drive();

        System.out.println();

        //Vehicle<Dog> dogVehicle = new Vehicle<>(dog); not work because it not implements any motorvehicle interface
        //dogVehicle.drive();

        ArrayPrinter arrayPrinter = new ArrayPrinter();
        Integer[] integers = {1,23,4,5,6};
        String[] strings = {"A","B","C","D"};
        arrayPrinter.printArray(integers);
        arrayPrinter.printArray(strings);

    }
}
