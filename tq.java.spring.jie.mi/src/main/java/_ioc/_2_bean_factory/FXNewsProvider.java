package _ioc._2_bean_factory;

public class FXNewsProvider {

    private IFXNewsListener listener;

    private IFXNewsPersister persister;


    public FXNewsProvider(IFXNewsListener listener, IFXNewsPersister persister) {
        this.listener = listener;
        this.persister = persister;
    }
}
