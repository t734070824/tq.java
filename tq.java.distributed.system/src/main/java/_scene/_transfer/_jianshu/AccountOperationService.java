package _scene._transfer._jianshu;

/**
 * @author 734070824@qq.com
 * @date 2018/12/14 16:31
 */
public interface AccountOperationService {
    Boolean identityCheck(long identityId);

    Boolean decrease(TransferDTO transferDTO) throws Exception;

    void increase(TransferDTO transferDTO) throws Exception;
}
