## ifnull

SELECT IFNULL( NAME, 0 )  FROM buy;

    如果name为null，则显示0，否则显示原值

    等同：SELECT IF( NAME IS NOT NULL, NAME, 0 ) FROM buy;