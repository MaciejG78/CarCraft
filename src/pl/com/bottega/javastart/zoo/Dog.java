package pl.com.bottega.javastart.zoo;

/**
 * Created by macie on 06.01.2017.
 */
public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void giveSound() {
        System.out.println("Jestem psem i nazywam się " + getName());
    }

    public void bark(){
        System.out.println("Hau hau!");
    }
}
