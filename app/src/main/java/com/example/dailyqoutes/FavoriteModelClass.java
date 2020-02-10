package com.example.dailyqoutes;

public class FavoriteModelClass {
    String ID ;
    String Quote;
    String check;
    String category;

    public FavoriteModelClass(String ID, String quote, String check , String category) {
        this.ID = ID;
        this.Quote = quote;
        this.check = check;
        this.category = category;

    }
    FavoriteModelClass() {
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getQuote() {
        return Quote;
    }

    public void setQuote(String quote) {
        Quote = quote;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }
}


