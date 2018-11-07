package _book._mybatis_jishu_neimu._1_introduction;

/**
 * @author 734070824@qq.com
 * @date 2018/11/7 9:56
 */
public class Post {
    protected int id ;
    protected Author author;
    protected String content ;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", author=" + author +
                ", content='" + content + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
