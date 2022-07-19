package com.tulingxueyuan.mall.modules.excel.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tulingxueyuan.mall.common.api.CommonPage;
import com.tulingxueyuan.mall.common.api.CommonResult;
import com.tulingxueyuan.mall.dto.ExecuteExcelDto;
import com.tulingxueyuan.mall.dto.excel.InsertBranchDataDto;
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
     * excel数据导入
     * @param list
     * @return
     */
    @RequestMapping(value="/insertBranchData",method = RequestMethod.POST)
    public CommonResult insertBranchData(@RequestBody InsertBranchDataDto req){

        branchDataService.insertBranchData(req.getSheet1());
        if(true){
            return CommonResult.success(true);
        }
        else {
            return CommonResult.failed();
        }

    }


    /**
     * excel数据查询展示
     * @param branchName 部门名称
     * @param dataType 数据类型
     * @param anyMatch 模糊条件（日期、部门名称、数据类型）
     * @param pageNum 查询页
     * @param pageSize 每页查询数量
     * @return
     */
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

