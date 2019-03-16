package com.example.bottle2;

public class categories_manage {

    private int catID;
    private String categoryName;
    private String percent;
    private String extras;

    public categories_manage(int catID, String categoryName, String percent, String extras) {
        this.catID = catID;
        this.categoryName = categoryName;
        this.percent = percent;
        this.extras = extras;
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

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }
}
