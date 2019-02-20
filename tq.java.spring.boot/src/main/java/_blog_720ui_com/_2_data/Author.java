package _blog_720ui_com._2_data;

/**
 * @author 734070824@qq.com
 * @date 2019/2/20 16:04
 */
public class Author {
    private Long id;
    private String realName;
    private String nickName;
    // SET和GET方法


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
