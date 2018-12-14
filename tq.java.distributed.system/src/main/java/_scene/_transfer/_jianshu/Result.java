package _scene._transfer._jianshu;

/**
 * @author 734070824@qq.com
 * @date 2018/12/14 16:25
 */
public class Result {
    private boolean success;
    private String msg;

    public Result(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
