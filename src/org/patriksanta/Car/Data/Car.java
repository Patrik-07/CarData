package org.patriksanta.Car.Data;

import org.patriksanta.Car.Properties.FuelType.FuelType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

public class Car implements Serializable {
    protected String name;
    protected int price;
    //protected String condition;
    //protected String fuelType;
    protected Date date;
    protected int distance;
    protected String[] category;
    protected byte[] imageBuffer;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    /*
    public String getCondition() {
        return condition;
    }

    public String getFuelType() {
        return fuelType;
    }
     */

    public Date getDate() {
        return date;
    }

    public int getDistance() {
        return distance;
    }

    public String[] getCategory() {
        return category;
    }

    public BufferedImage getImageBuffer() {
        try {
            return ImageIO.read(new ByteArrayInputStream(imageBuffer));
        } catch (IOException e) {
            return null;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    /*
    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
     */

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setCategory(String[] category) {
        this.category = category;
    }

    public void setImageBuffer(BufferedImage bufferedImage) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
            imageBuffer = byteArrayOutputStream.toByteArray();
        }
        catch (Exception e) {
            imageBuffer = null;
        }
    }
}