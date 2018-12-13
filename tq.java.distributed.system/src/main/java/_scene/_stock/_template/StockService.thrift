namespace java _scene._stock

service StockService {

i32 getStock(i32 sid)

bool reduceStock(i32 sid, i32 reduce)

bool setStock(i32 sid, i32 setNum)

bool setStockWithOld(i32 sid, i32 setNum, i32 oldNum)

}
