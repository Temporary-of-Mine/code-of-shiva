package cn.demo.shiva.mpdbs.service;

import cn.demo.shiva.mpdbs.mapper.MasterMapper;
import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shiva   2021/8/11 22:50
 */
@Service
public class DbChangeService {
    @Autowired
    private MasterMapper masterMapper;

    public String getUsername(String id) {
        //手动切换数据库
        DynamicDataSourceContextHolder.push("slave_1");
        //DynamicDataSourceContextHolder.push("slave");
        return masterMapper.getUsernameById(id);
    }

}
