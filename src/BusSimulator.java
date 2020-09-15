public class BusSimulator extends Simulator {

    public BusSimulator(Environment environment, long mean) {
        super(environment, mean);
    }

    @Override
    public void run() {
        while (!this.stop){
            try {
                long min_wait = (long)-Math.log(1-Math.random()) * this.mean;
                Thread.sleep(min_wait);
                Bus bus = new Bus(environment);
                environment.arrive(bus);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
