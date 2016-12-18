package pl.com.bottega.carcraft.model.cars;

import com.sun.deploy.util.StringUtils;
import pl.com.bottega.carcraft.model.engines.Engine;
import pl.com.bottega.carcraft.model.engines.combustion.CombustionEngine;

import java.util.*;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;


/**
 * Created by Slawek on 05/11/16.
 */
public class Car<L> { //Dla referencji L było: public class Car<L>

    //Referencja na L było: private L load;
    //private ArrayList<L> load = new ArrayList<>(); tak mogło by być ale lepiej wpisać Collection gdyż jest bardziej ogólny i można
    // połączyc z ArrayListą oraz LinkedList
    //Możemy pisać: private Collection<L> load = new ArrayList<L>(); ale Collection jest zbyt ogólny i nie ma np. get, lepszy jest List
    private List<L> load = new ArrayList<L>();

    //pole zawiewrające informację o pasażerach
    private Set<Human> passengers = new HashSet<>();

    static final double FUEL_CAPACITY = 60;
    private static final int DEFAULT_DISTANCE = 1;

    private static final int RPM = 2500;

    protected Engine engine;//klasy dziedziczące będą to widzieć

    private int x;
    private int y;

    private double fuelLevel;


    private String name;

    private BodyType bodyType;

    Car(BodyType bodyType, Engine engine, String name, double fuelLevel){
        this(bodyType, engine, name, fuelLevel, 0, 0);
    }

    Car(BodyType bodyType, Engine engine, String name, double fuelLevel, int x, int y){
        this.bodyType = bodyType;
        this.engine = engine;

        this.fuelLevel = fuelLevel;
        this.name = name;

        //========== 1 ============= Przenieśliśmy do CarsFactory
        //if (fuelLevel > FUEL_CAPACITY)
        //    throw new IllegalArgumentException("Fuel level above " + FUEL_CAPACITY);
        //========== 2 ============
        //this.fuelLevel = fuelLevel > FUEL_CAPACITY ? FUEL_CAPACITY : fuelLevel;
        //========== 3 ============
        //this.fuelLevel = min(fuelLevel, FUEL_CAPACITY);


        this.x = x;
        this.y = y;
    }

    public void run(){
        if (!engine.isRunning())
            engine.start();
    }

    public void stop(){
        if (engine.isRunning()) {
            engine.stop();
        }
    }



    public void up() {
        up(DEFAULT_DISTANCE);
    }

    public  void up(int distance) {
        checkEngine();
        if (isOutOfBound(x, y+distance))
            return;
        int actualDistance = moveAndConsumeEnergyAsPossible(distance);
        y += actualDistance;
    }

    public void down() {
        down(DEFAULT_DISTANCE);
    }

    public void down(int distance) {
        checkEngine();
        if (isOutOfBound(x, y-distance))
            return;
        int actualDistance = moveAndConsumeEnergyAsPossible(distance);
        y -= actualDistance;
    }

    public void left(){
        left(DEFAULT_DISTANCE);
    }

    public void right() {
        right(DEFAULT_DISTANCE);
    }

    public void right(int distance){
        checkEngine();
        if (isOutOfBound(x+distance, y))
            return;
        int actualDistance = moveAndConsumeEnergyAsPossible(distance);
        x += actualDistance;
    }

    public void left(int distance) throws IllegalStateException{//nie musimy deklarować throws dla wyjątków unchecked
        checkEngine();
        if (isOutOfBound(x-distance, y))
            return;
        int actualDistance = moveAndConsumeEnergyAsPossible(distance);
        x -= actualDistance;
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

//Metody pozwalające wkładać i wyjmowac ładunek z auta przy referencjach z L było zamiast ArrayList L
    public void put(L load) {
        this.load.add(load);
    }

    public ArrayList<L> pop() {
        ArrayList<L> tmp = new ArrayList<L>();
        tmp.addAll(load);
        load.clear();
        return tmp;
    }
/*
    public void put(Human load) {
        this.load.add(load);
    }

    public ArrayList<L> pop() {
        ArrayList<L> tmp = new ArrayList<L>();
        tmp.addAll(load);
        load.clear();
        return tmp;
    }
  */


    @Override
    public String toString() {
        //StringUtils.join(load, ", ") = łaczy wszystkie elementy koleckcji
        //String loadString = load == null ? "empty" : StringUtils.join(load, ", ");
        return "x=" + x + ", y=" + y + ", f=" + fuelLevel + ", l=" + loadString(load); //prekompilator robi to za nas
    }

    public String loadString(Collection<L> load){
        return load.isEmpty() ? "empty" : StringUtils.join(load, ", ");

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }


}