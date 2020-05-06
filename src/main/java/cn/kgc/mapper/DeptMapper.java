package cn.kgc.mapper;

import cn.kgc.entity.Dept;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

//@Mapper
public interface DeptMapper extends BaseMapper<Dept> {

    //之前需要在xml中进行配置SQL语句，现在通过扩展AutoSqlInjector，在加载mybatis环境是就注入
    void deleteAll();
}
