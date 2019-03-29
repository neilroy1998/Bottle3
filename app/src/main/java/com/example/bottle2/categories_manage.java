package com.example.bottle2;

public class categories_manage {

    private int catID;
    private String categoryName;
    private String percent;

    public categories_manage(int catID, String categoryName, String percent) {
        this.catID = catID;
        this.categoryName = categoryName;
        this.percent = percent;
    }

    public int getCatID() {
        return catID;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }
}
