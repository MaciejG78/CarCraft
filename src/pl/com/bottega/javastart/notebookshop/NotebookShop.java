package pl.com.bottega.javastart.notebookshop;

/**
 * Created by macie on 06.01.2017.
 */
public class NotebookShop {
    public static void main(String[] args) {
        DataStore dataStore = new DataStore();
        dataStore.add(new Computer("ASUS", 12345));
        dataStore.add(new Computer("ASUS", 12345));
        dataStore.add(new Computer("APPLE", 5));
        dataStore.add(new Computer("APPLE", 6));
        dataStore.add(new Computer("HP", 8871927));

        Computer compToFind = new Computer("ASUS", 12345);
        int computersFound = dataStore.checkAvaiability(compToFind);
        System.out.println("Liczba komputerów " + compToFind + ": " + computersFound);

        System.out.println("Wszystkie dostępne komputery: ");
        for(Computer c: dataStore.getComputers()) {
            System.out.println(c);
        }
    }
}
