package pl.hodan.shop;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Profile("Start")
@Service
public class ShopCartStart {
    protected List<Product> products;


    public ShopCartStart() {
        Product product1 = new Product("Chicken", RandomPrice.getRandomPrice());
        Product product2 = new Product("Bread", RandomPrice.getRandomPrice());
        Product product3 = new Product("Chips", RandomPrice.getRandomPrice());
        Product product4 = new Product("CocaCola", RandomPrice.getRandomPrice());
        Product product5 = new Product("Salad", RandomPrice.getRandomPrice());


        products = new ArrayList<>();

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);

    }

    public void addProduct(Product product)
    {
        products.add(product);

    }


    public double getTotalPrices() {
        double prices =
        products.stream()
                .mapToDouble(product -> product.getPrice()).sum();


        return prices;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void displayResult(){
        System.out.println("Total Prices : " + Math.round(getTotalPrices()*100.0)/100.0);
    }

}
