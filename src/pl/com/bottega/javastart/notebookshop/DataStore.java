package pl.com.bottega.javastart.notebookshop;

/**
 * Created by macie on 06.01.2017.
 */
public class DataStore {
    public static final int MAX_COMPUTERS = 100;

    private Computer[] computers;
    private int computersNumber;

    public Computer[] getComputers() {
        Computer[] comps = new Computer[computersNumber];
        for (int i = 0; i < computersNumber; i++) {
            comps[i] = computers[i];
        }
        return comps;
    }

    public void setComputers(Computer[] computers) {
        this.computers = computers;
    }

    public int getComputersNumber() {
        return computersNumber;
    }

    public void setComputersNumber(int computersNumber) {
        this.computersNumber = computersNumber;
    }

    public DataStore() {
        computers = new Computer[MAX_COMPUTERS];
        computersNumber = 0;
    }

    public void add(Computer comp) {
        if (computersNumber < MAX_COMPUTERS) {
            computers[computersNumber] = comp;
            computersNumber++;
        }
    }

    public int checkAvaiability(Computer find) {
        if (find == null)
            return 0;

        int count = 0;
        for (int i = 0; i < computersNumber; i++) {
            if (find.equals(computers[i])) {
                count++;
            }
        }
        return count;
    }
}
