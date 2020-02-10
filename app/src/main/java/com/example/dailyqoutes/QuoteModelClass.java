package com.example.dailyqoutes;

public class QuoteModelClass {

    String ID ;
    String Quote;
    String check;
    String category;

    public QuoteModelClass(String ID, String quote, String check , String category) {
        this.ID = ID;
        this.Quote = quote;
        this.check = check;
        this.category = category;

    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public QuoteModelClass() {
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
