namespace java _containertype

service DemoService {
    /**
    * 验证权限
    **/
    bool authorization(
    1:list<map<string,string>> authkey,
    )
}
