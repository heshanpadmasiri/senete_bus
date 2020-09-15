public abstract class Simulator extends Thread {
    protected Environment environment;
    protected long mean;
    protected boolean stop=false;

    public Simulator(Environment environment, long mean) {
        this.environment = environment;
        this.mean = mean;
    }

    public void end(){
        this.stop = true;
    }

}
