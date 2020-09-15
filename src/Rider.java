public class Rider implements Entity{
    private Environment environment;
    private static int lastId=-1;
    private int id;

    public Rider(Environment environment) {
        this.environment = environment;
        this.id = lastId+1;
        lastId++;
    }

    @Override
    public void run() {
        System.out.format("Rider id%d arrived\n",id);
    }
}
