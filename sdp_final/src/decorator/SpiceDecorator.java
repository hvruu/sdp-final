package decorator;

class SpiceDecorator implements Food {
    protected Food food;

    public SpiceDecorator(Food food) {
        this.food = food;
    }

    public String getDescription() {
        return food.getDescription();
    }

    @Override
    public double prepareTime() {
        return food.prepareTime();
    }
}