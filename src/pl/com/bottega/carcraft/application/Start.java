package pl.com.bottega.carcraft.application;

import pl.com.bottega.carcraft.model.cars.Car;
import pl.com.bottega.carcraft.model.cars.CarsFactory;
import pl.com.bottega.carcraft.model.cars.FuelException;
import pl.com.bottega.carcraft.model.infrastructure.GasStation;
import pl.com.bottega.carcraft.model.sandbox.Present;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Slawek on 05/11/16.
 */
public class Start {
    private static byte[][] map = new byte[15][15];
  //  private static AWTKeyStroke key;

    public static void main(String[] args){


        Car<Present> slowCar = null;
        Car<String> fastCar = null;
        //GasStation gasStation = null;

        GasStation rote19 = GasStation.createSmall(4, 5);

        try {

            //slowCar = new HybridCar(new VAG_30TDI(), new ElectricEngine(), "prius", 30, 40, 1, 1); //Pierwsza metoda wstawienia referencji Engine (najbezpieczniejsza, bo nikt niżej nie użyje (kompozycja - silna agregacja z samochodem)
            slowCar = CarsFactory.create("911", 30, 1, 1, new Present("Rozowy", 50));

            //Engine engine = new BMW_N55(); //Druga metoda wstawienia referencji Engine - mniej bezpieczna, bo ktoś może użyć w kodzie poniżej np. engine.stop;
            //fastCar = new Car(engine, "fast", 50, 0.1, 2, 3);
            fastCar = CarsFactory.create("mustang", 90, 3, 4, "Fancy MacBook");

            }

        catch (IllegalArgumentException ex){
            //ex.printStackTrace(); zła praltyka, użyć logger
            System.out.println("nie moge uruchomoc programu ;( " + ex.getMessage());
            return;
        }


        Random random = new Random();
        //zakres losowania
        int maxX = map.length;
        int maxY = map[0].length;

        try {
            byte go = 1;
            do{
                //System.out.print("\033[2J");//clear console
                System.out.print("\033[H\033[2J");
                System.out.flush();

                /* Ruch samochodu w losowo wybrane miejsce
                fastCar.moveTo(random.nextInt(maxX), random.nextInt(maxY));//ruch w losowe miejsce
                */
                //Poruszanie za pomoca strzałek
/*
                //this.addKeyListener(new KeyListener() {

                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    public void keyPressed(KeyEvent e) {
                                            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                                                System.out.println("Prawo");
                                            }
                                            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                                                System.out.println("Lewo");
                                            }
                                        }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                });
            */
                        System.out.println(fastCar);//info o samochodzie

                int x = fastCar.getX();
                int y = fastCar.getY();
                int stationx = rote19.getX();
                int stationy = rote19.getY();
                map[x][y] = 1;
                map[stationx][stationy] = 2;

                printMap();

                char character = readKey();
                //fastCar.handleKey(character); zbrodnia przeciw ludzkości! Samochód sam nie może gadać z klawiaturą


                switch (character){
                    case 'e':
                        fastCar.run(); //uruchom silnik
                        break;
                    case 'r':
                        fastCar.stop(); //zatrzymaj silnik
                        break;
                    case 'w':
                        fastCar.up();
                        break;
                    case 's':
                        fastCar.down();
                        break;
                    case 'd':
                        fastCar.right();
                        break;
                    case 'a':
                        fastCar.left();
                        break;
                    case 'l':
                        fastCar.put(new Integer(random.nextInt()).toString());
                        break;
                    case 'u':
                        ArrayList<String> unloaded = fastCar.pop();
                        System.out.println(fastCar.loadString(unloaded));
                        break;
                    case 'q':
                        go = 0;
                    default:
                        //kod który wykona się gdy nic nie pasuje

                }
                /*
                //Sterowanie
                if (character == 'w')
                    fastCar.up();
                else if (character == 'd')
                    fastCar.right();
                else if (character == 'a')
                    fastCar.left();
                else if (character == 's')
                    fastCar.down();
                */


               // go = character != 'q';
            }while(go == 1);

        }
        catch(IllegalStateException | FuelException ex){
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static char readKey() throws IOException {
        Scanner s= new Scanner(System.in);
        char ch = s.next().charAt(0);
        return ch;
    }

    private static void printMap(){
        int rowsCount = map[0].length;//ilość wierszy pobrana z pierwszej kolumny (może być z jakiejkolwiek)

        for (int row = rowsCount-1; row >= 0; row--){//wiersze od ostatniego aby układ był zorientowany od dolnego lewego rogu
            for (int col = 0; col < map.length; col++){//kolejne kolumny danego wiersza
                byte cell = map[col][row];
                if (map[col][row] == 1){ //Jeśli jest 1 to samochód
                    System.out.print(" X ");
                } else if (map[col][row] == 2) //Jeśli 2 to GasStation
                    System.out.print(" G ");
                else if (map[col][row] == 3) //Jeśli 3 to Parking
                    System.out.print(" P ");
                else{
                    System.out.print(" . ");
                }
            }
            System.out.println();//na koniec wiersza łamiemy linię
        }
    }
}