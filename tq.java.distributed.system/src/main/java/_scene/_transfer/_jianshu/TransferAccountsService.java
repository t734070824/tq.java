package _scene._transfer._jianshu;

/**
 * @author 734070824@qq.com
 * @date 2018/12/14 16:24
 */
public interface TransferAccountsService {

    /**
     * 转账
     * @param transferDTO 转账DTO
     * @return success是否成功,message提示信息
     */
    Result transferAccounts(TransferDTO transferDTO);
}
