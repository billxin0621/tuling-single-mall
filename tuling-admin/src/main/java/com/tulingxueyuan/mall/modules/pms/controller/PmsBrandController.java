package com.tulingxueyuan.mall.modules.pms.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tulingxueyuan.mall.common.api.CommonPage;
import com.tulingxueyuan.mall.common.api.CommonResult;
import com.tulingxueyuan.mall.dto.ExecuteExcelDto;
import com.tulingxueyuan.mall.dto.PmsProductCategoryDTO;
import com.tulingxueyuan.mall.modules.pms.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author XuShu
 * @since 2021-02-26
 */
@RestController
@RequestMapping("/brand")
public class PmsBrandController {

    @Autowired
    PmsBrandService brandService;
    /**
     *  品牌数据列表
     *      在商品中进行共用
     *  url:'/brand/list',
     *     method:'get',
     *     params:params
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public CommonResult list(
            @RequestParam(value="keyword",defaultValue = "") String keyword,
            @RequestParam(value="pageNum",defaultValue = "1") Integer pageNum,
            @RequestParam(value="pageSize",defaultValue = "5") Integer pageSize)
    {
        Page page = brandService.list(keyword, pageNum, pageSize);

        return CommonResult.success(CommonPage.restPage(page));
    }

    /**
     * 分类添加
     * url:'/productCategory/create',
     *     method:'post',
     *     data:data
     */
    @RequestMapping(value="/executeExcel",method = RequestMethod.POST)
    public CommonResult executeExcel(@RequestBody List<ExecuteExcelDto> executeExcelDtoList){

        boolean result = brandService.executeExcel(executeExcelDtoList);
        if(result){
            return CommonResult.success(result);
        }
        else {
            return CommonResult.failed();
        }

    }
}

