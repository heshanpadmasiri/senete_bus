public class Environment {
    private long busMinTime;
    private long riderMinTime;
    private BusSimulator busSimulator;
    private RiderSimulator riderSimulator;

    public Environment(long busMinTime, long riderMinTime) {
        this.busMinTime = busMinTime;
        this.riderMinTime = riderMinTime;
        busSimulator = new BusSimulator(this,busMinTime);
        riderSimulator = new RiderSimulator(this, riderMinTime);
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
