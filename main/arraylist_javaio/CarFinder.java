package main.arraylist_javaio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class CarFinder {
    public static void main(String[] args) {

        try (
            Scanner reader = new Scanner(System.in);
        ) {

            boolean fileIsFound = false;
            ArrayList<Car> cars = null;

            do {
                System.out.println("Enter path to car information csv file: ");
                String path = reader.nextLine();
                try {
                    cars = CarInformation.setCarsInformation(path);
                }
                catch (IOException ex) {
                    System.out.println("That file was not found or is not recognized as an appropriate file for this command. Try entering the absolute path ...\n");
                    continue;
                }

                fileIsFound = true;

            }
            while (!fileIsFound);
    
            System.out.println("\nEnter name of car you'd like to look for: ");
            String carName = reader.nextLine();
    

            ArrayList<Car> searchResults = searchBy(cars, "car", carName);

            if (searchResults != null) {
                System.out.println("========================================== MATCHES ==========================================");
                for (Car c : searchResults) {
                    System.out.println(c);
                }
                System.out.println("=============================================================================================");
            }
            else 
                System.out.println("Nothing found");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        
    }

    public static ArrayList<Car> searchBy(List<Car> cars, String property, Object value) {
        
        ArrayList<Car> results = null;

        Collections.sort(cars);

        switch (property) {
            case "car":
                results = searchByCar(cars, (String) value, 0, cars.size() - 1);
                break;
        }

        return results;
    }

    private static ArrayList<Car> searchByCar(List<Car> cars, String car, int left, int right) {

        if (left > right) return null;

        ArrayList<Car> results = new ArrayList<>();

        int middleIndex = (left + right) / 2;
        Car middleCar = cars.get(middleIndex);

        if (car.equals(middleCar.getCar())) {
            
            results.add(middleCar);
            
            int i = middleIndex - 1;
            int j = middleIndex + 1;

            if (i > 0) {
                Car leftCar = cars.get(i);
                while(car.equals(leftCar.getCar())) {
                    results.add(leftCar);
                    if (i == 0) break;
                    leftCar = cars.get(--i);
                }
            }
            
            if (j < cars.size()) {
                Car rightCar = cars.get(j);
                while (car.equals(rightCar.getCar())) {
                    results.add(rightCar);
                    if (j == cars.size() - 1) break;
                    rightCar = cars.get(++i);
                }
            }

            return results;
        }
        
        if (car.compareTo(middleCar.getCar()) < 0)
            return searchByCar(cars, car, left, middleIndex - 1);
        
        return searchByCar(cars, car, middleIndex + 1, right);

    }
}
