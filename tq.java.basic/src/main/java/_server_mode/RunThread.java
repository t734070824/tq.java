package _server_mode;

public class RunThread extends  Thread{

    private  boolean isRunning = true;


    @Override
    public void run() {

        System.err.println("running");
        while (isRunning){
//            System.err.println("AAAAAAAA");
        }
        System.err.println("end");
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}
