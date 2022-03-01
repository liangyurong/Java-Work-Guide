
 select 
   (   
     sysdate - to_date('2022-02-01 10:00:00 ','yyyy-mm-dd hh24:mi:ss')
   ) 
 from dual
