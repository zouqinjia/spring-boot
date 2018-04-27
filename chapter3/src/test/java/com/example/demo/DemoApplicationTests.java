package com.example.demo;

import com.example.demo.service.AsyncService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private AsyncService asyncService;


	@Test
	public void contextLoads() {

		for (int i = 0;i<10;i++){
//			asyncService.asyncMethod(i);
			asyncService.asyncMethod2(i);
		}

	}

}
