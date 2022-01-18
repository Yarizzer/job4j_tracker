package ru.job4j.oop;

public class VehicleManager {
    public static void main(String[] args) {
        Bus bus = new Bus();
        Train train = new Train();
        Airbus airbus = new Airbus();
        Vehicle[] vehicles = new Vehicle[] {bus, train, airbus};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            vehicle.stop();
        }
    }
}
