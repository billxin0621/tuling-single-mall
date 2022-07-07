package com.tulingxueyuan.mall.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="表格上传数据传输对象", description="用于表格上传")
public class ExecuteExcelDto {
    private String name;
    private String age;
    private String space;
}
