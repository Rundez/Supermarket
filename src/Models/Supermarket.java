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

    public static void main(String[] args) {

        EnterEvent enter = new EnterEvent();
        initCustomers();
        enter.customersEntering(custList);


    }

    private static void initCustomers(){
        int customers = 10;
        for (int i = 0; i <= customers; i++) {

            Customer cust = new Customer(i);
            custList.add(cust);
            System.out.println("Customer: " + cust.getId() + " created");
        }
    }
}
