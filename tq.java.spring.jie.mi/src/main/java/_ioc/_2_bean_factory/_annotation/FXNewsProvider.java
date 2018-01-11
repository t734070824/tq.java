package _ioc._2_bean_factory._annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("FXNewsProvider")
public class FXNewsProvider {

    @Autowired
    private IFXNewsListener listener;

    @Autowired
    private IFXNewsPersister persister;


    public FXNewsProvider() {
        System.err.println("FXNewsProvider");
    }

    public IFXNewsListener getListener() {
        return listener;
    }

    public IFXNewsPersister getPersister() {
        return persister;
    }

}
