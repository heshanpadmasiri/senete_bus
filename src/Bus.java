public class Bus implements Entity{
    private Environment environment;
    private static int lastId=-1;
    private int id;

    public Bus(Environment environment) {
        this.environment = environment;
        this.id = lastId+1;
        lastId++;
    }

    @Override
    public void run() {
        System.out.format("Bus id%d arrived\n",id);
    }
}
