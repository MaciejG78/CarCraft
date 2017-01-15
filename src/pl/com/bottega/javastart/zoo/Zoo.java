package pl.com.bottega.javastart.zoo;

/**
 * Created by macie on 06.01.2017.
 */
public class Zoo {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];
        animals[0] = new Dog("Burek");
        animals[1] = new Cat("Mruczek");
        animals[2] = new Animal("Kotopies");

        changeAnimalName(animals[0], "Pieseł");

        Animal dog = new Dog("Burek");;
        Animal cat = new Cat("Mruczek");

        //rzutowanie do zmiennej
        Dog specificDog = (Dog)dog;
        specificDog.bark();

        //rzutowanie "w locie"
        ((Cat)cat).meow();

        for(Animal animal: animals) {
            animal.giveSound();
        }
    }

    private static void changeAnimalName(Animal animal, String newName) {
        animal.setName(newName);
    }
}
