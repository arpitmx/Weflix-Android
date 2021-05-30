package com.india.WEFLIX;

public class MultipleProductbannerModel {

    private int pimage;
    private String pname;
    private String pbrand;
    private String price;



    public MultipleProductbannerModel(int pimage, String pname, String pbrand, String price) {
        this.pimage = pimage;
        this.pname = pname;
        this.pbrand = pbrand;
        this.price = price;
    }

    public int getPimage() {
        return pimage;
    }

    public void setPimage(int pimage) {
        this.pimage = pimage;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPbrand() {
        return pbrand;
    }

    public void setPbrand(String pbrand) {
        this.pbrand = pbrand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
