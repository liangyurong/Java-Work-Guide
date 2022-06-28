## inner join

INNER JOIN 关键字在表中存在至少一个匹配时返回行




sql尽量使用数据量小的表做主表，这样效率高，如果使用数据量大的表做主表，此时使用left join 就会比较慢，即使关联条件有索引。但如果使用inner join速度就较快。因为inner join 在执行的时候回自动选择最小的表做基础表，效率高，总之相比之下inner join不管从效率还是速度上都优于left join，毕竟left join 会多一部分逻辑运算

②选择inner join还有个好处，不会产生null,有些表我们在定义的时候某些字段不允许存在null,如果用left join就可能会产生null,此时软件就会报错，而inner join可以避免

③在实际运用中选择inner join还是left join这个需要根据实际场景进行选择，并不是所有的地方都能用inner join的，建议能用则用