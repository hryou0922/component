package com.hry.mock.third;

import com.hry.mock.dto.RemoteReq;
import com.hry.mock.dto.RemoteRsp;

/**
 * 第三方接口测试
 * @author: huangrongyou@yixin.im
 * @date: 2019/10/8 19:28
 */
public interface IRemoteApi {
    /**
     * 请求第三方接口
     * @param req
     * @return
     */
    RemoteRsp request(RemoteReq req);
}
