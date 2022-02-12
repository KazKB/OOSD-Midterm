package com.StockManager;

import static java.lang.Math.abs;

public class Stock {
    private String stockName, stockDescription, stockID, stockCategory;
    private Integer stockQuantity = 0;
    private Double stockPrice;

    public Stock() {
    }

    public Stock(String stockName, String stockDescription, String stockID, String stockCategory, Double stockPrice, User user) {
        if(user.getUserType().equalsIgnoreCase("admin")) {
            this.stockName = stockName;
            this.stockDescription = stockDescription;
            this.stockID = stockID;
            this.stockCategory = stockCategory;
            this.stockPrice = stockPrice;
        }
        else {
            System.out.println("You do not have admin privileges.");
        }
    }

    //Setters are edited to allow only admins to edit them
    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName, User user) {
        if(user.getUserType().equalsIgnoreCase("admin"))
            this.stockName = stockName;
        else
            System.out.println("You do not have admin privileges.");
    }

    public String getStockDescription() {
        return stockDescription;
    }

    public void setStockDescription(String stockDescription, User user) {
        if(user.getUserType().equalsIgnoreCase("admin"))
            this.stockDescription = stockDescription;
        else
            System.out.println("You do not have admin privileges.");
    }

    public String getStockID() {
        return stockID;
    }

    public void setStockID(String stockID, User user) {
        if(user.getUserType().equalsIgnoreCase("admin"))
            this.stockID = stockID;
        else
            System.out.println("You do not have admin privileges.");
    }

    public String getStockCategory() {
        return stockCategory;
    }

    public void setStockCategory(String stockCategory, User user) {
        if(user.getUserType().equalsIgnoreCase("admin"))
            this.stockCategory = stockCategory;
        else
            System.out.println("You do not have admin privileges.");
    }

    public Double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(Double stockPrice, User user) {
        if(user.getUserType().equalsIgnoreCase("admin"))
            this.stockPrice = stockPrice;
        else
            System.out.println("You do not have admin privileges.");
    }

    public void addStock(Integer num) {
        this.stockQuantity += num;
    }

    public void removeStock(Integer num) {
        if(this.stockQuantity <= 0) {
            System.out.println("No more " + this.stockName + " to take from.");
        }
        else if (this.stockQuantity - num < 0) {
            System.out.println("Removing " +  abs(num) + " extra " + this.stockName + " from inventory.");
        }
        else {
            this.stockQuantity -= num;
        }
    }

    //Basically the constructor all over again
    public void editStock(String stockName, String stockDescription, String stockID, String stockCategory, Double stockPrice, User user) {
        if(user.getUserType().equalsIgnoreCase("admin")) {
            this.stockName = stockName;
            this.stockDescription = stockDescription;
            this.stockID = stockID;
            this.stockCategory = stockCategory;
            this.stockPrice = stockPrice;
        }
        else
            System.out.println("You do not have admin privileges.");
    }

    public void viewStock() {
        if (this.stockName != null && this.stockID != null && this.stockCategory != null && this.stockPrice != null) {
            System.out.printf("Name: %s%n" +
                            "ID: %s%n" +
                            "Description: %s%n" +
                            "Category: %s%n" +
                            "Quantity: %d%n" +
                            "Price: $%.2f%n%n"
                    , this.stockName, this.stockID, this.stockDescription, this.stockCategory, this.stockQuantity, this.stockPrice);
        }
        else
            System.out.println("Empty stock!");
    }
}
