package decorator;

public class Ketchup extends SpiceDecorator{

    public Ketchup(Food food) {
        super(food);
    }

    public String getDescription(){
        return food.getDescription() + ", with ketchup";
    }

    @Override
    public double prepareTime() {
        return food.prepareTime() + 0.3;
    }
}
