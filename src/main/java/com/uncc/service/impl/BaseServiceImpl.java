package com.uncc.service.impl;

import com.uncc.dao.BaseDao;
import com.uncc.dto.ServiceResult;
import com.uncc.po.DaoResult;
import com.uncc.service.BaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
    public ServiceResult queryDataSet(String command) {
        ServiceResult serviceResult = new ServiceResult();
        DaoResult daoResult = baseDao.executeQuery(command);
        BeanUtils.copyProperties(daoResult, serviceResult);
        return serviceResult;
    }
}
