package com.tulingxueyuan.mall.modules.excel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tulingxueyuan.mall.modules.excel.model.BranchData;

/**
 * <p>
 * 部门数据 Mapper 接口
 * </p>
 *
 * @author XuShu
 * @since 2022-07-07
 */
public interface BranchDataMapper extends BaseMapper<BranchData> {

    public void deleteAll();
}
