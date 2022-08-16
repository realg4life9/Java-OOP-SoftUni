package Vehicles01;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] tokens = scanner.nextLine().split("\\s+");
        String vehicleType = tokens[0];
        double fuelQuantity = Double.parseDouble(tokens[1]);
        double fuelConsumption = Double.parseDouble(tokens[2]);

        Map<String,Vehicles> vehiclesMap = new LinkedHashMap<>();

            Vehicles car = new Car(fuelQuantity,fuelConsumption);
            vehiclesMap.put("Car",car);

            tokens = scanner.nextLine().split("\\s+");
            fuelQuantity = Double.parseDouble(tokens[1]);
            fuelConsumption = Double.parseDouble(tokens[2]);

        Vehicles truck = new Truck(fuelQuantity,fuelConsumption);
                vehiclesMap.put("Truck",truck);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
           tokens = scanner.nextLine().split("\\s+");
           String driveOrRefuel = tokens[0];
           String vehicle = tokens[1];
           switch (driveOrRefuel){
               case "Drive":
                   double distance = Double.parseDouble(tokens[2]);
                   if(vehicle.equals("Car")){
                       String driveMessage = vehiclesMap.get("Car").drive(distance);
                       System.out.println(driveMessage);
                   }else if (vehicle.equals("Truck")){
                       String driveMessage = vehiclesMap.get("Truck").drive(distance);
                       System.out.println(driveMessage);
                   }
                   break;
               case "Refuel":
                   double litersRefuel = Double.parseDouble(tokens[2]);
                   if(vehicle.equals("Car")){
                   vehiclesMap.get("Car").refuel(litersRefuel);
                   }else if (vehicle.equals("Truck")){
                   vehiclesMap.get("Truck").refuel(litersRefuel);
                   }
                   break;
           }
        }
        vehiclesMap.values().forEach(System.out::println);
    }
}
