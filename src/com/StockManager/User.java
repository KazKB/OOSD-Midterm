package com.StockManager;

import java.util.Arrays;

public class User {
    private String userName, userEmail, userID, userType, password;
    private static Stock[] stockList = new Stock[10];
    private static Integer i = 0;

    public User() {
        stockList[0] = new Stock();
    }

    public User(String type, String id) {
        this.userType = type;
        this.userID = id;
        stockList[0] = new Stock();
    }

    public User(String firstName, String lastName, String email, String id, String type, String password) {
        this.userName = firstName + " " + lastName;
        this.userEmail = email;
        this.userID = id;
        this.userType = type;
        this.password = password;
        stockList[0] = new Stock();
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
            //Increases stockList's max size when capacity is reached
            if (i >= stockList.length) {
                stockList = Arrays.copyOf(stockList, stockList.length + 5);
            }
            //Adds stock to stock list and increases the position to the next location
            stockList[i] = stock;
            i++;
        }
        else {
            System.out.println("You do not have admin privileges.\n");
        }
    }

    public void removeFromStockList(Stock stock) {
        int k = 0;

        if (this.userType.equalsIgnoreCase("admin")) {
            if (stockList[0] != null) {
                //Cycles through until the end of the array or until the particular stock is found
                while (!stockList[k].getStockName().equalsIgnoreCase(stock.getStockName()) && k < i - 1) {
                    k++;
                }
                //If target is found, remove it and the rest stock after it from the list
                //Then copy the stock after the list back to the list
                //As well decrease the position for where the next stock item will be added
                if (stockList[k].getStockName().equalsIgnoreCase(stock.getStockName())) {
                    System.arraycopy(stockList, k + 1, stockList, k, i);
                    i--;
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
        //Checks if stock list is empty
        if (stockList[0].getStockName().equals("")) {
            System.out.println("Stock List is empty.\n");
        }
        else {
            //If not empty print what is in the list's name
            for (int k = 0; k < i; k++) {
                System.out.println(stockList[k].getStockName().toUpperCase());
            }
            System.out.println();
        }
    }

    public boolean checkIfInStock(String stock) {
        int k = 0;

        //Cycles through array until target is found, end was reached or the next item is null
        while (!stockList[k].getStockName().equalsIgnoreCase(stock) && k < i && stockList[k + 1] != null) {
            k++;
        }

        //Returns whether the target was found or not
        return stockList[k].getStockName().equalsIgnoreCase(stock);
    }

    public void addQuantityToStock(String stock, Integer quantity) {
        int k = 0;

        //Cycles through array until target is found, end has reached or the next item is null
        while (!stockList[k].getStockName().equalsIgnoreCase(stock) && k < i && stockList[k + 1] != null) {
            k++;
        }

        //Add to the amount of stock owned
        stockList[k].addToStock(quantity);
    }

    public void removeQuantityFromStock(String stock, Integer quantity) {
        int k = 0;

        //Cycles through array until stock is found, end was reached or the next item is null
        while (!stockList[k].getStockName().equalsIgnoreCase(stock) && k < i && stockList[k + 1] != null) {
            k++;
        }

        //Remove from amount of stock owned
        stockList[k].removeFromStock(quantity);
    }

    public Stock getStock(String stock) {
        int k = 0;

        //Cycles through array until stock is found, end has reached or the next item is null
        while (!stockList[k].getStockName().equalsIgnoreCase(stock) && k < i && stockList[k + 1] != null) {
            k++;
        }

        //Returns target if found
        return stockList[k];
    }
}
