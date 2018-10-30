package com.uncc.service;

import com.uncc.dto.ServiceResult;
import org.springframework.stereotype.Service;

/**
 * @Author: zerongliu
 * @Date: 10/29/18 21:34
 * @Description:
 */
@Service
public interface BaseService {
    ServiceResult queryDataSet(String command);
}
