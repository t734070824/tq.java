package _ioc._2_bean_factory._annotation;

import org.springframework.stereotype.Component;

@Component
public class DowJonesNewsListener implements IFXNewsListener {

    public DowJonesNewsListener() {
        System.err.println("DowJonesNewsListener");
    }
}
