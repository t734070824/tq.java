package _ioc._2_bean_factory._annotation;

import org.springframework.stereotype.Component;

@Component
public class DowJonesNewsPersister implements IFXNewsPersister {

    public DowJonesNewsPersister() {
        System.err.println("DowJonesNewsPersister");
    }
}
