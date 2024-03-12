package org.jcz.wiki.common;

public final class CodeMsg {

    //通用响应
    public static CodeMsg OK = new CodeMsg("000000", "OK");
    public static CodeMsg FAIL = new CodeMsg("999999", "ERROR");

    private String code;
    private String msg;

    public CodeMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}