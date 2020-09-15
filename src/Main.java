

public class Main {
    public static void main(String[] args) {
        Environment environment;
        if (args.length != 0) {
            long busMeanTime = Long.parseLong(args[0]) * 60 * 1000;
            long riderMeanTime = Long.parseLong(args[1]) * 1000;
            environment = new Environment(busMeanTime, riderMeanTime);
        } else {
            environment = new Environment(20 * 60, 30);
        }
        try {
            environment.startSimulation(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
