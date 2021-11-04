package com.liurq.busi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liurq.busi.bean.CarType;

public interface CarTypeRepository extends BaseMapper<CarType> {

    void insertCarType(CarType carType);

}
