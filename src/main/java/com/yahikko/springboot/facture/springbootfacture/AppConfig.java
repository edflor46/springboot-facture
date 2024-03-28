package com.yahikko.springboot.facture.springbootfacture;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.yahikko.springboot.facture.springbootfacture.models.Item;
import com.yahikko.springboot.facture.springbootfacture.models.Product;

@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8") 
public class AppConfig {

    private static final String PRODUCT_ONE = "Play Station 5";
    private static final Integer PRODUCT_PRICE_ONE = 9000;
    private static final String PRODUCT_SECOND = "Nintento Switch";
    private static final Integer PRODUCT_PRICE_SECOND = 5500;
    private static final String PRODUCT_THIRD = "Monitor Curvo ASUS";
    private static final Integer PRODUCT_PRICE_THIRD = 19000;

    @Bean("default")
    List<Item> itemsInvoice() {
        final List<Item> items = new ArrayList<>();

        final Product productOne = new Product(PRODUCT_ONE, PRODUCT_PRICE_ONE);
        final Product productSecond = new Product(PRODUCT_SECOND, PRODUCT_PRICE_SECOND);
        final Product productThird = new Product(PRODUCT_THIRD, PRODUCT_PRICE_THIRD);

        final Item itemOne = new Item(productOne, 3);
        final Item itemSecond = new Item(productSecond, 5);
        final Item itemThird = new Item(productThird, 2);

        items.add(itemOne);
        items.add(itemSecond);
        items.add(itemThird);

        return items;
    }

    //@Primary
    @Bean
    List<Item> itemsInvoiceSecond() {
        final List<Item> items = new ArrayList<>();

        final Product productOne = new Product(PRODUCT_ONE, PRODUCT_PRICE_ONE);
        final Product productSecond = new Product(PRODUCT_SECOND, PRODUCT_PRICE_SECOND);
        final Product productThird = new Product(PRODUCT_THIRD, PRODUCT_PRICE_THIRD);

        final Item itemOne = new Item(productOne, 1);
        final Item itemSecond = new Item(productSecond, 1);
        final Item itemThird = new Item(productThird, 1);

        items.add(itemOne);
        items.add(itemSecond);
        items.add(itemThird);

        return items;
    }

}
