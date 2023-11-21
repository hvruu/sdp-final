package Factory;

public class BabysitterServantFactory implements ServantFactory {
    @Override
    public Servant createServant() {
        return new BabysitterServant();
    }
}