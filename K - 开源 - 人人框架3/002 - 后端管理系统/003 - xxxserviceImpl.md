
## xxxserviceImpl


### 添加时间范围的查询

xxxserviceImpl代码

```jshelllanguage

    /**
    *  需要将字段进行查询，就添加进来。一般的字段用eq，时间字段用le，ge
    */
    @Override
    public QueryWrapper<VTestResultEntity> getWrapper(Map<String, Object> params){
        QueryWrapper<VTestResultEntity> wrapper = new QueryWrapper<>();

        // startDate是controller请求的参数
        if(MapUtils.valueIsNotEmpty(params,"startDate")) {
            wrapper.lambda().ge(VTestResultEntity::getReportDate, params.get("startDate"));
        }
        
        // endDate是controller请求的参数
        if(MapUtils.valueIsNotEmpty(params,"endDate")) {
            wrapper.lambda().le(VTestResultEntity::getReportDate, params.get("endDate"));
        }

        return wrapper;
    }
```

xxxController代码
```jshelllanguage
    @GetMapping("pageAndDate")
    @ApiOperation("分页和时间范围查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
            @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
            @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
            @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String"),
            @ApiImplicitParam(name = "startDate", value = "开始时间", paramType = "query", dataType="String"),
            @ApiImplicitParam(name = "endDate", value = "结束时间", paramType = "query", dataType="String")

    })
    //@RequiresPermissions("aiyimei:vtestresult:page")
    public Result<PageData<VTestResultDTO>> page1(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<VTestResultDTO> page = vTestResultService.page(params);

        return new Result<PageData<VTestResultDTO>>().ok(page);
    }
```


### 一开始生成的代码

```jshelllanguage
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.renren.common.page.PageData;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.commons.dynamic.datasource.annotation.DataSource;
import io.renren.modules.aiyimei.dao.VPatientDao;
import io.renren.modules.aiyimei.dto.VPatientDTO;
import io.renren.modules.aiyimei.entity.VPatientEntity;
import io.renren.modules.aiyimei.service.VPatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@DataSource("slave1")
@Slf4j
@Service
public class VPatientServiceImpl extends CrudServiceImpl<VPatientDao, VPatientEntity, VPatientDTO> implements VPatientService {

    @Autowired
    private VPatientDao vPatientDao;

    @Override
    public PageData<VPatientDTO> page(Map<String, Object> params){
        IPage<VPatientEntity> page = baseDao.selectPage(
                getPage(params, null, false),
                getWrapper(params)
        );

        return getPageData(page, currentDtoClass());
    }

    /** 如果要添加一些时间查询，则需要更改这个方法 */
    @Override
    public QueryWrapper<VPatientEntity> getWrapper(Map<String, Object> params){
        QueryWrapper<VPatientEntity> wrapper = new QueryWrapper<>();
        return wrapper;
    }

}
```
