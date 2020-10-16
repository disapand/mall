package com.disapand.mall.interceptor;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.sql.Array;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author aoxiang-zhangqian
 */
@Intercepts({
        @Signature(
                type = ResultSetHandler.class,
                method = "handleResultSets",
                args = {Statement.class}
        )
})
public class ResultFieldInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // TODO: 自定义拦截器
        Object returnValue = invocation.proceed();
        System.out.println("是否为空：" + returnValue.toString().trim().isEmpty());
        System.out.println("是否为空：" + StringUtils.isEmpty(returnValue));
        if (returnValue.toString().trim() == "[]") {
            System.out.println("结果为空");
            return null;
        } else {
            System.out.println(returnValue);
            return returnValue;
        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
