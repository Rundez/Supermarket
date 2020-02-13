package Events;

import Models.Customer;

import java.util.ArrayList;

public class ShoppingEvent extends Event {
    public ShoppingEvent(){


    }

    public void checkStatus(ArrayList<Customer> kunder){
        for(Customer kunde: kunder){
            System.out.println(kunde.getGoods() + " varer i kunde " + kunde.getId() + " sin container og den totale tiden brukt " + kunde.getTotalTime());
        }

    }

}

