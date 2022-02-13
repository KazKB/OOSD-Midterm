package com.StockManager;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Customer {
    private String customerName, customerEmail, customerContactNumber;
    private String[][] purchasedItemsList = new String[10][3];
    private Integer salesReceiptNumber = 0, i = 0;

    public Customer() {
    }

    public Customer(String name, String email, String contactNumber, User user) {
        if (user.getUserType().equalsIgnoreCase("admin")) {
            this.customerName = name;
            this.customerEmail = email;
            this.customerContactNumber = contactNumber;
        }
        else {
            System.out.println("You do not have admin privileges.\n");
        }
    }

    public Customer(String firstName, String lastName, String email, String contactNumber, User user) {
        if (user.getUserType().equalsIgnoreCase("admin")) {
            this.customerName = firstName + " " + lastName;
            this.customerEmail = email;
            this.customerContactNumber = contactNumber;
        }
        else {
            System.out.println("You do not have admin privileges.\n");
        }
    }

    //Basically the constructor but as a method
    public void editCustomerInformation(String name, String email, String contactNumber, User user) {
        if (user.getUserType().equalsIgnoreCase("admin")) {
            this.customerName = name;
            this.customerEmail = email;
            this.customerContactNumber = contactNumber;
        }
        else {
            System.out.println("You do not have admin privileges.\n");
        }
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName, User user) {
        if (user.getUserType().equalsIgnoreCase("admin")) {
            this.customerName = customerName;
        }
        else {
            System.out.println("You do not have admin privileges.\n");
        }
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail, User user) {
        if (user.getUserType().equalsIgnoreCase("admin")) {
            this.customerEmail = customerEmail;
        }
        else {
            System.out.println("You do not have admin privileges.\n");
        }
    }

    public String getCustomerContactNumber() {
        return customerContactNumber;
    }

    public void setCustomerContactNumber(String customerContactNumber, User user) {
        if (user.getUserType().equalsIgnoreCase("admin")) {
            this.customerContactNumber = customerContactNumber;
        }
        else {
            System.out.println("You do not have admin privileges.\n");
        }
    }

    public void addPurchasedItem(String item, Double price, Integer quantity) {
        //Temporary array that is 10 spaces bigger than original
        String[][] temp = new String[this.purchasedItemsList.length + 10][3];
        
        if (i >= this.purchasedItemsList.length) {
            //Loops through rows of the original 2d array and copies the columns to the temporary 2d array
            for (int j = 0; j < this.purchasedItemsList.length; j++) {
                    temp[j] = Arrays.copyOf(this.purchasedItemsList[j], this.purchasedItemsList[j].length);
            }
            //Resizes the original to the temporary 2d array's size
            this.purchasedItemsList = new String[temp.length][3];
            //Loops through rows of the temporary 2d array and copies the columns to the original 2d array
            for (int j = 0; j < this.purchasedItemsList.length; j++) {
                    this.purchasedItemsList[j] = Arrays.copyOf(temp[j], temp[j].length);
            }
        }
        this.purchasedItemsList[i][0] = item;
        this.purchasedItemsList[i][1] = String.valueOf(price);
        this.purchasedItemsList[i][2] = String.valueOf(quantity);
        i++;
    }

    public void removePurchasedItem(String item, Integer quantity, User user) {
        if (user.getUserType().equalsIgnoreCase("admin")) {
            if (this.purchasedItemsList[0][0] != null) {
                int j = 0;

                while (!(this.purchasedItemsList[j][0].equalsIgnoreCase(item)) && !(this.purchasedItemsList[j][2].equalsIgnoreCase(String.valueOf(quantity))) && j < this.purchasedItemsList.length - 1 && this.purchasedItemsList[j + 1][0] != null) {
                    j++;
                }

                if (this.purchasedItemsList[j][0].equalsIgnoreCase(item) && this.purchasedItemsList[j][2].equalsIgnoreCase(String.valueOf(quantity))) {
                    String[][] temp = new String[this.purchasedItemsList.length][3];
                    Integer l = 0;

                    //Copies from after the target in the original array into a temporary array
                    //If the position is not in the first position which is 0, subtract that
                    //from the length to loop the exact amount
                    if (j > 0) {
                        for (Integer k = j + 1; k <= i - l; k++) {
                            temp[l] = Arrays.copyOf(this.purchasedItemsList[k], 3);
                            l++;
                        }
                    } else {
                        //If the position is in the first position which is 0, subtract 1
                        //from the length to loop the exact amount
                        for (Integer k = j + 1; k <= i - j; k++) {
                            temp[l] = Arrays.copyOf(this.purchasedItemsList[k], 3);
                            l++;
                        }
                    }

                    Integer k = j;

                    //Copies the contents of the temporary array back into the original from the position of the target go up
                    for (l = 0; l < temp.length - j; l++) {
                        this.purchasedItemsList[k] = Arrays.copyOf(temp[l], 3);
                        k++;
                    }

                    //Adds back the subtracted quantity from stock
                    user.addQuantityToStock(item, quantity);
                    i--;
                } else {
                    System.out.println(item.toUpperCase() + " hasn't been bought.\n");
                }
            }
            else {
                System.out.println("No items have been purchased.\n");
            }
        }
        else {
            System.out.println("Do not have admin privileges.\n");
        }
    }

    public void printPurchasedItems() {
        Integer j = 0;

        if (this.purchasedItemsList[0][0] == null) {
            System.out.println("No items have been purchased.\n");
        }
        else {
            Double total = 0.0;

            while (this.purchasedItemsList[j][0] != null) {
                total = Double.parseDouble(this.purchasedItemsList[j][1]) * Integer.parseInt(this.purchasedItemsList[j][2]);
                System.out.printf("Item %d - %s: $%.2f * %d = $%.2f\n", j + 1, this.purchasedItemsList[j][0].toUpperCase(), Double.parseDouble(this.purchasedItemsList[j][1]), Integer.parseInt(this.purchasedItemsList[j][2]), total);
                j++;
            }

            System.out.println();
        }
    }

    public void createAndPrintSalesReceipt (String item, Integer quantity, User user) {
        Double salesReceiptTotal = 0.0;
        Integer j = 0;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        if (user.checkIfInStock(item) == true) {
            this.salesReceiptNumber += 1;

            user.removeQuantityFromStock(item, quantity);
            addPurchasedItem(item, user.getStock(item).getStockPrice(), quantity);
            salesReceiptTotal = Double.parseDouble(this.purchasedItemsList[i - 1][1]) * quantity;

            System.out.printf(
                    "Invoice Number: %d\n" +
                            "Date: %s\n" +
                            "Supplier: %s\n" +
                            "\nItem: %s\n" +
                            "Price: $%.2f\n" +
                            "Quantity: %d\n" +
                            "Total: $%.2f\n\n",
                    this.salesReceiptNumber, formatter.format(date), this.customerName, item.toUpperCase(), Double.parseDouble(this.purchasedItemsList[i - 1][1]), quantity, salesReceiptTotal);
        }
        else {
            System.out.println(item.toUpperCase() + " is not in the stock list.\n");
        }
    }
}
