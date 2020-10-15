package com.disapand.mall;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.disapand.mall.entity.SmsCoupon;
import com.disapand.mall.mapper.SmsCouponMapper;
import com.disapand.mall.service.impl.SmsCouponServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MallApplicationTests {

    @Autowired
    private SmsCouponMapper smsCouponMapper;

    @Test
    void contextLoads() {
    }   

    @Test
    public void selectByPage() {
        Page<SmsCoupon> page = new Page<>(1, 5);
        IPage<SmsCoupon> couponIPage = smsCouponMapper.selectPage(page, null);
        List<SmsCoupon> smsCoupons = couponIPage.getRecords();
        smsCoupons.forEach(System.out::println);
    }
}
