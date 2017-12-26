package _ex06.core;

import org.apache.catalina.Lifecycle;
import org.apache.catalina.LifecycleEvent;
import org.apache.catalina.LifecycleListener;

public class SimpleContextLifecycleListener implements LifecycleListener{




    public void lifecycleEvent(LifecycleEvent event) {
        Lifecycle lifecycle = event.getLifecycle();
        System.err.println("SimpleContextLifecycleListener's event:"  + event.getType());

        if(Lifecycle.START_EVENT.equals(event.getType())){
            System.err.println("starting event");
        } else if(Lifecycle.STOP_EVENT.equals(event.getType())) {
            System.err.println("stoping event");
        }

    }
}
