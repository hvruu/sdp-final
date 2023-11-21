package Factory;

public class MaidServantFactory implements ServantFactory {
    @Override
    public Servant createServant() {
        return new MaidServant();
    }
}