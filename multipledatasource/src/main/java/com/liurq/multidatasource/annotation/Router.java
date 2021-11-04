package com.liurq.multidatasource.annotation;

import com.liurq.multidatasource.constant.RoutingStategyConstant;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author liurq
 * @desc
 * @date 2021-11-04  21:18
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Router {

    String routingFiled() default RoutingStategyConstant.DEFAULT_ROUTING_FIELD;
}
