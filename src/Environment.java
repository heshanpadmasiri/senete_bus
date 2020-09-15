import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Environment {
    private long busMinTime;
    private long riderMinTime;
    private BusSimulator busSimulator;
    private RiderSimulator riderSimulator;
    public Queue<Rider> waitingQueue;
    public Semaphore waitingMutux;
    public Semaphore busSemaphore;
    public Semaphore boardedSemaphore;

    public Environment(long busMinTime, long riderMinTime) {
        this.busMinTime = busMinTime;
        this.riderMinTime = riderMinTime;
        busSimulator = new BusSimulator(this,busMinTime);
        riderSimulator = new RiderSimulator(this, riderMinTime);
        waitingQueue = new LinkedList<>();
        waitingMutux = new Semaphore(1);
        busSemaphore = new Semaphore(0);
        boardedSemaphore = new Semaphore(0);
    }

    public void arrive(Entity entity){
        entity.run();
    }

    public void startSimulation(long time) throws InterruptedException {
        busSimulator.start();
        riderSimulator.start();

        Thread.sleep(time);
        busSimulator.end();
        riderSimulator.end();
    }
}
