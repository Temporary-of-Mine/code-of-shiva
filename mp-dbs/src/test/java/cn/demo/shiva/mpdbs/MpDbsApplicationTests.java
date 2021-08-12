package cn.demo.shiva.mpdbs;

import cn.demo.shiva.mpdbs.mapper.MasterMapper;
import cn.demo.shiva.mpdbs.mapper.SlaveMapper;
import cn.demo.shiva.mpdbs.service.DbChangeService;
import cn.demo.shiva.mpdbs.service.TranscaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MpDbsApplicationTests {

	@Autowired
	private MasterMapper masterMapper;
	@Autowired
	private SlaveMapper slaveMapper;
	@Autowired
	private DbChangeService dbChangeService;
	@Autowired
	private TranscaService transcaService;

	@Test
	void test1(){
		String username = masterMapper.getUsernameById("1");
		System.out.println(username);
		String name = slaveMapper.getNameById("100000");
		System.out.println(name);
	}

	@Test
	void test2(){
		String username = dbChangeService.getUsername("1");
		System.out.println(username);
	}

	@Test
	void test3(){
		transcaService.editAllDbs();
	}

}
