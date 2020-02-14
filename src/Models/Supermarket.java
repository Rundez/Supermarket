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

    Queue<Event> events = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {
        // Starts the time for the simulation
        Time.startTime();

        EnterEvent enter = new EnterEvent();
        ShoppingEvent shopping = new ShoppingEvent();

<<<<<<< HEAD
        enter.generateCustomers(500);
=======
      ArrayList<Customer> kunder = enter.generateCustomers();
>>>>>>> Shopping
        enter.printCustomerInfo();
        shopping.checkStatus(kunder);


    }
}
