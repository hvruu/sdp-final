package Factory;

public class MaidServant implements Servant {
    @Override
    public void performTask() {
        System.out.println("call Maid to clean the house..");
        //сallMaid();
    }
}