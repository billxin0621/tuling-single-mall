package com.tulingxueyuan.mall.dto.excel;

import com.tulingxueyuan.mall.modules.excel.model.BranchData;
import lombok.Data;

import java.util.List;

@Data
public class InsertBranchDataDto {

    private List<BranchData> sheet1;
}
