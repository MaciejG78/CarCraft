package pl.com.bottega.jackpot.model.devices;

/**
 * Created by macie on 21.11.2016.
 */
public class FakeConsoleDisplayDevice implements DisplayDevice {

        @Override
        public int getRandomWindowsCount() {
            return 3;
        }

        @Override
        public int getRandomElementsCount() {
            return 4;
        }

        @Override
        public void displayWin(int[] results) {
            System.out.println("=========== wygrałeś ============");
            String[] images = convert(results);
            for(String image : images)
                System.out.print(image);
        }

        @Override
        public void displayFail(int[] results) {
            System.out.println("=========== następnym razem wygrasz - przecież jesteś zwycięzcą ============");
            String[] images = convert(results);
            for(String image : images)
                System.out.print(image);
        }

        private String[] convert(int[] results) {
            String[] images = new String[results.length];
            for(int i=0; i<images.length; i++){
                images[i] = map(results[i]);
            }
            return images;
        }

        private String map(int result) {
            switch (result){
                case 0: return "| burak |";
                case 1: return "| śliwka |";
                case 2: return "| gruszka |";
                case 3: return "| ziemniak |";
                default: return "| zonk |";
            }
        }

}
