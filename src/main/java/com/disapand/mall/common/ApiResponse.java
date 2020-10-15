package com.disapand.mall.common;

import com.disapand.mall.handle.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author aoxiang-zhangqian
 */
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
     *
     * @param code          状态码
     * @param message       返回信息
     * @param data          返回的数据
     * @return ApiResponse
     */
    public static ApiResponse of (Integer code, String message, Object data) {
        return new ApiResponse(code, message, data);
    }

    /**
     * 构造一个没有数据的 API 返回
     *
     * @return ApiResponse
     */
    public static ApiResponse ofSuccess() {
        return ofStatus(Status.OK);
    }

    /**
     * 构造一个成功且带数据的 API 返回
     *
     * @param data          返回的数据
     * @return ApiResponse
     */
    public static ApiResponse ofSuccess(Object data) {
        return ofStatus(Status.OK, data);
    }

    /**
     * 构造一个成功且自定义消息的 API 返回
     *
     * @param message       自定义的消息
     * @return ApiResponse
     */
    public static ApiResponse ofSuccess(String message) {
        return of(Status.OK.getCode(), message, null);
    }

    /**
     * 构造一个成功且自定义消息，带数据返回的 API
     *
     * @param message       自定义的消息
     * @param data          返回的数据
     * @return ApiResponse
     */
    public static ApiResponse ofSuccess(String message, Object data) {
        return of(Status.OK.getCode(), message, data);
    }

    /**
     * 构造一个有状态的 API 返回
     * @param status        返回的状态
     * @return ApiResponse
     */
    public static ApiResponse ofStatus(Status status) {
        return ofStatus(status, null);
    }

    /**
     * 构造一个有状态且有数据的 API 返回
     *
     * @param status        返回的状态
     * @param data          返回的数据
     * @return ApiResponse
     */
    public static ApiResponse ofStatus(Status status, Object data) {
        return of(status.getCode(), status.getMessage(), data);
    }
}
