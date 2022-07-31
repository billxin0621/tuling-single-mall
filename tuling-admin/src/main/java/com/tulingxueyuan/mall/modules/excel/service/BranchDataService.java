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

    /**
     * 部门数据表清空并插入数据（批量）
     * @param list 插入的数据
     */
    public Boolean insertBranchData(List<BranchData> list);

    /**
     * excel数据查询展示
     * @param branchName 部门名称
     * @param dataType 数据类型
     * @param anyMatch 模糊条件（日期、部门名称、数据类型）
     * @param pageNum 查询页
     * @param pageSize 每页查询数量
     * @return
     */
    public Page list(String branchName, String dataType, String anyMatch, Integer pageNum, Integer pageSize);

}
