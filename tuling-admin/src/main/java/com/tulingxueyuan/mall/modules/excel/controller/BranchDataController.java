package com.tulingxueyuan.mall.modules.excel.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tulingxueyuan.mall.common.api.CommonPage;
import com.tulingxueyuan.mall.common.api.CommonResult;
import com.tulingxueyuan.mall.dto.excel.InsertBranchDataDto;
import com.tulingxueyuan.mall.modules.excel.service.BranchDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
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
@Slf4j
public class BranchDataController {

    @Autowired
    private BranchDataService branchDataService;


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
            @RequestParam(value="dateStart",defaultValue = "") String dateStart,
            @RequestParam(value="dateEnd",defaultValue = "") String dateEnd,
            @RequestParam(value="pageNum",defaultValue = "1") Integer pageNum,
            @RequestParam(value="pageSize",defaultValue = "10000") Integer pageSize)
    {
        System.out.println(dateStart);
        Page page = branchDataService.list(branchName, dataType, anyMatch,
                                        dateStart, dateEnd, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(page));
    }

    /**
     * excel数据导入
     * @param req
     * @return
     */
    @RequestMapping(value="/insertBranchData",method = RequestMethod.POST)
    public CommonResult insertBranchData(@RequestBody InsertBranchDataDto req){
        Boolean result = branchDataService.insertBranchData(req.getSheet1());
        if(result){
            return CommonResult.success(true);
        }
        else {
            return CommonResult.failed();
        }
    }

    /**
     * excel数据导入
     * @param req
     * @return
     */
    @RequestMapping(value="/executeExcelResultBack",method = RequestMethod.POST)
    public CommonResult executeExcelResultBack(@RequestBody InsertBranchDataDto req){
        // 待执行的逻辑
        log.info("前端参数：{}", JSON.toJSONString(req));

        if(true){
            return CommonResult.success(true);
        }
        else {
            return CommonResult.failed();
        }

    }



}

