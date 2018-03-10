package _producer_consumer._carbuilder;

/**
 * 汽车
 * @author 734070824@qq.com
 * @date 2018/3/10 10:28
 */
public class Car {

    private final int id;
    private boolean engine = false, driveTrain = false, wheels = false;

    public Car(int id) {
        this.id = id;
    }

    public Car() {
        this.id = 1;
    }

    public synchronized int getId(){
        return  id;
    }

    public synchronized void addEngine(){
        engine = true;
    }

    public synchronized void addDriveTrain(){
        driveTrain = true;
    }

    public synchronized void addWheels(){
        wheels = true;
    }

    public synchronized String toString() {
        return "Car " + id + " [" + " engine: " + engine + " driveTrain: "
                + driveTrain + " wheels: " + wheels + " ]";
    }

}
