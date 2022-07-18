package com.tulingxueyuan.mall.modules.excel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tulingxueyuan.mall.modules.excel.mapper.BranchSaleShopResultDataMapper;
import com.tulingxueyuan.mall.modules.excel.model.BranchSaleShopResultData;
import com.tulingxueyuan.mall.modules.excel.service.BranchSaleShopResultDataService;
import com.tulingxueyuan.mall.modules.pms.model.PmsBrand;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 部门采销店铺结果数据 服务实现类
 * </p>
 *
 * @author XuShu
 * @since 2022-07-07
 */
@Service
public class BranchSaleShopResultDataServiceImpl extends ServiceImpl<BranchSaleShopResultDataMapper, BranchSaleShopResultData> implements BranchSaleShopResultDataService {

    @Override
    public Page queryBranchSaleShopResultData(String name, String dealPinTotal, Integer pageNum, Integer pageSize) {
        Page page=new Page(pageNum,pageSize);

        QueryWrapper<BranchSaleShopResultData> pmsBrandQueryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(name)){
            pmsBrandQueryWrapper.lambda().like(BranchSaleShopResultData::getName, name);
        }
        if(!StringUtils.isEmpty(dealPinTotal)){
            pmsBrandQueryWrapper.lambda().eq(BranchSaleShopResultData::getDealPinTotal, dealPinTotal);
        }
        pmsBrandQueryWrapper.lambda().orderByAsc(BranchSaleShopResultData::getId);

        return this.page(page,pmsBrandQueryWrapper);
    }
}
