package decorator;

public class Mayonnaise extends SpiceDecorator{

    public Mayonnaise(Food food) {
        super(food);
    }

    public String getDescription(){
        return food.getDescription() + ", with mayonnaise";
    }

    @Override
    public double prepareTime() {
        return food.prepareTime() + 0.3;
    }
}
