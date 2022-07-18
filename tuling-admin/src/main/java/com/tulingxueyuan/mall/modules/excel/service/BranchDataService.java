package com.tulingxueyuan.mall.modules.excel.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tulingxueyuan.mall.modules.excel.mapper.BranchDataMapper;
import com.tulingxueyuan.mall.modules.excel.model.BranchData;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 * 部门数据 服务类
 * </p>
 *
 * @author XuShu
 * @since 2022-07-07
 */
public interface BranchDataService extends IService<BranchData> {

    public void insertBranchData(List<BranchData> list);

    public Page list(String name, String dataType, String anyMatch, Integer pageNum, Integer pageSize);

}
