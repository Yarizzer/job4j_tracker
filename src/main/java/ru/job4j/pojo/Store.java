package ru.job4j.pojo;

public class Store {
    private static Product[] getModel() {
        Product milk = new Product("Milk", 10);
        Product bread = new Product("Bread", 4);
        Product egg = new Product("Egg", 19);
        Product[] prods = new Product[3];
        prods[0] = milk;
        prods[1] = bread;
        prods[2] = egg;
        return prods;
    }

    public static void main(String[] args) {
        Product[] prods = getModel();
        for (int index = 0; index < prods.length; index++) {
            Product pr = prods[index];
            System.out.println(pr.getName() + " - " + pr.getCount());
        }
        Product oil = new Product("Oil", 11);
        prods[0] = oil;
        for (int index = 0; index < prods.length; index++) {
            Product pr = prods[index];
            System.out.println(pr.getName() + " - " + pr.getCount());
        }
        for (int index = 0; index < prods.length; index++) {
            Product pr = prods[index];
            if (pr.getCount() > 10) {
                System.out.println(pr.getName() + " - " + pr.getCount());
            }
        }
    }
}
