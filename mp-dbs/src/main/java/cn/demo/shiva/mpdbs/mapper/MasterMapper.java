package cn.demo.shiva.mpdbs.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface MasterMapper {

    @Select("SELECT username FROM sys_user where id = #{id}")
    String getUsernameById(String id);

    @Update("UPDATE sys_user SET remarks = '123' where id = #{id}")
    void updateRemarksById(String id);

}
