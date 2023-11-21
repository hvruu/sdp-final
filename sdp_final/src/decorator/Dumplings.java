package decorator;

public class Dumplings implements Food{
    private String description;
    private double time;
    public Dumplings(){
        this.description = "dumplings";
        this.time = 20;
    }
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double prepareTime() {
        return time;
    }
}
