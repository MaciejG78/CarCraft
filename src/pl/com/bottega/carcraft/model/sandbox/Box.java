package pl.com.bottega.carcraft.model.sandbox;

/**
 * Created by macie on 19.11.2016.
 */
//Pojęcie typów generycznych zdolność do przechowywania obiektów np. ContentType - nazwa dowolna
public class Box<ContentType extends Weighable, PackageType> implements Weighable{

    private final int maxWeight;
    private ContentType content;
    private PackageType packing;

    public Box(int maxWeight){
        this.maxWeight = maxWeight;
    }

    public void put(ContentType content) {
        if (maxWeight < content.getWeight())
            throw new IllegalArgumentException("Content too heavy");
        this.content = content;
    }

    public ContentType pop() {
        return content;
    }

    public void wrap(PackageType packing){
        this.packing = packing;
    }

    public int getWeight() {
        if (content == null)
            return 100;
        else
            return content.getWeight() + 100;
    }
}
