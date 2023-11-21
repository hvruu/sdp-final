package Factory;

public class GardenerServantFactory implements ServantFactory {
    @Override
    public Servant createServant() {
        return new GardenerServant();
    }
}