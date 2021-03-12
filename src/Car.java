/**
 * Class describes car and contains five fields
 * for five different parameters
 * @author Dmytro Zykov
 * @version 1.11
 */

public class Car {

    public enum BodyType {
        NONE ("None"),
        HATCHBACK ("Hatchback"),
        SEDAN ("Sedan"),
        COUPE ("Coupe"),
        MINIVAN ("Minivan"),
        SPORTS_CAR ("Spots car"),
        PICKUP_TRUCK ("Pickup truck");

        // String equivalent to the enumerator value
        public final String string;

        // Enum constructor
        BodyType(String string) {
            this.string = string;
        }

        // Get the string equivalent of the enum value
        @Override
        public String toString() {
            return this.string;
        }

        // Compare for equality of the given string and the string equivalent of the enum value
        public boolean stringEquals(String string) {
            return string.equals(this.string);
        }
    }

    public enum FuelType {
        NONE ("None"),
        PETROL ("Petrol"),
        DIESEL ("Diesel"),
        GASOLINE ("Gasoline"),
        ELECTRICITY ("Electricity");

        // String equivalent to the enumerator value
        public final String string;

        // Enum constructor
        FuelType(String string) {
            this.string = string;
        }

        // Get the string equivalent of the enum value
        @Override
        public String toString() {
            return this.string;
        }

        // Compare for equality of the given string and the string equivalent of the enum value
        public boolean stringEquals(String string) {
            return string.equals(this.string);
        }
    }
    
    // Private fields
    private String model;
    private BodyType bodyType;
    private FuelType fuelType;
    private int topSpeed;
    private double acceleration;

    /**
     * Constructor with no attributes
     * @see Car#Car(String, String, String, int, double)
     */
    Car() {
        this.model = "NONE";
        this.bodyType = BodyType.NONE;
        this.fuelType = FuelType.NONE;
        this.topSpeed = 0;
        this.acceleration = 0;
    }

    /**
     * Constructor with defined attributes
     * 
     * @param model the car model
     * @param bodyType the car body type
     * @param fuelType  the type of fuel
     * @param topSpeed  the car's top speed in km/h
     * @param acceleration  the car's acceleration to 100 km/h time in seconds
     */
    Car(String model, String bodyType, String fuelType, int topSpeed, double acceleration){

        setModel(model);
        setBodyType(bodyType);
        setFuelType(fuelType);
        setTopSpeed(topSpeed);
        setAcceleration(acceleration);
    }
    
    /**
     * Method that return car's model name {@link Car#model}
     * 
     * @return the model of car
     */
    public String getModel() {
        return this.model;
    }

    /**
     * Method to set car's model name {@link Car#model}
     * 
     * @param model the name of car
     */
    public void setModel(String model) {

        if (model.length() == 0) {
            this.model = "NONE";
        } else {
            this.model = model;
        }
    }

    /**
     * Method that returns enum type of body {@link Car#bodyType}
     * 
     * @return enum body type
     */
    public BodyType getBodyType() {
        return this.bodyType;
    }

    /**
     * Method to set the car's body type based on enum variable{@link Car#bodyType}
     * 
     * @param bodyType enum body type
     */
    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    /**
     * Method to set the car's body type based on string variable{@link Car#bodyType}
     * 
     * @param bodyType enum body type
     */
    public void setBodyType(String bodyType) {
        // Loop through the enum values
        for (BodyType element : BodyType.values()) {
            // Check if there is such a value
            if (element.stringEquals(bodyType)) {
                this.bodyType = element;
                return;
            }
        }

        // If not set body type to NONE
        this.bodyType = BodyType.NONE;
    }

    /**
     * Method that returns the type of fuel the car uses {@link Car#fuelType}
     * 
     * @return the car's fuel type
     */
    public FuelType getFuelType() {
        return this.fuelType;
    }

    /**
     * Method to set the car's fuel type based on enum value {@link Car#fuelType}
     * 
     * @param fuelType fuel type
     */
    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    /**
     * Method to set the car's fuel type based on string value {@link Car#fuelType}
     * Works the same way as setBodyType
     * @see Car#setBodyType(String)
     * 
     * @param fuelType fuel type
     */
    public void setFuelType(String fuelType) {
        for (FuelType element : FuelType.values()) {
            if (element.stringEquals(fuelType)) {
                this.fuelType = element;
                return;
            }
        }

        this.fuelType = FuelType.NONE;
    }

    /**
     * Method that returns the car's top speed in km/h {@link Car#topSpeed}
     * 
     * @return the top speed in km/h
     */
    public int getTopSpeed() {
        return this.topSpeed;
    }

    /**
     * Method to set the top speed of the car {@link Car#topSpeed}
     * 
     * @param topSpeed the top speed in km/h
     */
    public void setTopSpeed(int topSpeed) {
        this.topSpeed = Math.max(topSpeed, 0);
    }

    /**
     * Method that returns time that car takes to accelerate to 100 km/h {@link Car#acceleration}
     * 
     * @return time to accelerate in seconds
     */
    public double getAcceleration() {
        return this.acceleration;
    }

    /**
     * Method to set the acceleration time {@link Car#acceleration}
     * 
     * @param acceleration time to accelerate in seconds
     */
    public void setAcceleration(double acceleration) { 
        this.acceleration = Math.max(acceleration, 0);
    }

    /**
     * Method that converts Car type to string value
     * 
     * @return formated string containing object's all fields
     */
    @Override
    public String toString() {
        return String.format("Model: %s\nBody type: %s\nFuel type: %s\nTop speed: %d\nAcceleration from 0 to 100 km/h: %f",
        this.model, this.bodyType.toString(), this.fuelType.toString(), this.topSpeed, this.acceleration);
    }

    /**
     * Method that alphabetically sorts the array of Car objects by model field {@link Car#model}
     * 
     * @param array an array of Car objects
     */
    public static void sortedByModel(Car[] array) {
        // Looping through the array
        for (int i = 0; i < array.length - 1; i++) {
            Car current = array[i];
            Car next = array[i+1];
            // Compare to elements
            if (current.getModel().compareTo(next.getModel()) > 0) {
                // Swap if the first is bigger
                Car temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
            }
        }
    }

    /**
     * Method that sorts the array of Car objects by the top speed {@link Car#topSpeed}
     * Works the same way as sortedByModel method
     * @see Car#sortedByModel(Car[])
     * 
     * @param array an array of Car objects
     */
    public static void sortedByTopSpeed(Car[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            Car current = array[i];
            Car next = array[i+1];
            if (current.getTopSpeed() > next.getTopSpeed()) {
                Car temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
            }
        }
    }
}
