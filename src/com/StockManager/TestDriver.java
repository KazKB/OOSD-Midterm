package com.StockManager;

public class TestDriver {
    public static void main(String[] args) {
        User admin = new User("Kaleel Boston", "kaleelboston@gmail.com", "KB12", "admIn", "password");
        Stock wadadli = new Stock("Wadadli", "Antiguan Beer", "B1", "Alchohol", 10.0, admin);
        Stock banks = new Stock("Banks", "Beer", "B1", "Alchohol", 10.0, admin);

        //Testing the basic functions of the Stock Class
        //Manipulates the stock's information
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

        BeerCo.printPurchasableItems();
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
        BeerCo.removePurchasableItem("beer", admin);
        BeerCo.addPurchasableItem("wadadli", "10", admin);
        BeerCo.printPurchasableItems();

        //Prints an invoice for a non-existent item
        BeerCo.createAndPrintInvoice("beer30" , 5, admin);

        //Testing the basic functions of the User Class and the Invoice function of Supplier
        //Adds and removes stock from the stock list in the User Class
//        admin.viewStockList();
        admin.removeFromStockList(wadadli);
        admin.addToStockList(wadadli);
        admin.addToStockList(banks);
        admin.viewStockList();
        admin.removeFromStockList(wadadli);
        admin.viewStockList();

        BeerCo.createAndPrintInvoice("banks" , 5, admin);
        BeerCo.createAndPrintInvoice("wadadli" , 5, admin);

        BeerCo.addPurchasableItem("banks", "10", admin);
        BeerCo.createAndPrintInvoice("banks" , 5, admin);

        banks.viewStockInformation();

        BeerCo.createAndPrintInvoice("banks" , 5, admin);

        banks.viewStockInformation();

        //Testing Customer Class's basic functions
        Customer John = new Customer("John", "email", "d", admin);

        John.printPurchasedItems();
        John.removePurchasedItem("presidente", 4, admin);
        John.createAndPrintSalesReceipt("banks", 4, admin);

        banks.viewStockInformation();
        John.printPurchasedItems();

        John.removePurchasedItem("banks",4, admin);
        John.printPurchasedItems();
        banks.viewStockInformation();

    }
}
