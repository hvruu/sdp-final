package Factory;

public class GardenerServant implements Servant {
    @Override
    public void performTask() {
        System.out.println("Calling gardener to take care to garden..");
        //callGardener();
    }
}