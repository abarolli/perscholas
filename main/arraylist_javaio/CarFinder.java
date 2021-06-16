package main.arraylist_javaio;

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import main.arraylist_javaio.query.Query;

public class CarFinder {

    public static void main(String[] args) {

            try (
                Scanner reader = new Scanner(System.in);
            ) {
                
                boolean fileIsFound = false;
                ArrayList<Car> cars = null;
                do {
                    System.out.println("\nEnter path to car information csv file: ");
                    String path = reader.nextLine();
                    try {
                        cars = CarInformation.setCarsInformation(path);
                    }
                    catch (IOException | NumberFormatException ex) {
                        System.out.println("\nThat file was not found or is not recognized as an appropriate file for this command. Try entering the absolute path ...");
                        continue;
                    }
                    
                    fileIsFound = true;
                    
                }
                while (!fileIsFound);
                
                
                ArrayList<Car> searchResults = null;
                boolean inPlay = true;
                
                while (inPlay) {
                    
                    String outputPath = "";
                    while (inPlay) {
                        System.out.println("\nEnter name of car you'd like to look for: ");
                        String carQuery = reader.nextLine().toLowerCase().trim();
                        
                        Query q = extractOutputPathFromQuery(carQuery);

                        carQuery = q.getSearch();
                        outputPath = q.getOutput();

                        searchResults = searchBy(cars, "car", carQuery.trim());

                        if (searchResults != null) break;
        
                        inPlay = askToContinue("\nDidn't find anything. Want to look up a different car?", reader);
                    }
                    
                    if (!inPlay) break;

                    if (!outputPath.isEmpty())
                        writeMatchesToFile(searchResults, outputPath);
                    else
                        printMatches(searchResults);


                    inPlay = askToContinue("Would you like to make another car query?", reader);
                }

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

        if (car.equals(middleCar.getCar().toLowerCase().trim())) {
            
            results.add(middleCar);
            
            int i = middleIndex - 1;
            int j = middleIndex + 1;

            if (i > 0) {
                Car leftCar = cars.get(i);
                while(car.equals(leftCar.getCar().toLowerCase().trim())) {
                    results.add(leftCar);
                    if (i == 0) break;
                    leftCar = cars.get(--i);
                }
            }
            
            if (j < cars.size()) {
                Car rightCar = cars.get(j);
                while (car.equals(rightCar.getCar().toLowerCase().trim())) {
                    results.add(rightCar);
                    if (j == cars.size() - 1) break;
                    rightCar = cars.get(++j);
                }
            }

            return results;
        }
        
        if (car.compareTo(middleCar.getCar().toLowerCase().trim()) < 0)
            return searchByCar(cars, car, left, middleIndex - 1);
        
        return searchByCar(cars, car, middleIndex + 1, right);

    }


    private static boolean askToContinue(String message, Scanner reader) {
        String reSearchAnswer = "";

        while (!(reSearchAnswer.equals("y") || reSearchAnswer.equals("n"))) {
        
            System.out.print(message + " [y / n]: ");
            reSearchAnswer = reader.nextLine().toLowerCase();
        }

        return reSearchAnswer.equals("y");
    }


    private static void printMatches(ArrayList<Car> searchResults) {
        System.out.println("========================================== MATCHES ==========================================");
        for (Car c : searchResults) {
            System.out.println(c);
        }
        System.out.println("=============================================================================================\n");
    }

    private static void writeMatchesToFile(ArrayList<Car> matches, String outputPath) {
        try (
            FileWriter fwriter = new FileWriter(new File(outputPath));
        ) {
            for (Car c : matches) {
                fwriter.write(c.toString() + "\n");
            }
            System.out.println("The results were written to " + outputPath + "\n");
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static Query extractOutputPathFromQuery(String carQuery) {

        String[] carQueryTokens = carQuery.split(" ");
        String outputPath = "";

        carQuery = "";
        for (int i = 0; i < carQueryTokens.length; ++i) {
            if (!carQueryTokens[i].equals("--o")) { //NOT
                carQuery += (carQueryTokens[i] + " ");
            }
            else {
                // need more elegant solution if I choose to use more switches
                if ((i + 1) < carQueryTokens.length) {
                    outputPath = carQueryTokens[i + 1];
                    break;
                }
            }
        }

        return new Query(carQuery, outputPath);
    }
}