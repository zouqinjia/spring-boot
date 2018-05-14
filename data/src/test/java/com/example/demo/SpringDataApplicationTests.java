package com.example.demo;

import com.example.demo.repository.PO.Duck;
import com.example.demo.repository.PO.Role;
import com.example.demo.service.DuckService;
import com.example.demo.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringDataApplicationTests {

	@Autowired
	private DuckService duckService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private RedisTemplate<Object,Object> redisTemplate;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

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

	@Test
	@Rollback(false)
	public void redisTest(){

		Duck duck = duckService.findById(1);
		redisTemplate.opsForValue().set(duck.getId(),duck);
		System.out.println(redisTemplate.hasKey(duck.getId()));

	}

	@Test
	@Rollback(false)
	public void redisList(){

		List<Duck> ducks = new ArrayList<>();
		Duck duck = duckService.findById(1);
		Duck duck2 = duckService.findById(2);

		ducks.add(duck);
		ducks.add(duck2);
		redisTemplate.opsForValue().set(duck.getId(),ducks);
		redisTemplate.opsForList().leftPush("3",duck2);
		System.out.println(redisTemplate.hasKey(duck.getId()));

	}

	@Test
	@Rollback(false)
	public void redisRemove(){

		Duck duck = duckService.findById(1);
		redisTemplate.delete(duck.getId());
		System.out.println(redisTemplate.hasKey(duck.getId()));

	}


}
