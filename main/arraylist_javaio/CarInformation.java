package main.arraylist_javaio;

import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class CarInformation {
    
    public static ArrayList<Car> setCarsInformation(String infoPath) throws IOException {

        File file = new File(infoPath);

        ArrayList<Car> cars = new ArrayList<>();

        try (
            Scanner reader = new Scanner(file);
        ) {
            for (int i = 0; i < 2; ++i) {
                if (!reader.hasNextLine()) break;
                reader.nextLine();
            }

            while (reader.hasNextLine()) {
                String[] carInfo = reader.nextLine().split(",");
                if (carInfo.length == 9) {
                    cars.add(
                        new Car(
                            carInfo[0],
                            Double.valueOf(carInfo[1]),
                            Integer.valueOf(carInfo[2]),
                            Double.valueOf(carInfo[3]),
                            Double.valueOf(carInfo[4]),
                            Double.valueOf(carInfo[5]),
                            Double.valueOf(carInfo[6]),
                            Integer.valueOf(carInfo[7]),
                            carInfo[8]
                        )
                    );
                }
            }
        }

        return cars;
    }

    public static void printCarsInformation(String infoPath) throws IOException {
        ArrayList<Car> cars = setCarsInformation(infoPath);

        for (Car c : cars) {
            System.out.println(c);
        }
    }
}
