package Events;

import Models.Customer;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class is an simulation of the shopping phase
 * @author Kristian/Martin
 */
public class ShoppingEvent extends Event {

    /**
    * ShoppingEvent is the event in which the customer will be putting there goods in there cart
    * It take in the customerArraylist which we use.
    *
    * @param customerArrayList take an Arraylist of Customer objecttypes
    *
     */
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

