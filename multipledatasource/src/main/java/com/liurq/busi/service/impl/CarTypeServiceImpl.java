package com.liurq.busi.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liurq.busi.bean.CarType;
import com.liurq.busi.dao.CarTypeRepository;
import com.liurq.busi.service.CarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarTypeServiceImpl extends ServiceImpl<CarTypeRepository, CarType> implements CarTypeService {

    @Autowired
    private CarTypeRepository carTypeRepository;

    @Override
    public Boolean saveCarTypeList(CarType carType) {


        carTypeRepository.insertCarType(carType);

        return true;

    }
}
