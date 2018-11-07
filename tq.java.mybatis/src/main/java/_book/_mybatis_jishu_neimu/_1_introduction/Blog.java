package _book._mybatis_jishu_neimu._1_introduction;

import java.util.List;

/**
 * @author 734070824@qq.com
 * @date 2018/11/7 9:55
 */
public class Blog {

    private int id;
    private String title ;
    private Author author ;
    private List<Post> posts ;


    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", posts=" + posts +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
