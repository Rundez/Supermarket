package Models;

import Events.EnterEvent;
import Events.Event;
import Events.ShoppingEvent;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Supermarket {

    private static ArrayList<Customer> custList = new ArrayList<>();
    private static Queue<Customer> q = new LinkedList<>();

    public static void main(String[] args) {

        EnterEvent enter = new EnterEvent();
        initCustomers();
        enter.customersEntering(custList);

        // Starts the shopping event by creating the object and passing in the customers sorted by time.
        ShoppingEvent shopping = new ShoppingEvent(enter.getCustomers());




    }

    private static void initCustomers(){
        int customers = 10;
        for (int i = 0; i <= customers; i++) {

            Customer cust = new Customer(i);
            custList.add(cust);
            System.out.println("Customer: " + cust.getId() + " created");
        }
    }

    private static void fillQueue(){
        q.addAll(custList);
    }
}
