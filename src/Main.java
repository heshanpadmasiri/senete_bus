public class Main {
    public static void main(String[] args) {
        Environment environment = new Environment(2,1);
        try {
            environment.startSimulation(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
