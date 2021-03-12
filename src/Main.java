import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        int size;
        try {
            System.out.println("Enter array size:");
            size = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            size = 0;
        }

        ArrayList<Car> cars = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            System.out.println("Car #" + (i + 1));

            System.out.println("Enter model:");
            String model = scanner.nextLine();

            System.out.println("Enter body type:");
            String bodyType = scanner.nextLine();

            System.out.println("Enter fuel type:");
            String fuelType = scanner.nextLine();
            
            int topSpeed;
            double acceleration;

            try {
                System.out.println("Enter top speed:");
                topSpeed = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                topSpeed = 0;
            }
            
            try {
                System.out.println("Enter acceleration to 100 km/h:");
                acceleration = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                acceleration = 0;
            }

            cars.add(new Car(model, bodyType, fuelType, topSpeed, acceleration));
        }

        cars.sort(Car.compareByModel);
        System.out.println("\nArray sorted by model:");
        for (Car car : cars) {
            System.out.println(car.toString());
        }

        cars.sort(Car.compareByTopSpeed);
        System.out.println("\nArray sorted by top speed:");
        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }
}