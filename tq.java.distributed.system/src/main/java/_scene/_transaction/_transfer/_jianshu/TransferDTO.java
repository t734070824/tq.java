package _scene._transaction._transfer._jianshu;

/**
 * @author 734070824@qq.com
 * @date 2018/12/14 16:25
 */
public class TransferDTO {
    private long identityId;
    private String payAccountId;
    private long amount;
    private String transactionId;
    private String recAccountId;

    public long getIdentityId() {
        return identityId;
    }

    public void setIdentityId(long identityId) {
        this.identityId = identityId;
    }

    public String getPayAccountId() {
        return payAccountId;
    }

    public void setPayAccountId(String payAccountId) {
        this.payAccountId = payAccountId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getRecAccountId() {
        return recAccountId;
    }

    public void setRecAccountId(String recAccountId) {
        this.recAccountId = recAccountId;
    }
}
