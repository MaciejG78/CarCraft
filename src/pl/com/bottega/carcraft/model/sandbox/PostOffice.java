package pl.com.bottega.carcraft.model.sandbox;

/**
 * Created by macie on 19.11.2016.
 */
public class PostOffice {

    public static void main(String[] args) {
        //Używamy typów generycznych
        Box<Present, String> box = new Box<Present, String>(5000); //można krócej: Box<Present> box = new Box<>();
        Present present = new Present("Opakowanie różowe", 50);
        box.put(present);
        box.wrap("różowy papier");
       // box.put(50);
        //box.put("Komputer");
        send(box);
        receivePresent(box);


        Box<Box<Present, String>, String> doublePackedBox = new Box <> (5000);
        doublePackedBox.put(box);
        Box<Present, String> popped = doublePackedBox.put();

    }

    private static void receivePresent(Box<Present, String> box) {
        Present present = box.pop();
        present.unwrap();

    }

    public static void send(Box<Present, String> box) {
        System.out.println("Wysyłam paczkę z " + box.pop());

    }
}
