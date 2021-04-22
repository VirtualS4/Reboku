package com.reboku;

public class InformationCenterMessages {



    //model class
    String name;
    String imagesUrl;

    //constructor
    public InformationCenterMessages() {
    }
    public InformationCenterMessages(String name, String imagesUrl) {
        this.name = name;
        this.imagesUrl = imagesUrl;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getImagesUrl() {return imagesUrl; }

    public void setImagesUrl(String imagesUrl) { this.imagesUrl = imagesUrl; }
}
