package com.tulingxueyuan.mall.modules.excel.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tulingxueyuan.mall.modules.excel.model.BranchSaleShopResultData;

/**
 * <p>
 * 部门采销店铺结果数据 服务类
 * </p>
 *
 * @author XuShu
 * @since 2022-07-07
 */
public interface BranchSaleShopResultDataService extends IService<BranchSaleShopResultData> {

    public Page queryBranchSaleShopResultData(String name, String dealPinTotal, Integer pageNum, Integer pageSize);

}
