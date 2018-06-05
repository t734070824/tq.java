/**
 * @auther: wangzs@ct108.com
 * @createDate 17-7-31
 * @updateDate 17-7-31
 */

package _gson;

/**
 * 警报信息
 */
public class AlertInfo {
    private String to;
    private String content;

    /**
     * 获取警报对象
     * @return
     */
    public String getTo() {
        return to;
    }

    /**
     * 设置警报对象
     * @param to 警报对象
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * 获取警报内容
     * @return
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置警报内容
     * @param content 警报内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}
