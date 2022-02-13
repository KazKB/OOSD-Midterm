package com.StockManager;

import java.util.Arrays;

public class User {
    private String userName, userEmail, userID, userType, password;
    private static Stock[] stockList = new Stock[10];
    private Integer i = 0;

    public User() {}

    public User(String name, String email, String id, String type, String password) {
        this.userName = name;
        this.userEmail = email;
        this.userID = id;
        this.userType = type;
        this.password = password;
    }

    public User(String firstName, String lastName, String email, String id, String type, String password) {
        this.userName = firstName + " " + lastName;
        this.userEmail = email;
        this.userID = id;
        this.userType = type;
        this.password = password;
    }

    //Getters and Setters will be used to edit this Class
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserName(String firstName, String lastName) {
        this.userName = firstName + " " + lastName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserType() {
        return userType;
    }

    public void addToStockList(Stock stock) {
        if (this.userType.equalsIgnoreCase("admin")) {
            if (this.i >= stockList.length) {
                stockList = Arrays.copyOf(stockList, stockList.length + 5);
            }
            stockList[this.i] = stock;
            this.i++;
        }
        else {
            System.out.println("You do not have admin privileges.\n");
        }
    }

    public void removeFromStockList(Stock stock) {
        Integer k = 0;

        if (this.userType.equalsIgnoreCase("admin")) {
            if (stockList[0] != null) {
                //Cycles through until the end of the array or until the particular stock is found
                while (!stockList[k].getStockName().equalsIgnoreCase(stock.getStockName()) && k < this.i - 1) {
                    k++;
                }
                //If stock is found, remove it and the rest after it from the list.
                //Then copy the rest stock back to the list.
                if (stockList[k].getStockName().equalsIgnoreCase(stock.getStockName())) {
                    System.arraycopy(stockList, k + 1, stockList, k, this.i);
                    this.i--;
                } else {
                    System.out.println(stock.getStockName().toUpperCase() + " is not in stock.\n");
                }
            }
            else {
                System.out.println("Stock List is empty.\n");
            }
        }
        else {
            System.out.println("You do not have admin privileges.\n");
        }
    }

    public void viewStockList() {
        if (stockList[0].getStockName() == null) {
            System.out.println("Stock List is empty.\n");
        }
        else {
            for (Integer k = 0; k < this.i; k++) {
                System.out.println(stockList[k].getStockName().toUpperCase());
            }
            System.out.println();
        }
    }

//    public boolean checkIfInStock(Stock stock) {
//        Integer k = 0;
//
//        //Cycles through array until stock is found, end has reached or the next item is null
//        while (!stockList[k].getStockName().equalsIgnoreCase(stock.getStockName()) && k < this.i && stockList[k + 1] != null) {
//            k++;
//        }
//
//        //Checks if the stock item is in or not
//        if(stockList[k].getStockName().equalsIgnoreCase(stock.getStockName())) {
//            return true;
//        }
//        else {
//            return false;
//        }
//    }

    public boolean checkIfInStock(String stock) {
        Integer k = 0;

        //Cycles through array until stock is found, end has reached or the next item is null
        while (!stockList[k].getStockName().equalsIgnoreCase(stock) && k < this.i && stockList[k + 1] != null) {
            k++;
        }

        //Checks if the stock item is in or not
        if(stockList[k].getStockName().equalsIgnoreCase(stock)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void addQuantityToStock(String stock, Integer quantity) {
        Integer k = 0;

        //Cycles through array until stock is found, end has reached or the next item is null
        while (!stockList[k].getStockName().equalsIgnoreCase(stock) && k < this.i && stockList[k + 1] != null) {
            k++;
        }

        stockList[k].addToStock(quantity);
    }
}
