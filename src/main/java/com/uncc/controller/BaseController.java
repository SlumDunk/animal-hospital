package com.uncc.controller;

import com.uncc.dto.ServiceResult;
import com.uncc.service.BaseService;
import com.uncc.vo.QueryVO;
import com.uncc.vo.ResponseResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Service;

/**
 * @Author: zerongliu
 * @Date: 10/29/18 20:53
 * @Description:
 */
@RestController
@RequestMapping("/animal-hospital/")
public class BaseController {

    @Autowired
    BaseService baseService;

    @ResponseBody
    @RequestMapping(value = "query", method = RequestMethod.POST)
    public ResponseResult executeSqlCommand(@RequestBody QueryVO queryVO) {
        ResponseResult result = new ResponseResult();
        ServiceResult serviceResult = new ServiceResult();
        if (StringUtils.isNotBlank(queryVO.getCommand())) {
            serviceResult = baseService.queryDataSet(queryVO.getCommand());
        }
        result.setCode("200");
        result.setMsg("success");
        result.setData(serviceResult);
        return result;
    }
}
