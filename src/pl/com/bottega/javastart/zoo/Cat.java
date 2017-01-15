package pl.com.bottega.javastart.zoo;

/**
 * Created by macie on 06.01.2017.
 */
public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void giveSound() {
        System.out.println("Jestem kotem i nazywam się " + getName());
    }

    public void meow(){
        System.out.println("Miaaaaau");
    }
}
