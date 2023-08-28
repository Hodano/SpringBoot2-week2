package pl.hodan.shop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Profile("Pro")
public class ShopCartPro extends ShopCartPlus {
    @Value("${profile-info.discount}")
    private int discount;

    @Override
    public double getTotalPrices() {
        return super.getTotalPrices() - calculateDiscount();
    }

    public double calculateDiscount(){
        return (super.getTotalPrices() *discount)/100;
    }
    @EventListener(ApplicationReadyEvent.class)
    public void displayResult(){
        System.out.println("Total Prices + vat - discount : "+ Math.round(getTotalPrices()*100.0)/100.0);
    }
}
