package cn.demo.shiva.mpdbs.service;

import cn.demo.shiva.mpdbs.mapper.MasterMapper;
import cn.demo.shiva.mpdbs.mapper.SlaveMapper;
import com.baomidou.dynamic.datasource.annotation.DS;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author shiva   2021/8/11 23:21
 */
@Service
public class TranscaService {
    @Autowired
    private MasterMapper masterMapper;
    @Autowired
    private SlaveMapper slaveMapper;

    @DS("master")
    @Transactional
    //重点 第一个开启事务的需要添加seata全局事务注解
    @GlobalTransactional
    public void editAllDbs(){
        masterTrans();
        slaveTrans();
    }

    @DS("master")
    //事务传播特性设置为 REQUIRES_NEW 开启新的事务  重要！！！！一定要使用REQUIRES_NEW
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void masterTrans(){
        masterMapper.updateRemarksById("1");
    }

    @DS("slave")
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void slaveTrans(){
        slaveMapper.updateRemarksById("10000");
    }

}
