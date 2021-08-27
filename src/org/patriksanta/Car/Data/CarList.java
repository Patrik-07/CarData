package org.patriksanta.Car.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarList {
    private List<Car> carList = new ArrayList<>();

    public void addCar(Car car) {
        carList.add(car);
    }

    public List<Car> getCars() {
        return carList;
    }

    public List<Car> getCarsOf(String[] category) {
        return getCarListOf(category).carList;
    }

    public CarList getCarListOf(String[] category) {
        CarList r = new CarList();
        for (Car c : carList)
            if (Arrays.equals(c.category, category))
                r.carList.add(c);
        return r;
    }

    public void write(String filePath) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(carList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException ignored) {}
    }

    public void read(String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            carList = (ArrayList<Car>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (Exception ignored) {}
    }
}
