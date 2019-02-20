package _blog_720ui_com._2_data;

import java.util.List;

/**
 * @author 734070824@qq.com
 * @date 2019/2/20 16:04
 */
public interface AuthorDao {
    int add(Author author);
    int update(Author author);
    int delete(Long id);
    Author findAuthor(Long id);
    List<Author> findAuthorList();
}