import java.lang.Math;

public class RiderSimulator  extends  Simulator{
    public RiderSimulator(Environment environment, long mean) {
        super(environment, mean);
    }

    @Override
    public void run() {
        while (!this.stop){
            try {
                long min_wait = (long)-Math.log(1-Math.random()) * this.mean;
                Thread.sleep(min_wait);
                Rider rider = new Rider(this.environment);
                environment.arrive(rider);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
