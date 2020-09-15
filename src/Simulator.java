public abstract class Simulator extends Thread {
    protected Environment environment;
    protected long min_wait;
    protected boolean stop=false;

    public Simulator(Environment environment, long min_wait) {
        this.environment = environment;
        this.min_wait = min_wait;
    }

    public void end(){
        this.stop = true;
    }

}
