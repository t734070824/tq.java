package _finalize;


/**
 * 1.对象可以在被GC的时候自我拯救
 * 2.这种自救只会有一次,以为一个对象的finalize()方法只会被系统调用一次
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive(){
        System.err.println("still alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.err.println("finalize");
        SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        //对象第一次成功拯救自己
        SAVE_HOOK = null;

        System.gc();
        Thread.sleep(500);


        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        } else {
            System.err.println("dead");
        }


        //失败 finalize只会运行一次
        SAVE_HOOK = null;

        System.gc();
        Thread.sleep(500);


        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        } else {
            System.err.println("dead");
        }







    }
}
