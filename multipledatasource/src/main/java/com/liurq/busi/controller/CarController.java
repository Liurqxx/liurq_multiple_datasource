package com.liurq.busi.controller;

import com.liurq.busi.bean.CarType;
import com.liurq.busi.service.CarTypeService;
import com.liurq.multidatasource.annotation.Router;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @Desc 车辆管理
 * @Author HuZhengQuan
 * @Date 2020/12/28 15:02
 */
@Slf4j
@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarTypeService carTypeService;

    /**
     * 添加一个车辆类型
     *
     * @return
     */
    @Router(routingFiled = "typeId")
    @PostMapping("/type/save")
    public String saveCarType(CarType carType) {
        try {
            return carTypeService.saveCarTypeList(carType) ? "ok" : "faild";
        } catch (Exception e) {
            log.error("[EXCEPTION]-[CarController]-[saveCarType]-[Exception]", e);
        }
        return "ok";
    }
}
