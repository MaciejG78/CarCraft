package pl.com.bottega.carcraft.model.cars;

/**
 * Created by Slawek on 13/11/16.
 */
public enum BodyType {
    SEDAN((byte)4, (byte)6), ROADSTER((byte)2, (byte)10), HATCHBACK((byte)5, (byte)7), CABRIO((byte)2, (byte)6),SUV((byte)5, (byte)4);

    private byte doorsCount;
    private byte sexiness;

    BodyType(byte doorsCount, byte sexiness){
        this.doorsCount = doorsCount;
        this.sexiness = sexiness;
    }

    public byte getDoorsCount() {
        return doorsCount;
    }

    public byte getSexiness() {
        return sexiness;
    }
}