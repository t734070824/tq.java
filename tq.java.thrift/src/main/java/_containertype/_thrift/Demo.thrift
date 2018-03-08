namespace java _containertype

struct Parameter{
    1: required i32 id;
    2: required string name;
}

service DemoService {

i32 demoMethod(1:string param1, 2:Parameter param2, 3:map<string,string> param3);
    
}
