package com.StockManager;

public class TestDriver {
    public static void main(String[] args) {
        User admin = new User("Kaleel", "Boston", "kaleelboston@gmail.com", "KB12", "admIn", "password");
        User regular = new User("Regular", "Regular", "regular@gmail.com", "R12", "regular", "password");
        Stock wadadli = new Stock("Wadadli", "Antiguan Beer", "B1", "Alchohol", 10.0, admin);
        Stock banks = new Stock("Banks", "Beer", "B1", "Alchohol", 10.0, admin);

        //Testing the basic functions of the Stock Class
        //Manipulates the stock's information
        System.out.println("Editing Stock Information:");
        wadadli.viewStockInformation();
        wadadli.addToStock(5);
        wadadli.viewStockInformation();
        wadadli.removeFromStock(3);
        wadadli.viewStockInformation();
        wadadli.editStockInformation("Carib", "Caribbean Beer", "B2", "Alcohol", 10.0, admin);
        wadadli.viewStockInformation();
        wadadli.addToStock(5);
        wadadli.viewStockInformation();
        wadadli.removeFromStock(3);
        wadadli.editStockInformation("Wadadli", "Antiguan Beer", "B2", "Alcohol", 10.0, admin);

        //Testing the basic functions of the Supplier Class
        //Adds items and test removing from an empty purchasable items list of the supplier
        Supplier BeerCo = new Supplier("BeerCo", "3", "3", admin);

        System.out.println("Printing an empty list:");
        BeerCo.printPurchasableItems();

        System.out.println("Adding items to list:");
        BeerCo.removePurchasableItem("beer", admin);
        BeerCo.addPurchasableItem("beer", "10", admin);
        BeerCo.addPurchasableItem("beer2", "12", admin);
        BeerCo.addPurchasableItem("beer3", "13", admin);
        BeerCo.addPurchasableItem("beer4", "14", admin);
        BeerCo.addPurchasableItem("beer5", "15", admin);
        BeerCo.addPurchasableItem("beer6", "16", admin);
        BeerCo.addPurchasableItem("beer7", "17", admin);
        BeerCo.addPurchasableItem("beer8", "18", admin);
        BeerCo.addPurchasableItem("beer9", "19", admin);
        BeerCo.addPurchasableItem("beer10", "20", admin);
        BeerCo.addPurchasableItem("beer11", "21", admin);
        BeerCo.addPurchasableItem("beer12", "22", admin);
        BeerCo.addPurchasableItem("beer13", "23", admin);
        BeerCo.addPurchasableItem("beer14", "24", admin);
        BeerCo.addPurchasableItem("beer15", "25", admin);
        BeerCo.addPurchasableItem("beer16", "26", admin);
        BeerCo.addPurchasableItem("beer17", "27", admin);
        BeerCo.addPurchasableItem("beer18", "28", admin);
        BeerCo.addPurchasableItem("beer19", "29", admin);
        BeerCo.addPurchasableItem("beer20", "30", admin);
        BeerCo.addPurchasableItem("beer21", "31", admin);
        BeerCo.printPurchasableItems();

        //Test removing items from the list of purchasable items from the supplier
        System.out.println("Removed an item and added one:");
        BeerCo.removePurchasableItem("beer", admin);
        BeerCo.addPurchasableItem("wadadli", "10", admin);
        BeerCo.printPurchasableItems();

        //Prints an invoice for a non-existent item
        System.out.println("Tried to buy a non-existent item:");
        BeerCo.createAndPrintInvoice("beer30" , 5, admin);

        //Testing the basic functions of the User Class and the Invoice function of Supplier
        //Adds and removes stock from the stock list in the User Class
//        admin.viewStockList();
        System.out.println("Remove from an empty stock list:");
        admin.removeFromStockList(wadadli);

        System.out.println("Added and removed from stock list:");
        admin.addToStockList(wadadli);
        admin.addToStockList(banks);
        admin.viewStockList();
        admin.removeFromStockList(wadadli);
        admin.viewStockList();

        System.out.println("Regular viewing stock list:");
        regular.viewStockList();

        System.out.println("Creating invoices of items not in lists:");
        BeerCo.createAndPrintInvoice("banks" , 5, admin);
        BeerCo.createAndPrintInvoice("wadadli" , 5, admin);

        System.out.println("Creating proper invoices:");
        BeerCo.addPurchasableItem("banks", "10", admin);
        BeerCo.createAndPrintInvoice("banks" , 5, admin);

        System.out.println("Checking the stock info:");
        banks.viewStockInformation();

        System.out.println("Creating invoice and checking stock:");
        BeerCo.createAndPrintInvoice("banks" , 5, admin);
        banks.viewStockInformation();

        //Testing Customer Class's basic functions
        Customer John = new Customer("John", "email", "d", admin);

        System.out.println("Checking and removing from an item purchased item list:");
        John.printPurchasedItems();
        John.removePurchasedItem("presidente", 4, admin);

        System.out.println("Creating sales receipt:");
        John.createAndPrintSalesReceipt("banks", 4, admin);

        System.out.println("Viewing stock info:");
        banks.viewStockInformation();

        System.out.println("Viewing purchased items:");
        John.printPurchasedItems();

        System.out.println("Undo the purchase:");
        John.removePurchasedItem("banks",4, admin);
        John.printPurchasedItems();
        banks.viewStockInformation();

    }
}
