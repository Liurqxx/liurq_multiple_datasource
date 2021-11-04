package com.liurq.busi.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.liurq.busi.bean.CarType;

public interface CarTypeService extends IService<CarType> {


    Boolean saveCarTypeList(CarType carType);

}
