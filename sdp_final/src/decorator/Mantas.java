package decorator;

public class Mantas implements Food {
    private String description;
    private double time;

    public Mantas() {
        this.description = "mantas";
        this.time = 30;
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
