package org.patriksanta.Car.Properties.CarCategory;

import java.util.ArrayList;
import java.util.List;

public class CarCategories implements java.io.Serializable {
    protected List<CarCategory> categories = new ArrayList<>();

    public void addCategory(List<String> category) {
        CarCategory.addCategory(category, categories);
    }

    public int getNumberOf(String categoryName) {
        for (CarCategory c : categories)
            if (c.name.equals(categoryName))
                return c.n;
        return -1;
    }

    public CarCategories getSubCategoriesOf(String categoryName) {
        return CarCategory.getSubCategoriesOf(categories, categoryName);
    }

    public String[] toStringArray() {
        return CarCategory.toStringArray(categories);
    }
}
