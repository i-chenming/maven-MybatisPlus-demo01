package cn.kgc.test;

import cn.kgc.entity.Dept;
import cn.kgc.mapper.DeptMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestMybatisPlus {

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

//    @Autowired
//    private DeptMapper deptMapper;

    @Test
    public void testSelectList(){

        DeptMapper deptMapper = applicationContext.getBean(DeptMapper.class);

        List<Dept> depts = deptMapper.selectList(new EntityWrapper<Dept>().eq("deptno", 2));

        System.out.println(depts);

    }

    @Test
    public void testSelectPage(){

        DeptMapper deptMapper = applicationContext.getBean(DeptMapper.class);

        List<Dept> depts = deptMapper.selectPage(new Page<Dept>(1, 2), new EntityWrapper<Dept>().between("deptno", 1, 5));

        System.out.println(depts);

    }

    @Test
    public void testSelectPage2(){

        DeptMapper deptMapper = applicationContext.getBean(DeptMapper.class);

        Page<Dept> page = new Page<Dept>(1,2);

        List<Dept> depts = deptMapper.selectPage(page, new EntityWrapper<Dept>().between("deptno", 1, 5));

        System.out.println(depts);

        System.out.println("--------获取分页信息---------");
        System.out.println("总条数--->" + page.getTotal());
        System.out.println("当前页--->" + page.getCurrent());
        System.out.println("总页码--->" + page.getPages());
        System.out.println("每页数--->" + page.getSize());
        System.out.println("是否有上页--->" + page.hasPrevious());
        System.out.println("是否有下页--->" + page.hasNext());
    }

    @Test
    public void testDelete(){

        DeptMapper deptMapper = applicationContext.getBean(DeptMapper.class);

        Integer num = deptMapper.delete(new EntityWrapper<Dept>().eq("deptno", 7));

        System.out.println(num);
    }

    @Test       //SQL 自定义注入器
    public void testDeleteAll(){

        DeptMapper deptMapper = applicationContext.getBean(DeptMapper.class);

        deptMapper.deleteAll();
    }

}
