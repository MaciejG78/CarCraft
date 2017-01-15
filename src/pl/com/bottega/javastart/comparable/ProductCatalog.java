package pl.com.bottega.javastart.comparable;

import java.util.Arrays;

/**
 * Created by macie on 11.01.2017.
 */
public class ProductCatalog {
    public static void main(String[] args) {
        Product[] products = new Product[7];
        products[0] = new Product("Amino", "Zupa pomidorowa", "Zupy");
        products[1] = new Product("Amino", "Zupa ogórkowa", "Zupy");
        products[2] = new Product("WINIARY", "Zupa pomidorowa", "Zupy");
        products[3] = new Product("WINIARY", "Zupa pomidorowa", "Zupy błyskawiczne");
        products[4] = new Product("WINIARY", "Rosół", "Zupy");
        products[5] = new Product("Knorr", "Placki ziemniaczane", "Dania obiadowe");
        products[6] = new Product("Knorr", "Racuchy", "Dania obiadowe");

        System.out.println("Nieposortowana: ");
        for(Product p: products) {
            System.out.println(p);
        }

        Arrays.sort(products, new Product.ProductNameComparator());
        System.out.println("Posortowana: ");
        for(Product p: products) {
            System.out.println(p);
        }

        /* Rozwiązanie nailepsze z wykorzystaniem anonimowej klasy wewnętrznej
        Arrays.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
            return o1.getProducer().compareTo(o2.getProducer());
    }
});
         */
    }
}
