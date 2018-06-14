package _source_analysis;


import java.util.List;

/**
 * @author 734070824@qq.com
 * @date 2018/6/14 14:46
 */
public interface MailDao {

    /**
     * 插入一条邮箱信息
     */
    public long insertMail(Mail mail);

    /**
     * 删除一条邮箱信息
     */
    public int deleteMail(long id);

    /**
     * 更新一条邮箱信息
     */
    public int updateMail(Mail mail);

    /**
     * 查询邮箱列表
     */
    public List<Mail> selectMailList();

    /**
     * 根据主键id查询一条邮箱信息
     */
    public Mail selectMailById(long id);

}