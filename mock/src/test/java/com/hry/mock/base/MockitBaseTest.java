package com.hry.mock.base;

import com.hry.mock.MockApplication;
import com.hry.mock.mapper.UserMapper;
import com.hry.mock.model.UserModel;
import com.hry.mock.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Mockit 基础功能测试
 * @author: huangrongyou@yixin.im
 * @date: 2020/10/21 13:51
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockApplication.class)
public class MockitBaseTest {
    @Autowired
    private IUserService userService;

    @Test
    public void testWhenThenReturn(){
        UserMapper userMapper = mock(UserMapper.class);
        // 使用when后，后面必须根据执行结果方法如：thenReturn、thenThrow、someVoidMethod

        // 传入特定的参数返回指定的值：每次
        when(userMapper.selectById("id")).thenReturn(new UserModel());
        System.out.println(userMapper.selectById("id"));
        System.out.println(userMapper.selectById("id"));

        // 传入特定的参数返回指定的值：循环返回列表中的值
        when(userMapper.selectById("id")).thenReturn(new UserModel(), new UserModel());
        System.out.println(userMapper.selectById("id"));
        System.out.println(userMapper.selectById("id"));
        System.out.println(userMapper.selectById("id"));

        // 自定义返回的结果
        when(userMapper.selectById("id2")).thenAnswer(new Answer<UserModel>() {
            @Override
            public UserModel answer(InvocationOnMock invocation) throws Throwable {
                System.out.println((String) invocation.getArgument(0));
                // 获取传入方法的参数列表，通过invocation还可以获取method
                // Object id = invocation.getArguments()[0];
                String id = invocation.getArgument(0);
                UserModel userModel = new UserModel();
                userModel.setId(id);
                return userModel;
            }
        });
        System.out.println(userMapper.selectById("id2"));

        // 定义传入任何值，返回相同对象：除了any外，还有 anyString(), anyInt, anyDouble,  ..
        // --> 结合自定义返回结果，可以根据用户传入的参数返回不同的结果
        when(userMapper.selectById(anyString())).thenReturn(new UserModel());
        System.out.println(userMapper.selectById("id4"));
        System.out.println(userMapper.selectById("id5"));

        // 配置不同的参数返回不同的值
        when(userMapper.selectById("id6")).thenReturn(new UserModel("id6"));
        when(userMapper.selectById("id7")).thenReturn(new UserModel("id7"));
        System.out.println(userMapper.selectById("id6"));
        System.out.println(userMapper.selectById("id7"));

        // 输入特定值，抛出异常
        when(userMapper.selectById("xxxx")).thenThrow(new IllegalArgumentException());
     //   System.out.println(userMapper.selectById("xxxx"));


        // 传入的参数指定为某个类型class
        when(userMapper.add(any(UserModel.class))).thenReturn(1);
        System.out.println(userMapper.add(new UserModel("id7")));

    }

    
    @Test
    public void spy2(){
        // spy() 方法来包装一个真实的对象. 除非有特殊的指定,否则每次调用都会委托给该对象.
        IUserService mockUserService = Mockito.spy(userService);
        // 未使用模拟方法替换时，会调用委托方法的方法执行操作
        mockUserService.add(new UserModel());
        // 这里如果使用when方法替换add方法时，会导致 mockUserService的委托对象真正执行一次 add 方法，所以这里必须使用doReturn
        when(mockUserService.add(any())).thenAnswer(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocation) throws Throwable {
                System.out.println("调用mock方法");
                return 0;
            }
        });

        // spy:  类似使用doReturn-when可以避免when-thenReturn调用真实对象api
//        doAnswer(new Answer<Integer>() {
//            @Override
//            public Integer answer(InvocationOnMock invocation) throws Throwable {
//                System.out.println("调用mock方法");
//                return 0;
//            }
//        }).when(mockUserService).add(any());

        // 通过spy注入mock对象到方法后，调用会调用mock对象到方法
        mockUserService.add(new UserModel());
    }


    @Test
    public void verify2(){
        UserMapper userMapper = mock(UserMapper.class);
        // 使用mock对象执行操作
        userMapper.selectById("1");
        userMapper.selectById("2");
        userMapper.selectById("2");
        userMapper.selectById("2");
        userMapper.selectById("4");

        // 验证是否调用过一次 userMapper.selectById("1")方法，如没有（0次或者大于一次），测试将不通过
        verify(userMapper).selectById("1");
        // 这个方法和上面一行的代码等价
        verify(userMapper,times(1)).selectById("1");
        // 执行以下方法时会报错：因为 userMapper.selectById("6") 没有被执行过
        // verify(userMapper).selectById("6");

        // 验证调用过3次 userMapper.selectById("3")方法，若不是，测试将不通过
        verify(userMapper, times(3)).selectById("2");

        // 调用次数：从未调用过. never()是times(0)的别名
        verify(userMapper, never()).selectById("9");

        // 调用次数：最少调用n次
        verify(userMapper, atLeast(1)).selectById("1");
        verify(userMapper, atLeastOnce()).selectById("1");

        // 调用次数：最多调用n次
        verify(userMapper, atMost(2)).selectById("1");

        // 调查次数：此方法总的调用次数最多不大于，包括任何参数
        verify(userMapper, atMost(9)).selectById(anyString());
    }

    @Test
    public void reflectionTestUtils(){

        // 初始化时，userService 使用的真实的 UserMapper 实例
        System.out.println(userService.selectById("1"));

        // 使用 ReflectionTestUtils 将mock出来的实例注入到成员中，替换已有的值
        UserMapper mockUserMapper = mock(UserMapper.class);
        when(mockUserMapper.selectById("1")).thenReturn(new UserModel("1"));
        ReflectionTestUtils.setField(userService, "userMapper", mockUserMapper);
        System.out.println(userService.selectById("1"));
    }

}
