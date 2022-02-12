package com.StockManager;

import java.util.Arrays;

public class Supplier {
    private String supplierName, supplierEmail;
    private Integer supplierContactNumber, supplierStockSold;
    private String[][] supplierItemList = new String[10][2];
    private int i = 0;

    public Supplier() {}

    public Supplier(String name, String email, Integer contactNumber, User user) {
        if(user.getUserType().equalsIgnoreCase("admin")) {
            this.supplierName = name;
            this.supplierEmail = email;
            this.supplierContactNumber = contactNumber;
        }
    }

    public void editSupplierInfo(String name, String email, Integer contactNumber, User user) {
        if(user.getUserType().equalsIgnoreCase("admin")) {
            this.supplierName = name;
            this.supplierEmail = email;
            this.supplierContactNumber = contactNumber;
        }
    }

    public void addPurchasableItem(String item, String price, User user) {
        //Temporary array that is 10 spaces bigger than original
        String[][] temp = new String[this.supplierItemList.length + 10][2];

        if(user.getUserType().equalsIgnoreCase("admin")) {
            if (i >= this.supplierItemList.length) {
                //Loops through rows of the original 2d array and copies the columns to the temporary 2d array
                for (int j = 0; j < this.supplierItemList.length; j++) {
                    System.arraycopy(this.supplierItemList[j], 0, temp[j], 0, 2);
//                    temp[j] = Arrays.copyOf(this.supplierItemList[j], this.supplierItemList[j].length);
                }
                //Resizes the original to the temporary 2d array's size
                this.supplierItemList = new String[temp.length][2];
                //Loops through rows of the temporary 2d array and copies the columns to the original 2d array
                for (int j = 0; j < this.supplierItemList.length; j++) {
                    System.arraycopy(temp[j], 0, this.supplierItemList[j], 0, 2);
//                    this.supplierItemList[j] = Arrays.copyOf(temp[j], temp[j].length);
                }
            }
            this.supplierItemList[i][0] = item;
            this.supplierItemList[i][1] = price;
            i++;
        }
        else {
            System.out.println("Do not have admin privileges.\n");
        }
    }

    public void removePurchasableItem(String item, User user) {
        if (user.getUserType().equalsIgnoreCase("admin") && this.supplierItemList[0][0] != null) {
            int j = 0;

            while (!(this.supplierItemList[j][0].equalsIgnoreCase(item)) && j < this.supplierItemList.length - 1 && this.supplierItemList[j + 1][0] != null) {
                j++;
            }

            if (this.supplierItemList[j][0].equalsIgnoreCase(item)) {
                String[][] temp = new String[this.supplierItemList.length][2];
                int l = 0;

                //Copies from after the target in the original array into a temporary array
                //If the position is not in the first position which is 0, subtract that
                //from the length to loop the exact amount
                if (j > 0) {
                    for (int k = j + 1; k <= temp.length - j; k++) {
                        temp[l] = Arrays.copyOf(this.supplierItemList[k], 2);
                        l++;
                    }
                }
                else {
                    //If the position is in the first position which is 0, subtract 1
                    //from the length to loop the exact amount
                    for (int k = j + 1; k <= temp.length - 1; k++) {
                        temp[l] = Arrays.copyOf(this.supplierItemList[k], 2);
                        l++;
                    }
                }

                int k = j;

                //Copies the contents of the temporary array back into the original from the position of the target go up
                for (l = 0; l < temp.length - j; l++) {
                    this.supplierItemList[k] = Arrays.copyOf(temp[l], 2);
                    k++;
                }
            }
            else {
                System.out.println(item.toUpperCase() + " doesn't exist.\n");
            }
        }
        else {
            System.out.println("Do not have admin privileges.\n");
        }
    }

    public void printPurchasableItems() {
        int j = 0;
        while (this.supplierItemList[j][0] != null) {
            System.out.printf("Item %d - %s: $%.2f\n", j+1, this.supplierItemList[j][0].toUpperCase(), Double.parseDouble(this.supplierItemList[j][1]));
            j++;
        }
        System.out.println();
    }

}
