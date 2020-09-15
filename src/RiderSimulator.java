public class RiderSimulator  extends  Simulator{
    public RiderSimulator(Environment environment, long min_wait) {
        super(environment, min_wait);
    }

    @Override
    public void run() {
        while (!this.stop){
            try {
                Thread.sleep(this.min_wait);
                Rider rider = new Rider(this.environment);
                System.out.format("Rider %d created \n",rider.getId());
                environment.arrive(rider);
            } catch (InterruptedException e) {
                break;
            }
        }

    }
}
