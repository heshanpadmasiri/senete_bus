public class BusSimulator extends Simulator {

    public BusSimulator(Environment environment, long min_wait) {
        super(environment, min_wait);
    }

    @Override
    public void run() {
        while (!this.stop){
            try {
                Thread.sleep(this.min_wait);
                Bus bus = new Bus(environment);
                environment.arrive(bus);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
