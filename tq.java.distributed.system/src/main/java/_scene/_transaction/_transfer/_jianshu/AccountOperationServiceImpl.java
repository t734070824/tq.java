package _scene._transaction._transfer._jianshu;

/**
 * @author 734070824@qq.com
 * @date 2018/12/14 16:31
 */
public class AccountOperationServiceImpl implements AccountOperationService{

    private TransferMoneyMapper transferMoneyMapper;

    @Override
    public Boolean identityCheck(long identityId) {
        return null;
    }

    @Override
    public Boolean decrease(TransferDTO transferDTO) throws Exception {
        //使用transactionId设为唯一约束，用来做幂等性
        try{
            transferMoneyMapper.saveRecord(transferDTO);
        } catch (Exception e){
            return true;//已经发送过
        }

        //查询剩余金额
        AccountDO accountInfo = transferMoneyMapper.getBalance(transferDTO.getPayAccountId());
        if (accountInfo.getAmount() > transferDTO.getAmount()) {
            throw new Exception("余额不足！");
        }

        //扣款(versionId + 1)
        transferMoneyMapper.decrease(transferDTO.getPayAccountId(), transferDTO.getAmount(), accountInfo.getVersionId());

        //扣款成功修改转账记录表状态值为1
        transferMoneyMapper.updateStatus(transferDTO.getTransactionId(), 0, 1);
        return false;
    }

    @Override
    public void increase(TransferDTO transferDTO) throws Exception {
        //付款
        transferMoneyMapper.increase(transferDTO.getRecAccountId(), transferDTO.getAmount());

        //更新状态为1的记录
        Integer count = transferMoneyMapper.updateStatus(transferDTO.getTransactionId(), 1, 2);
        if (count != 1){
            throw new Exception("付款失败！");
        }
    }
}
