package com.hry.mock.third.impl;

import com.hry.mock.dto.RemoteReq;
import com.hry.mock.dto.RemoteRsp;
import com.hry.mock.third.IRemoteApi;
import org.springframework.stereotype.Service;

/**
 * 实际调用第三方接口的实现
 * @author: huangrongyou@yixin.im
 * @date: 2019/10/8 19:31
 */
@Service
public class ActualRemoteApiImpl implements IRemoteApi {
    @Override
    public RemoteRsp request(RemoteReq req) {
        System.out.println("调用实际执行类" + req.getId()+ " ");
        return new RemoteRsp(200, "调用实际执行类");
    }
}
