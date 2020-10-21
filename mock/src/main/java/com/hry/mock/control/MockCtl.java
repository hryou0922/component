package com.hry.mock.control;

import com.hry.mock.dto.MockDto;
import com.hry.mock.model.UserModel;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.ArrayList;
import java.util.List;

/**
 * api
 * @author: huangrongyou@yixin.im
 * @date: 2019/10/8 19:21
 */
@RestController
@RequestMapping(value = "/mock")
public class MockCtl {

    /**
     * 查询列表
     * @return
     */
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public List<MockDto> queryList(){
        List<MockDto> mockDtoList = new ArrayList<>(8);
        mockDtoList.add(new MockDto(1, "张一"));
        return mockDtoList;
    }


    @RequestMapping(value = "queryById", method = RequestMethod.GET)
    public DeferredResult<MockDto> queryById(String id){
        System.out.println("id = " + id);
        DeferredResult<MockDto> result = new DeferredResult<>();
        result.setResult(new MockDto());
        return result;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public int add(@RequestBody UserModel userModel){
        System.out.println("add userModel = " + userModel.toString());
        return 1;
    }

}
