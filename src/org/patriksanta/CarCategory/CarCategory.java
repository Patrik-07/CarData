package org.patriksanta.CarCategory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CarCategory implements java.io.Serializable {
    protected final String name;
    protected int n;
    private final List<CarCategory> categories = new ArrayList<>();

    public CarCategory(String name) {
        this.name = name;
        n = 1;
    }

    public void addOneToCategory() {
        n++;
    }

    public void addCategory(List<String> category) {
        addCategory(category, categories);
    }

    public String getName() {
        return name;
    }

    public int getNumberOf() {
        return n;
    }

    public CarCategories getCategories() {
        CarCategories r = new CarCategories();
        r.categories = categories;
        return r;
    }

    public CarCategories getSubCategoriesOf(String categoryName) {
        return getSubCategoriesOf(categories, categoryName);
    }

    public String[] toStringArray() {
        return toStringArray(categories);
    }

    @Override
    public String toString() {
        return name + " (" + n + ")";
    }

    protected static void addCategory(List<String> category, List<CarCategory> categories) {
        if (category.size() != 0) {
            int index = -1;
            for (int i = 0; i < categories.size(); i++)
                if (categories.get(i).name.equals(category.get(0))) {
                    index = i;
                    break;
                }

            if (index == -1) {
                categories.add(new CarCategory(category.get(0)));
                index = categories.size() - 1;
            } else categories.get(index).addOneToCategory();

            Collection<String> copy = category.subList(1, category.size());
            categories.get(index).addCategory(new ArrayList<>(copy));
        }
    }

    protected static CarCategories getSubCategoriesOf(List<CarCategory> categories, String categoryName) {
        for (CarCategory c : categories) {
            if (c.name.equals(categoryName)) {
                CarCategories r = new CarCategories();
                r.categories = c.categories;
                return r;
            }
        }
        return null;
    }

    protected static String[] toStringArray(List<CarCategory> categories) {
        List<String> list = new ArrayList<>();
        for (CarCategory c : categories)
            list.add(c.toString());
        return list.toArray(new String[0]);
    }
}
