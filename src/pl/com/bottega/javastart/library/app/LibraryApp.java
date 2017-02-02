package pl.com.bottega.javastart.library.app;
 
public class LibraryApp {
    public static void main(String[] args) {
        final String appName = "Biblioteka v1.00";
        System.out.println(appName);
        LibraryControl libControl = new LibraryControl();
        libControl.controlLoop();
    }
}