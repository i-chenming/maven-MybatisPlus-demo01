package cn.kgc.injection;

import com.baomidou.mybatisplus.entity.TableInfo;
import com.baomidou.mybatisplus.mapper.AutoSqlInjector;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;

public class MySqlInjection extends AutoSqlInjector {

    @Override
    public void inject(Configuration configuration, MapperBuilderAssistant builderAssistant,
                       Class<?> mapperClass, Class<?> modelClass, TableInfo table) {

        //将DeptMapper 中的deleteAll 处理成对应的MappedStatement对象加入到Configuration中
        String sql = "delete from " + table.getTableName();

        //注入的方法名一定要与DeptMapper接口中的方法名一致
        String method = "deleteAll";

        //构造 SQLSource 对象
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);

        //构造一个删除的mappedStatement对象
        this.addDeleteMappedStatement(mapperClass, method, sqlSource);
    }
}
