package Models;

import Events.EnterEvent;
import Events.ShoppingEvent;
import Events.TillEvent;
import Jframe.JFX;
import javafx.application.Application;

import java.util.ArrayList;

public class Supermarket {

    private static ArrayList<Customer> custList = new ArrayList<>();


    public static void main(String[] args) {

        EnterEvent enter = new EnterEvent();
        initCustomers();
        enter.customersEntering(custList);

        // Starts the shopping event by creating the object and passing in the customers sorted by time.
        ShoppingEvent shopping = new ShoppingEvent(enter.getCustomers());
        ArrayList<Customer> customers = shopping.getStatList();

        TillEvent tillEvent = new TillEvent();


        tillEvent.treatCustomer(customers);

        tillEvent.setAvgQueueTime();
        System.out.println("\n Average queue time: " + tillEvent.getAvgQueueTime());
        System.out.println("\n Maximum queue size: " + tillEvent.getMaxCustInQueue());
        Application.launch(JFX.class, args);
    }


    private static void initCustomers(){
        int customers = 10;
        for (int i = 0; i <= customers; i++) {

            Customer cust = new Customer(i);
            custList.add(cust);
            System.out.println("Customer: " + cust.getId() + " created");
        }
    }

    public static boolean checkShoppingEventCustomers(){
            if (custList.get(0).getCurrentTime() >= Time.getTime()) {
                return true;
        } else {
                return false;
            }
    }



}
