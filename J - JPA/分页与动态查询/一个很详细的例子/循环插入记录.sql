
-- 用于测试

drop procedure if exists insert_while; -- 如果存在函数insertwhile先删除它

delimiter // -- 将结束符定义为//在begin和end中会使用;如果不换程序会错误
create procedure insert_while() -- 创建存储过程
begin
  declare i int default 1;
    while i<=1000  -- 创建1000条记录
    do
  insert into people(id,name,my_email,address) values(concat('',i),concat('name',i),concat('my_email',i),concat('address',i));
  set i=i+1;
end while;
commit;
end //
delimiter ; -- 结束符换回;号

call insert_while(); -- 调用插入方法,否则无法插入
