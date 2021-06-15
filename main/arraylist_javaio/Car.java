package main.arraylist_javaio;

public class Car implements Comparable<Car> {
    private String car;
    private double mpg;
    private int cylinders;
    private double displacement;
    private double horsepower;
    private double weight;
    private double acceleration;
    private int model;
    private String origin;

    public Car(
        String car,
        double mpg, 
        int cylinders, 
        double displacement, 
        double horsepower, 
        double weight,
        double acceleration, 
        int model, 
        String origin
    ) {
        this.car = car;
        this.mpg = mpg;
        this.cylinders = cylinders;
        this.displacement = displacement;
        this.horsepower = horsepower;
        this.weight = weight;
        this.acceleration = acceleration;
        this.model = model;
        this.origin = origin;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public double getMpg() {
        return mpg;
    }

    public void setMpg(double mpg) {
        this.mpg = mpg;
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    public double getDisplacement() {
        return displacement;
    }

    public void setDisplacement(double displacement) {
        this.displacement = displacement;
    }

    public double getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(double horsepower) {
        this.horsepower = horsepower;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }


    @Override
    public String toString() {
        String result = String.format("<Car: %s, MPG: %s, Cylinders: %s, Displacement: %s, Horsepower: %s, Weight: %s, Acceleration: %s, Model: %s, Origin: %s>", 
            car,
            mpg,
            cylinders,
            displacement,
            horsepower,
            weight,
            acceleration,
            model,
            origin
        );
        return result;
    }

    @Override
    public int compareTo(Car other) {

        return car.compareTo(other.car);
    }
}
