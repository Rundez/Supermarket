package Models;

import Events.EnterEvent;
import Events.ShoppingEvent;
import Events.TillEvent;
import Events.TillEvent2;

import java.util.ArrayList;

public class Supermarket {

    private static ArrayList<Customer> custList = new ArrayList<>();
    private static boolean enterEvent = false;
    private static boolean shoppingEvent = false;
    private static boolean tillEvent = false;
    private static boolean leaveEvent = false;


    public static void main(String[] args) {

        EnterEvent enter = new EnterEvent();
        initCustomers();
        // TODO: EnterEvent må returnere sortert liste
        enter.customersEntering(custList);

        // Starts the shopping event by creating the object and passing in the customers sorted by time.
        ShoppingEvent shopping = new ShoppingEvent(enter.getCustomers());
        // shopping.getStatList returnerer sortert liste etter shopping event
        ArrayList<Customer> customers = shopping.getStatList();

        // TODO: TillEvent må returnere liste med kunder i rekkefølge etter eventet
        TillEvent2 tillEvent = new TillEvent2(1);
        tillEvent.treatCustomer(customers);

        tillEvent.setAvgQueueTime();
        System.out.println("\nAverage queue time: " + tillEvent.getAvgQueueTime());
        tillEvent.printMaxCustInQueue();



    }


    private static void initCustomers() {
        int customers = 10;
        for (int i = 0; i <= customers; i++) {

            Customer cust = new Customer(i);
            custList.add(cust);
            System.out.println("Customer: " + cust.getId() + " created");
        }
    }

    public static boolean checkShoppingEventCustomers() {
        if (custList.get(0).getCurrentTime() >= Time.getTime()) {
            return true;
        } else {
            return false;
        }
    }


}
