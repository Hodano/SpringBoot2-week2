package pl.hodan.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class RandomPrice {
    public static double getRandomPrice(){
        Random random = new Random();


        return  random.nextDouble(251 + 50);
    }
}
