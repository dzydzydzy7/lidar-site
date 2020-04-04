package com.dzy;

import com.dzy.pojo.User;
import com.dzy.utils.ProgramUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class LidarLabApplicationTests {

    @Autowired
    @Qualifier("myRedisTemplate")
    private RedisTemplate redisTemplate;
    @Autowired
    private ProgramUtils folderUtils;

    @Test
    void contextLoads() {
        //redisTemplate.opsForValue().set("k1", "v1");
        System.out.println(redisTemplate.opsForValue().get("k1"));

        //User user = new User("董泽宇", "123456");
        //redisTemplate.opsForValue().set("k2", user);
        System.out.println(redisTemplate.opsForValue().get("k2"));

        //redisTemplate.opsForValue().set("pic1", "1.PNG");
        System.out.println(redisTemplate.opsForValue().get("pic1"));

        //redisTemplate.opsForValue().set("k1", "v1 v2\n下一段");
        System.out.println(redisTemplate.opsForValue().get("k1"));

        System.out.println(folderUtils.getPicFolder());
    }

}
