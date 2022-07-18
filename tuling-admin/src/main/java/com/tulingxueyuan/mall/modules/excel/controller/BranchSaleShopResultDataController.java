package com.tulingxueyuan.mall.modules.excel.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tulingxueyuan.mall.common.api.CommonPage;
import com.tulingxueyuan.mall.common.api.CommonResult;
import com.tulingxueyuan.mall.dto.ExecuteExcelDto;
import com.tulingxueyuan.mall.modules.excel.service.BranchSaleShopResultDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 部门采销店铺结果数据 前端控制器
 * </p>
 *
 * @author XuShu
 * @since 2022-07-07
 */
@RestController
@RequestMapping("/branchsaleshopresultdata")
public class BranchSaleShopResultDataController {

    @Autowired
    private BranchSaleShopResultDataService branchSaleShopResultDataService;

    /**
     * 分类添加
     * url:'/productCategory/create',
     *     method:'post',
     *     data:data
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public CommonResult list(
            @RequestParam(value="name",defaultValue = "") String name,
            @RequestParam(value="dealPinTotal",defaultValue = "") String dealPinTotal,
            @RequestParam(value="pageNum",defaultValue = "1") Integer pageNum,
            @RequestParam(value="pageSize",defaultValue = "5") Integer pageSize)
    {

        Page page = branchSaleShopResultDataService.queryBranchSaleShopResultData(name, dealPinTotal, pageNum, pageSize);

        return CommonResult.success(CommonPage.restPage(page));

    }


}

