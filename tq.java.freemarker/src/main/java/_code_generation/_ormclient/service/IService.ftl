package client.service;

import dc.orm.client.libmodel.model.${project_name}.${libmodel_name}; 
import org.apache.thrift.TException;

import java.io.Closeable;
import java.util.List;

/**
 * ${annotation}
 * @auther ${email}
 * @createDate ${date?string("yyyy-MM-dd")}
 */
public interface I${service_name}Service extends Closeable {

    /**
     *  批量插入
     * @param many
     * @throws TException
     */
    public void insertMany(List<${libmodel_name}> many) throws TException;

    /**
     * 获取单个信息
     * @param one
     * @return
     * @throws TException
     */
    public ${libmodel_name} getOne(${libmodel_name} one) throws TException;

    /**
     * 更新单个
     * @param one
     * @throws TException
     */
    public void updateOne(${libmodel_name} one) throws TException;


    /**
     * 批量更新
     * @param updateMany
     * @throws TException
     */
    public void updateMany(List<${libmodel_name}> updateMany) throws TException;
}
