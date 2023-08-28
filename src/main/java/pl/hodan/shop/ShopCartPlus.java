package pl.hodan.shop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;




@Profile("Plus")
@Service
public class ShopCartPlus extends ShopCartStart{
    @Value("${profile-info.vat}")
    private int vat;


    @Override
    public double getTotalPrices() {
        double totalPrice = super.getTotalPrices() + calculateVat();
        return totalPrice;
    }

    public double calculateVat(){
        return (super.getTotalPrices() * vat)/100;
    }
    @EventListener(ApplicationReadyEvent.class)
    public void displayResult(){
        System.out.println("Total Prices + vat: "+ Math.round(getTotalPrices()*100.0)/100.0);
    }
}
