package com.hry.mock.dto;

/**
 * 第三方请求返回
 * @author: huangrongyou@yixin.im
 * @date: 2019/10/8 19:29
 */
public class RemoteRsp {
    private int code;
    private String msg;

    public RemoteRsp() { }
    public RemoteRsp(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
