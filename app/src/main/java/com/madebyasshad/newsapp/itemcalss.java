package com.madebyasshad.newsapp;

public class itemcalss {
    String title, description, urltocontent, urlofimage, publishedat;

    public itemcalss(String title, String description, String urltocontent, String urlofimage, String publishedat) {
        this.title = title;
        this.description = description;
        this.urltocontent = urltocontent;
        this.urlofimage = urlofimage;
        this.publishedat = publishedat;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrltocontent() {
        return urltocontent;
    }

    public String getUrlofimage() {
        return urlofimage;
    }

    public String getPublishedat() {
        return publishedat;
    }
}

