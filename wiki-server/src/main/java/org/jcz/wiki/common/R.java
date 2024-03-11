package org.jcz.wiki.common;

public class R<T> {
    private Integer code;
    private String msg;
    private T data;

    public R() {
        this(CodeMsg.OK);
    }

    public R(CodeMsg cm) {
        this.code = cm.getCode();
        this.msg = cm.getMsg();
    }

    public R(CodeMsg cm, T data) {
        this(cm);
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> R<T> success() {
        return new R<>(CodeMsg.OK);
    }

    public static <T> R<T> success(T data) {
        return new R<>(CodeMsg.OK, data);
    }

    public static <T> R<T> fail() {
        return new R<>(CodeMsg.FAIL);
    }
}
