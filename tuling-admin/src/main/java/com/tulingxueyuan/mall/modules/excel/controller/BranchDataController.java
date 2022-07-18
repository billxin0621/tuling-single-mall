package com.tulingxueyuan.mall.modules.excel.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tulingxueyuan.mall.common.api.CommonPage;
import com.tulingxueyuan.mall.common.api.CommonResult;
import com.tulingxueyuan.mall.dto.ExecuteExcelDto;
import com.tulingxueyuan.mall.modules.excel.model.BranchData;
import com.tulingxueyuan.mall.modules.excel.service.BranchDataService;
import com.tulingxueyuan.mall.modules.excel.service.BranchSaleShopResultDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 部门数据 前端控制器
 * </p>
 *
 * @author XuShu
 * @since 2022-07-07
 */
@RestController
@RequestMapping("/branchData")
public class BranchDataController {

    @Autowired
    private BranchDataService branchDataService;

    /**
     *
     * @param list
     * @return
     */
    @RequestMapping(value="/insertBranchData",method = RequestMethod.POST)
    public CommonResult executeExcel(@RequestBody List<BranchData> list){

        branchDataService.insertBranchData(list);
        if(true){
            return CommonResult.success(true);
        }
        else {
            return CommonResult.failed();
        }

    }



    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public CommonResult list(
            @RequestParam(value="branchName",defaultValue = "") String branchName,
            @RequestParam(value="dataType",defaultValue = "") String dataType,
            @RequestParam(value="anyMatch",defaultValue = "") String anyMatch,
            @RequestParam(value="pageNum",defaultValue = "1") Integer pageNum,
            @RequestParam(value="pageSize",defaultValue = "10000") Integer pageSize)
    {

        Page page = branchDataService.list(branchName, dataType, anyMatch, pageNum, pageSize);

        return CommonResult.success(CommonPage.restPage(page));

    }

}

