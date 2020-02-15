package Events;

import Models.Customer;
import Models.Time;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ShoppingEvent extends Event {


    public ShoppingEvent(ArrayList<Customer> customerArrayList){
        ArrayList<Customer> statList;
        statList = customerShops(customerArrayList);
        statList = sortCustByTime(statList);
        printStats(statList);

        

    }

    private ArrayList<Customer> customerShops(ArrayList<Customer> kunder){
        for(Customer kunde: kunder){
            int kundesHandleTid =  timeOnShopping(kunde.getGoods());
            // The customers total time spent shopping.
            kunde.setShoppingTime(kundesHandleTid);
            // Adds the shopping time to the current time of the customer.
            kunde.setTime(kundesHandleTid + kunde.getStartTime());
        }

        return kunder;
    }

    // Static modifier to add shoppingTime to the customer.
    private int timeOnShopping(int varer){
        int sum = varer * 2;

        return sum;
    }

    // Returns the customers sorted by time.
    private ArrayList<Customer> sortCustByTime(ArrayList<Customer> customerList){
        Collections.sort(customerList);


        return customerList;
    }

    private void printStats(ArrayList<Customer> custList){

        for(Customer kunde : custList) {
            System.out.println(kunde.getGoods() + " varer i kunde " + kunde.getId() + " sin handlevogn. Total tid på shopping: " + kunde.getShoppingTime() + " og kundens total tid er: " + kunde.getCurrentTime());
        }
    }


}

