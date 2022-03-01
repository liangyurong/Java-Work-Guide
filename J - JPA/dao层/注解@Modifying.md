## @Modifying

select，insert操作不需要加上注解@Modifying

update方法的返回值应该是 int，表示更新语句所影响的行数

### 只要加了@Modifying就应该加上@Transactional，反过来不成立

dao层的update,delete操作，都要加上该注解@Modifying和@Transactional

```java
	@Transactional(rollbackFor = Exception.class)
	@Modifying
	@Query("delete from ExperimentAuthority ea where ea.userId = ?1")
	void untyingExperiment(String userId);
```






