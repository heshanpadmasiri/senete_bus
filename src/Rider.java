public class Rider extends Entity {
    private Environment environment;
    private static int lastId=-1;
    private final int id;

    public Rider(Environment environment) {
        this.environment = environment;
        this.id = lastId+1;
        lastId++;
    }



    @Override
    public void run() {
        System.out.format("Rider %d arrived\n",id);
        try {
            this.environment.waitingMutux.acquire();
            this.environment.waitingQueue.add(this);
            this.environment.waitingMutux.release();

            this.environment.busSemaphore.acquire();
            // todo: board bus
            this.environment.boardedSemaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void boardBus(Bus bus) {
        System.out.format("Rider %d boarded bus %d\n", this.id, bus.getEntityId());
        bus.board(this);
    }

    @Override
    public int getEntityId() {
        return this.id;
    }
}
