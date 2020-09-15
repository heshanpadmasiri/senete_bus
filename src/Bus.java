import java.util.ArrayList;

public class Bus extends Entity {
    private final Environment environment;
    private static int lastId=-1;
    private final int id;
    private final ArrayList<Rider> riders;

    public Bus(Environment environment) {
        this.environment = environment;
        this.id = lastId+1;
        lastId++;
        riders = new ArrayList<>();
    }

    @Override
    public void run() {
        System.out.format("Bus %d arrived\n",id);
        try {
            this.environment.waitingMutux.acquire();
            this.environment.setCurrentBus(this);
            int boarded = 0;
            while (boarded < 50){
                Rider rider= environment.waitingQueue.poll();
                if(rider == null){
                    break;
                }
                this.environment.busSemaphore.release();
                this.environment.boardedSemaphore.acquire();
                boarded++;
            }
            this.environment.waitingMutux.release();
            depart();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void board(Rider rider){
        this.riders.add(rider);
    }

    private void depart(){
        if (riders.size() == 0){
            System.out.format("Bus %d departed without riders\n",id);
        } else {
            System.out.format("Bus %d departed with:\n",id);
            for (Rider rider:riders) {
                System.out.format("\t %d\n", rider.getEntityId());
            }
        }
    }

    @Override
    public int getEntityId() {
        return this.id;
    }
}
