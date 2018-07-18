package com.starlight.springboot.springbootredis;

import com.starlight.springboot.springbootredis.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate<Object,Object> redisTemplate;

	@Test
	public void contextLoads() {
		stringRedisTemplate.opsForValue().set("test","test");
		System.out.println(stringRedisTemplate.opsForValue().get("test"));
		redisTemplate.opsForValue().set("user",new User(11,"xghuang",12));

		User user = (User) redisTemplate.opsForValue().get("user");
		System.out.println(user);
	}

}
