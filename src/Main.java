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

        Car[] cars = new Car[size];

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

            cars[i] = new Car(model, bodyType, fuelType, topSpeed, acceleration);
        }

        Car[] sortedByModel = Car.sortedByModel(cars);
        Car[] sortedByTopSpeed = Car.sortedByTopSpeed(cars);

        System.out.println("\nArray sorted by model:");
        for (Car car : sortedByModel) {
            System.out.println(car.toString());
        }

        System.out.println("\nArray sorted by top speed:");
        for (Car car : sortedByTopSpeed) {
            System.out.println(car.toString());
        }
    }
}