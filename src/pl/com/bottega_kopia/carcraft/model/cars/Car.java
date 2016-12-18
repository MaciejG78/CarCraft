package pl.com.bottega_kopia.carcraft.model.cars;

import pl.com.bottega_kopia.carcraft.model.engines.Engine;
import pl.com.bottega_kopia.carcraft.model.engines.combustion.CombustionEngine;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;


/**
 * Created by Slawek on 05/11/16.
 */
public class Car {

    static final double FUEL_CAPACITY = 60;
    private static final int DEFAULT_DISTANCE = 1;

    protected Engine engine;//klasy dziedziczące będą to widzieć (typ Engine i pole engine) - Referencja na Engine

    public int x;
    private int y;

    private double fuelLevel;
    private double fuelConsumption;

    private String name;

    private BodyType bodyType;

    Car(BodyType bodyType, Engine engine, String name, double fuelLevel){
        this(bodyType, engine, name, fuelLevel, 0, 0);
    }

    Car(BodyType bodyType, Engine engine, String name, double fuelLevel, int x, int y){
        this.bodyType = bodyType;

        //========== 1 ============= Przenieśliśmy do CarsFactory
        //if (fuelLevel > FUEL_CAPACITY)
        //    throw new IllegalArgumentException("Fuel level above " + FUEL_CAPACITY);

        this.engine = engine;
        this.fuelLevel = fuelLevel;
        this.name = name;

        //========== 2 ============
        //this.fuelLevel = fuelLevel > FUEL_CAPACITY ? FUEL_CAPACITY : fuelLevel;
        //========== 3 ============
        //this.fuelLevel = min(fuelLevel, FUEL_CAPACITY);

        this.fuelConsumption = fuelConsumption;
        this.x = x;
        this.y = y;
    }

    public void run(){
        if (!engine.isRunning())
        engine.start();
    }
    public void stop(){
        if(engine.isRunning())
        engine.stop();
    }

    public void left(){
        left(DEFAULT_DISTANCE);
    }
    public void right(){
        right(DEFAULT_DISTANCE);
    }
    public void up(){ up(DEFAULT_DISTANCE); }
    public void down(){
        down(DEFAULT_DISTANCE);
    }


    public void right(int distance) throws IllegalStateException{ //Nie musimy deklarować throws
        if (!engine.isRunning())
            throw new IllegalStateException("Engine is not running");

        if (distance <= 0 || isTooFar(distance))//walidacja
            return;

        int possibleDistance = (int)(fuelLevel / fuelConsumption);

        int actualDistance;
        if (possibleDistance < distance){
            actualDistance = possibleDistance;
        }
        else {
            actualDistance = distance;
        }

        x += actualDistance;
        fuelLevel -= fuelConsumption * actualDistance;
    }

    public void left(int distance) throws IllegalStateException{ //Nie musimy deklarować throws
        if (!engine.isRunning())
            throw new IllegalStateException("Engine is not running");

        if (distance <= 0 || isTooFar(distance))//walidacja
            return;

        int possibleDistance = (int)(fuelLevel / fuelConsumption);

        int actualDistance;
        if (possibleDistance < distance){
            actualDistance = possibleDistance;
        }
        else {
            actualDistance = distance;
        }

        x -= actualDistance;
        fuelLevel -= fuelConsumption * actualDistance;
    }

    public void up(int distance) throws IllegalStateException{ //Nie musimy deklarować throws
        if (!engine.isRunning())
            throw new IllegalStateException("Engine is not running");

        if (distance <= 0 || isTooFar(distance))//walidacja
            return;

        int possibleDistance = (int)(fuelLevel / fuelConsumption);

        int actualDistance;
        if (possibleDistance < distance){
            actualDistance = possibleDistance;
        }
        else {
            actualDistance = distance;
        }

        y += actualDistance;
        fuelLevel -= fuelConsumption * actualDistance;
    }

    public void down(int distance) throws IllegalStateException{ //Nie musimy deklarować throws
        if (!engine.isRunning())
            throw new IllegalStateException("Engine is not running");

        if (distance <= 0 || isTooFar(distance))//walidacja
            return;

        int possibleDistance = (int)(fuelLevel / fuelConsumption);

        int actualDistance;
        if (possibleDistance < distance){
            actualDistance = possibleDistance;
        }
        else {
            actualDistance = distance;
        }

        y -= actualDistance;
        fuelLevel -= fuelConsumption * actualDistance;
    }

    public void moveTo(int targetX, int targetY) throws FuelException{
        checkEngine();
        if (isOutOfBound(targetX, targetY)) return;

        int distanceX = Math.abs(targetX - x);
        int distanceY = Math.abs(targetY - y);
        int totalDistance = distanceX + distanceY;

        moveAndConsumeEnergyIfPossible(targetX, targetY, totalDistance);
    }

    /**
     * MOVES IF POSSIBLE
     * @param targetX
     * @param targetY
     * @param totalDistance
     * @throws FuelException
     */
    private void moveAndConsumeEnergyIfPossible(int targetX, int targetY, double totalDistance) throws FuelException{
        double requiredFuel = engine.calculateFuelConsumption(totalDistance, RPM);
        if (requiredFuel > fuelLevel)
            throw new FuelException(requiredFuel - fuelLevel);

        fuelLevel -= requiredFuel;
        x = targetX;
        y = targetY;
    }

    /**
     * moves AS FAR AS POSSIBLE
     * @param distance
     */
    private int moveAndConsumeEnergyAsPossible(int distance) {
        int possibleDistance = (int)(fuelLevel / engine.getFuelConsumption());

        int actualDistance;
        if (possibleDistance < distance){
            actualDistance = possibleDistance;
        }
        else {
            actualDistance = distance;
        }

        fuelLevel -= engine.calculateFuelConsumption(actualDistance, RPM);

        return actualDistance;
    }

    public void shortMoveTo(int targetX, int targetY) throws FuelException{//tylko jako dokumentacja, kompilator tego nie wymaga
        checkEngine();

        if (isOutOfBound(targetX, targetY))
            return;

        int a = x - targetX;
        int b = y - targetY;
        double totalDistance = sqrt(pow(a, 2) + pow(b, 2));

        moveAndConsumeEnergyIfPossible(targetX, targetY, totalDistance);
    }

    private void checkEngine() {
        if (!engine.isRunning())
            throw new IllegalStateException("Engine is not running");
    }

    private boolean isOutOfBound(int targetX, int targetY) {
        return targetX < 0 || targetY < 0;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public byte getDoorsCount(){
        return bodyType.getDoorsCount();
    }

    @Override
    public String toString() {
        //StringBuilder - niedporny na wątki, szybszy
        //StringBuffer  - odporny na wątki, wolniejszy
        //StringBuilder sb = new StringBuilder();
        //return sb.append("x=").append(x).append(" ").toString();
        return "x=" + x + " y=" + y + " f="+fuelLevel; //prekompilator robi to za nas
    }

    /* Equals -----------------------
    // =============1 sposób na equals może być na rekrutacji
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return name.equals(car.name);

    }

    // =============2 sposób na equals - może być na rekrutacji
    public boolean equals(Object o){
        if (this == o) return true; //this - referencja na obiekt na rzecz którego została wygenerowana metoda np. fastCar

        if (o instanceof Car){ //Sprawdzenie czy rzutowanie (casting) się uda. Czy obiekt o jest instancją Car.
            Car car = (Car) o;
            return this.name.equals(car.name);

        }
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    */
}