package com.example.demo;

import com.example.demo.repository.PO.Duck;
import com.example.demo.repository.PO.Role;
import com.example.demo.service.DuckService;
import com.example.demo.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringDataApplicationTests {

	@Autowired
	private DuckService duckService;

	@Autowired
	private RoleService roleService;

	@Test
	@Rollback(false)
	public void contextLoads() {

		Duck duck = duckService.findById(1);
		System.out.println(duck);
		Duck duck1 = new Duck();
		duck1.setId(9);
		duck1.setColor("绿色");
		duck1.setType("机器");
		duck1 = duckService.save(duck1);
		System.out.println(duck1);


	}

	@Test
	@Rollback(false)
	public void roleTest() {

		Role role = new Role();
		role.setName("aa");
		role.setId(3333);
		role.setUserId(222);
		roleService.save(role);
	}

}
