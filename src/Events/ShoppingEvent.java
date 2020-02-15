package Events;

import Models.Customer;
import Models.Time;

import java.util.ArrayList;
import java.util.Random;

public class ShoppingEvent extends Event {
    private ArrayList<Customer> statList = new ArrayList<>();

    public ShoppingEvent(){


    }

    public void customerShops(ArrayList<Customer> kunder){
        for(Customer kunde: kunder){
            int kundesTotalTid =  timeAfterShopping();
            System.out.println(kunde.getGoods() + " varer i kunde " + kunde.getId() + " sin container og den tid brukt på å handle " + timeAfterShopping() + " og kundens total tid er: " + kundesTotalTid);
        }

    }
    //The time will be random and is an representation in which the customer uses diffrent time to find there goods
    public int timeAfterShopping(){
        Random rand = new Random();
        int newTime = rand.nextInt(15) + 1;
        int time = newTime;
        return time;

    }


}

