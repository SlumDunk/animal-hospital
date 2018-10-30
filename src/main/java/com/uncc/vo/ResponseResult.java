package com.uncc.vo;

import lombok.*;

/**
 * @Author: zerongliu
 * @Date: 10/29/18 20:56
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult {
    private String code;
    private String msg;
    private Object data;
}
