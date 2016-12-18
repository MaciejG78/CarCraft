package pl.com.bottega_kopia.carcraft.model.cars;

/**
 * Created by macie on 13.11.2016.
 */
public enum BodyType {
    COUPE((byte)4, (byte)6), SEDAN((byte)4, (byte)2), HATCHBACK((byte)5, (byte)6), SUV((byte)5, (byte)3), WAGON((byte)5, (byte)2), ROADSTER((byte)2, (byte)10);

    private byte doorsCount;
    private byte sexiness;

    BodyType(byte doorsCount, byte sexiness){
        this.doorsCount = doorsCount;
        this.sexiness = sexiness;
    }

    public byte getDoorsCount(){
        return doorsCount;
    }

    public byte getSexiness(){
        return sexiness;
    }

}
