package com.StockManager;

public class Driver {
    public static void main(String[] args) {
        User admin = new User("Kaleel Boston", "kaleelboston@gmail.com", "KB12", "admIn", "password");
//        User reg = new User("Kaleel Boston", "kaleelboston@gmail.com", "KB12", "regular", "password");
        Stock beer = new Stock("Wadadli", "Antiguan Beer", "B1", "Alchohol", 10.0, admin);
//        Stock beer = new Stock("Wadadli", "Antiguan Beer", "B1", "Alchohol", 10.0, reg);

        beer.viewStock();
        beer.addStock(5);
        beer.viewStock();
        beer.removeStock(3);
        beer.viewStock();
        beer.editStock("Carib", "Caribbean Beer", "B2", "Alcohol", 10.0, admin);
//        beer.editStock("Carib", "Caribbean Beer", "B2", "Alcohol", 10.0, reg);
        beer.viewStock();
        beer.addStock(5);
        beer.viewStock();
        beer.removeStock(3);

        Supplier BeerCo = new Supplier("BeerCo", "3", 3, admin);

        BeerCo.addPurchasableItem("beer", "10", admin);
        BeerCo.addPurchasableItem("beer2", "10", admin);
        BeerCo.addPurchasableItem("beer3", "10", admin);
        BeerCo.addPurchasableItem("beer4", "10", admin);
        BeerCo.addPurchasableItem("beer5", "10", admin);
        BeerCo.addPurchasableItem("beer6", "10", admin);
        BeerCo.addPurchasableItem("beer7", "10", admin);
        BeerCo.addPurchasableItem("beer8", "10", admin);
        BeerCo.addPurchasableItem("beer9", "10", admin);
        BeerCo.addPurchasableItem("beer10", "10", admin);
        BeerCo.addPurchasableItem("beer11", "10", admin);
        BeerCo.addPurchasableItem("beer12", "10", admin);
        BeerCo.addPurchasableItem("beer13", "10", admin);
        BeerCo.addPurchasableItem("beer14", "10", admin);
        BeerCo.addPurchasableItem("beer15", "10", admin);
        BeerCo.addPurchasableItem("beer16", "10", admin);
        BeerCo.addPurchasableItem("beer17", "10", admin);
        BeerCo.addPurchasableItem("beer18", "10", admin);
        BeerCo.addPurchasableItem("beer19", "10", admin);
        BeerCo.addPurchasableItem("beer20", "10", admin);
        BeerCo.addPurchasableItem("beer21", "10", admin);

        BeerCo.printPurchasableItems();

        BeerCo.removePurchasableItem("beer4", admin);

        BeerCo.printPurchasableItems();
    }
}
