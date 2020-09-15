public class Main {
    public static void main(String[] args) {
        Environment environment = new Environment(50,1);
        try {
            environment.startSimulation(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
