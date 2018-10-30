package com.uncc.service.impl;

import com.uncc.dao.BaseDao;
import com.uncc.dto.ServiceResultDTO;
import com.uncc.po.DaoResultPO;
import com.uncc.service.BaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: zerongliu
 * @Date: 10/29/18 21:37
 * @Description:
 */
@Component
public class BaseServiceImpl implements BaseService {
    @Autowired
    BaseDao baseDao;

    @Override
    public ServiceResultDTO queryDataSet(String command) {
        ServiceResultDTO serviceResult = new ServiceResultDTO();
        DaoResultPO daoResult = baseDao.executeQuery(command);
        BeanUtils.copyProperties(daoResult, serviceResult);
        return serviceResult;
    }
}
