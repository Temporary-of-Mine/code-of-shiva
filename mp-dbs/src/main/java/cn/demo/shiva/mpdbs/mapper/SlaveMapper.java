package cn.demo.shiva.mpdbs.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

/**
 * @author shiva   2021/8/10 21:44
 */
@Mapper
@Component
@DS("slave_1")
public interface SlaveMapper {

    @Select("SELECT name FROM sys_area where id = #{id}")
    String getNameById(String id);

    @Update("UPDATE sys_area SET remarks = '123' where id = #{id}")
    void updateRemarksById(String id);
}
