package com.disapand.mall.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {

    /**
     * 状态码
     */
    private  Integer code;

    /**
     * 返回的信息
     */
    private String message;

    /**
     * 返回的数据
     */
    private Object data;

    /**
     * 构造一个自定义的 API 返回
     * @param code          状态码
     * @param message       返回信息
     * @param data          返回的数据
     * @return ApiResponse
     */
    public static ApiResponse of (Integer code, String message, Object data) {
        return new ApiResponse(code, message, code);
    }

    /**
     * 构造一个成功且带数据的 API 返回
     * @param data
     * @return
     */
    public static ApiResponse ofSuccess(Object data) {
        return ofStatus(200, data);
    }

    private static ApiResponse ofStatus(int i, Object data) {
    }
}
