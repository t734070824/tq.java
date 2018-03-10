package _producer_consumer._carbuilder;

/**
 * 动力系统制造机器人
 * @author 734070824@qq.com
 * @date 2018/3/10 10:43
 */
public class DriveTrainRobot extends  Robot{


    public DriveTrainRobot(RobotPool pool) {
        super(pool);
    }

    @Override
    public void performService() {
        System.out.println(this + " install DriveTrain");
        assembler.car().addDriveTrain();
    }
}
