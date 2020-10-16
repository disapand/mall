package com.disapand.mall.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.disapand.mall.common.ApiResponse;
import com.disapand.mall.entity.SmsCoupon;
import com.disapand.mall.handle.Status;
import com.disapand.mall.service.impl.SmsCouponServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 优惠卷表 前端控制器
 * </p>
 *
 * @author author
 * @since 2020-10-13
 */
@RestController
@RequestMapping("/sms-coupon")
@Api( value = "优惠券接口")
public class SmsCouponController {

    @Autowired
    private SmsCouponServiceImpl service;

    @ApiOperation(value = "根据 id 获取优惠券信息")
    @ApiImplicitParam(paramType = "param", name = "id", value = "优惠券id", required = true, dataType = "Integer")
    @GetMapping("/coupon/{id}")
    public ApiResponse getCoupon(@PathVariable Long id) {
        SmsCoupon coupon = service.getById(id);
        return StringUtils.isEmpty(coupon) ? ApiResponse.ofStatus(Status.NOT_FOUND) : ApiResponse.ofSuccess(coupon);
    }

    @ApiOperation(value = "获取所有的优惠券")
    @GetMapping("/coupons")
    public ApiResponse getCoupons() {
        IPage<SmsCoupon> coupons = service.page(new Page<>(1, 4), null);
        return ApiResponse.ofSuccess(coupons);
    }

}
