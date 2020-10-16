package com.disapand.mall.handle;

import lombok.Getter;
import lombok.ToString;

/**
 * @author aoxiang-zhangqian
 */

@Getter
@ToString
public enum Status {

    /**
     * 成功
     */
    OK(0, "操作成功"),
    /**
     * 未找到
     */
    NOT_FOUND(10001, "资源未找到")
    ;

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 状态信息
     */
    private final String message;

    /**
     * 生成 enum
     *
     * @param code          状态码
     * @param message       状态码对应的提示文本
     */
    Status(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
