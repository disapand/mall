package com.disapand.mall.handle;

import lombok.Getter;

/**
 * @author aoxiang-zhangqian
 */

@Getter
public enum Status {

    /**
     * 成功
     */
    OK(200, "操作成功"),
    /**
     * 未找到
     */
    NOT_FOUND(404, "资源未找到")
    ;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态信息
     */
    private String message;

    Status(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
