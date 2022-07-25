## 在BloodPressureServiceImpl中修改wrapper

```jshelllanguage
    @Override
    public QueryWrapper<BloodPressureEntity> getWrapper(Map<String, Object> params){
        QueryWrapper<BloodPressureEntity> wrapper = new QueryWrapper<>();

        // 添加判断条件
        if (MapUtils.valueIsNotEmpty(params, "startDate")) {
            wrapper.lambda().ge(BloodPressureEntity::getRecordTime, params.get("startDate"));
        }

        // 添加判断条件
        if (MapUtils.valueIsNotEmpty(params, "endDate")) {
            wrapper.lambda().le(BloodPressureEntity::getRecordTime, params.get("endDate"));
        }

        return wrapper;
    }
```
