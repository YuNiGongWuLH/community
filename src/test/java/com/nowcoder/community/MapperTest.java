package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import com.nowcoder.community.service.DiscussPostService;
import com.nowcoder.community.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testSelectUser(){
        User user = userMapper.selectById(1);
        System.out.println(user);
    }
    @Test
    public void testSelectUserByName(){
        User user = userMapper.selectByName("liubei");
        System.out.println(user);
    }
    @Test
    public void testSelectUserByEmail(){
        User user = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);
    }
    @Test
    public void testInsertUser(){
        User user = new User();
        user.setEmail("test@qq.com");
        user.setUsername("test");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());
        int i = userMapper.insertUser(user);
        System.out.println(i);
    }
    @Test
    public void testUpdateStatus(){
        int i = userMapper.updateStatus(150, 1);
        System.out.println(i);
        int i1 = userMapper.updateHeader(150, "http://www.nowcoder.com/102.png");
        System.out.println(i1);
        int abcde = userMapper.updatePassword(1, "abcde");
        System.out.println(abcde);

    }
    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Test
    public void testSelectDiscussPosts(){
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts
                (149, 0, 20);
        for (DiscussPost discussPost : discussPosts) {
            System.out.println(discussPost);
        }
    }
    @Test
    public void testSelectDiscussPostRows(){
        int rows = discussPostMapper.selectDiscussPostRows(149);
        System.out.println(rows);
    }
    @Autowired
    private DiscussPostService discussPostService;
    @Test
    public void testSelectDiscussPostsImpl(){
        List<DiscussPost> list = discussPostService.findDiscussPosts(0, 0, 20);
        for (DiscussPost discussPost : list) {
            System.out.println(discussPost);
        }
    }
    @Test
    public void testSelectDiscussPostsRowsImpl(){
        int discussPostsRows = discussPostService.findDiscussPostsRows(0);
        System.out.println(discussPostsRows);
    }
    @Autowired
    private UserService userService;
    @Test
    public void findUserById(){
        User user = userService.findUserById(1);
        System.out.println(user);
    }
}
