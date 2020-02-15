package Events;

import Models.Customer;
import Models.Time;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ShoppingEvent extends Event {
    private ArrayList<Customer> statList ;

    public ShoppingEvent(ArrayList<Customer> statList){
        this.statList = statList;

        customerShops();
        sortCustByTime();
        printStats(statList);
        setCurrentSystemTime();

    }

    private void customerShops(){
        for(Customer kunde: statList){
            int kundesHandleTid =  timeOnShopping(kunde.getGoods());
            // The customers total time spent shopping.
            kunde.setShoppingTime(kundesHandleTid);
            // Adds the shopping time to the current time of the customer.
            kunde.setTime(kundesHandleTid + kunde.getStartTime());
        }
    }

    // Static modifier to add shoppingTime to the customer.
    private int timeOnShopping(int varer){
        int sum = varer * 2;

        return sum;
    }

    // Returns the customers sorted by time.
    private void sortCustByTime(){
        Collections.sort(statList);

    }

    private void printStats(ArrayList<Customer> custList){
        for(Customer kunde : custList) {
            System.out.println(kunde.getGoods() + " varer i kunde " + kunde.getId() + " sin handlevogn. Total tid på shopping: " + kunde.getShoppingTime() + " og kundens total tid er: " + kunde.getCurrentTime());
        }
    }

    // Sets the simulation time equals to the lowest time value of the customers.
    private void setCurrentSystemTime(){
        Time.setTime(statList.get(0).getCurrentTime());
        System.out.println(Time.getTime());
    }
}

