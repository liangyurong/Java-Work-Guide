## Field 'id' doesn't have a default value

原因：mysql中没有设置id自动递增

备注: 即使在java字段中设置了自增，但是mysql中也是要设置的
```jshelllanguage
	@TableId(type=IdType.AUTO)
	private Long id;
```
