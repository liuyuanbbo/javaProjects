package org.jcz.wiki.common;

public final class CodeMsg {

    //通用响应
    public static CodeMsg OK = new CodeMsg(200, "OK");
    public static CodeMsg FAIL = new CodeMsg(500, "ERROR");

    private Integer code;
    private String msg;

    public CodeMsg(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}