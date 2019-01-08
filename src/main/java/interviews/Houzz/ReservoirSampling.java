package interviews.Houzz;

public class ReservoirSampling {
    private int counter = 0;
    private int[] reservoir;

    ReservoirSampling(int k) {
        reservoir = new int[k];
    }

    public int[] getKElements(int num) {
        counter++;
        if (counter <= reservoir.length) {
            reservoir[counter - 1] = num;
            return reservoir;
        }
        int random = (int) (Math.random() * counter);
        if (random < reservoir.length) {
            reservoir[random] = num;
        }
        return reservoir;
    }

}

