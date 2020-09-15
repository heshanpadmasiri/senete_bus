import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Environment {
    private long busMeanTime;
    private long riderMeanTime;
    private BusSimulator busSimulator;
    private RiderSimulator riderSimulator;
    private Bus currentBus;
    public Queue<Rider> waitingQueue;
    public Semaphore waitingMutux;
    public Semaphore busSemaphore;
    public Semaphore boardedSemaphore;

    public Environment(long busMeanTime, long riderMeanTime) {
        this.busMeanTime = busMeanTime;
        this.riderMeanTime = riderMeanTime;
        busSimulator = new BusSimulator(this,busMeanTime);
        riderSimulator = new RiderSimulator(this, riderMeanTime);
        waitingQueue = new LinkedList<>();
        waitingMutux = new Semaphore(1);
        busSemaphore = new Semaphore(0);
        boardedSemaphore = new Semaphore(0);
    }

    public void arrive(Entity entity){
        entity.start();
    }

    public void setCurrentBus(Bus bus){
        this.currentBus = bus;
    }

    public Bus getCurrentBus(){return currentBus;}

    public void startSimulation(){
        busSimulator.start();
        riderSimulator.start();
    }
}
