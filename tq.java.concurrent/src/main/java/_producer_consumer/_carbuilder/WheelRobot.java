package _producer_consumer._carbuilder;

/**
 * 轮子制造机器人
 * @author 734070824@qq.com
 * @date 2018/3/10 10:45
 */
public class WheelRobot extends Robot{

    public WheelRobot(RobotPool pool) {
        super(pool);
    }

    @Override
    public void performService() {
        System.out.println(this + " installing Wheels");
        assembler.car().addWheels();
    }
}
