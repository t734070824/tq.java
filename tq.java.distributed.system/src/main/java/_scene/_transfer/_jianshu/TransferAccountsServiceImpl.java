package _scene._transfer._jianshu;

/**
 * @author 734070824@qq.com
 * @date 2018/12/14 16:25
 */
public class TransferAccountsServiceImpl implements TransferAccountsService{
//    @Autowired
    private AccountOperationService accountOperationService;

    @Override
    public Result transferAccounts(TransferDTO transferDTO) {
        try{
            //接口安全性校验(identityId为 加密信息)
            Boolean flag = accountOperationService.identityCheck(transferDTO.getIdentityId());
            if (!flag){
                //TODO 发送监控报警
                return new Result(false, "非法请求！");
            }

            //入参校验
//            if (StringUtils.isEmpty(transferDTO.getTransactionId()) ||
//                    StringUtils.isEmpty(transferDTO.getAmount()) ||
//                    StringUtils.isEmpty(transferDTO.getRecAccountId()) ||
//                    StringUtils.isEmpty(transferDTO.getPayAccountId())){
//                return new Result(false, "参数为空！");
//            }

            //减款
            try {
                //幂等性
                Boolean success = accountOperationService.decrease(transferDTO);
                if (success) {
                    return new Result(true, "转账成功！");
                }
            } catch (Exception e) {
                return new Result(false, e.getMessage());
            }

            //付款（根据状态1进行update）
            try{
                accountOperationService.increase(transferDTO);
            } catch (Exception e){
                //如果付款失败：启动一个高频定时任务来扫描状态为1的记录，并进行付款
                return new Result(true, "付款失败！");
            }
        } catch (Exception e) {
            return new Result(false, "转账失败！");
        }
        return new Result(true, "转账成功！");
    }

}
