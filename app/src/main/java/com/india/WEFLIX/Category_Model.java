package com.india.WEFLIX;

public class Category_Model {
    private int categoryIconLink;
    private String category_name;

    public Category_Model(int categoryIconLink , String category_name) {
        this.categoryIconLink = categoryIconLink;
        this.category_name = category_name;

    }


    public int getCategoryIconLink() {
        return categoryIconLink;
    }

    public void setCategoryIconLink(int categoryIconLink) {
        this.categoryIconLink = categoryIconLink;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

}
