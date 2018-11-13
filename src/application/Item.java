package application;

import java.lang.Math;


/*
Item class is used to create objects representing a single item in the list.

Constructor:
String name: Item name
int quantity: quantity of item
double amount: amount of item

double total: Total amount.

Class methods:
newItem(Item item)
itemAt(int pos)
removeItem(int pos)
editItem(int pos, Item item)

*/

public class Item {
    private String name;
    private int quantity = 0;
    private double amount = 0.0;
    private double total = 0.0;


    Item(String name, int quantity, double amount) {
        this.name = name;
        this.quantity = quantity;
        this.amount = amount;
    }

    public double calcTotal() {
        this.total = (double)Math.round(this.quantity * this.amount * 100d)/100d;
        return this.total;
    }

    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getAmount() {
        return this.amount;
    }

    public double getTotal() {
        return this.total;
    }
}
