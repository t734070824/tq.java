package _2_ioc._2_ioc_concept;

public class FXNewsProvider {

    private IFXNewsListener listener;

    private IFXNewsPersister persister;


    public FXNewsProvider(IFXNewsListener listener, IFXNewsPersister persister) {
        this.listener = listener;
        this.persister = persister;
    }
}
