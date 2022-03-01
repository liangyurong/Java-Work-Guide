## 步骤

1、配置分页插件

2、直接使用Page对象即可


### 2、直接使用Page对象即可

```jshelllanguage

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sdyb.aiyimei.entity.VPatient;
import com.sdyb.aiyimei.mapper.VPatientMapper;
import com.sdyb.aiyimei.service.VPatientService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  
 */
@Service
public class VPatientServiceImpl extends ServiceImpl<VPatientMapper, VPatient> implements VPatientService {

    @Autowired
    private VPatientMapper vPatientMapper;

    /**
     * 分页查询
     * @param pageNo 第几页
     * @param pageSize 每页的记录数量
     * @return 结果
     */
    @Override
    public IPage<VPatient> findByPage(int pageNo,int pageSize){

        Page<VPatient> page = new Page<>(pageNo,pageSize);

        return  vPatientMapper.selectPage(page, null);
    }


}

```

