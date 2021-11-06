package com.liurq.multidatasource.aspect;

import com.liurq.multidatasource.annotation.Router;
import com.liurq.multidatasource.core.IRouting;
import com.liurq.multidatasource.dynamicdatasource.MultiDataSourceHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * @author liurq
 * @desc
 * @date 2021-11-04  21:18
 */
@Slf4j
@Aspect
@Component
public class RoutingAspect {

    @Resource
    private IRouting routing;

    @Pointcut("@annotation(com.liurq.multidatasource.annotation.Router)")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) throws Exception {

        long beginTime = System.currentTimeMillis();
        //获取方法调用名称
        Method method = getInvokeMethod(joinPoint);
        //获取方法上指定的注解
        Router router = method.getAnnotation(Router.class);
        //获取指定的路由key
        String routingFiled = router.routingFiled();
        //获取方法入参
        Object[] args = joinPoint.getArgs();
        //校验是否包含路由key
        boolean havingRoutingField = false;
        if (null != args && args.length > 0) {
            for (int index = 0; index < args.length; index++) {
                String routingFieldValue = BeanUtils.getProperty(args[index], routingFiled);
                log.info("routingFieldValue:{}", routingFieldValue);
                if (StringUtils.isNotBlank(routingFieldValue)) {
                    String dbKey = routing.calDataSourceKey(routingFieldValue);
                    String tableIndex = routing.calTableKey(routingFieldValue);
                    log.info("dbKey:{}", dbKey);
                    log.info("tableIndex:{}", tableIndex);
                    havingRoutingField = true;
                    break;
                }
            }
        }
        if (!havingRoutingField) {
            log.error("未指定路由key");
            throw new NullPointerException("");
        }

    }

    /**
     * 获取调用方法
     *
     * @param joinPoint
     * @return
     */
    private Method getInvokeMethod(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        return method;
    }

    /**
     * 清除线程缓存
     *
     * @param joinPoint
     */
    public void methodAfter(JoinPoint joinPoint) {

        MultiDataSourceHolder.clearDataSourceKey();
        MultiDataSourceHolder.clearTableIndex();
    }


}
