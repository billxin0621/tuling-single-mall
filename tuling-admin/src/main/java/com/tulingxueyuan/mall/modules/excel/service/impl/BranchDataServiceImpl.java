package com.tulingxueyuan.mall.modules.excel.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.JsonObject;
import com.tulingxueyuan.mall.modules.excel.mapper.BranchDataMapper;
import com.tulingxueyuan.mall.modules.excel.model.BranchData;
import com.tulingxueyuan.mall.modules.excel.service.BranchDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

/**
 * <p>
 * 部门数据 服务实现类
 * </p>
 *
 * @author XuShu
 * @since 2022-07-07
 */
@Slf4j
@Service
public class BranchDataServiceImpl extends ServiceImpl<BranchDataMapper, BranchData> implements BranchDataService {

    @Autowired
    BranchDataMapper branchDataMapper;

    DecimalFormat decimalFormat = new DecimalFormat("###,###.##%");

    /**
     * 部门数据表清空并插入数据（批量）
     * @param list 插入的数据
     */
    @Override
    public void insertBranchData(List<BranchData> list){
        branchDataMapper.deleteAll();
        int result = branchDataMapper.insertBatch(list);
        log.info("部门数据表插入数据条数：{}", result);
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
    @Override
    public Page list(String branchName, String dataType, String anyMatch, Integer pageNum, Integer pageSize) {
        Page page=new Page(pageNum,pageSize);

        QueryWrapper<BranchData> queryWrapper = new QueryWrapper<>();

        // 查询条件处理
        if (!StringUtils.isEmpty(anyMatch)){
            // 万能匹配条件不为空
            queryWrapper.lambda().or().like(BranchData::getDate, anyMatch);
            queryWrapper.lambda().or().like(BranchData::getBranchName, anyMatch);
            queryWrapper.lambda().or().like(BranchData::getUser, anyMatch);
        }else {
            // 万能匹配条件为空，则使用下面查询条件
            if(!StringUtils.isEmpty(branchName)){
                queryWrapper.lambda().like(BranchData::getBranchName, branchName);
            }
            if(!StringUtils.isEmpty(dataType)){
                queryWrapper.lambda().eq(BranchData::getDataType, dataType);
            }
        }

        // 排序
        queryWrapper.lambda().orderByAsc(BranchData::getId);

        // 查询数据库
        Page result = this.page(page,queryWrapper);

        // 查询返回值处理（格式化）
        List<BranchData> orders = result.getRecords();
        for (BranchData body : orders) {
            // 格式化数据为百分数
            body.setUserTongbi(dataFormatPercent(body.getUserTongbi()));
            body.setBranchDapanZhanbi(dataFormatPercent(body.getBranchDapanZhanbi()));
            body.setChengjiaojineTongbi(dataFormatPercent(body.getChengjiaojineTongbi()));
            body.setArpuTongbi(dataFormatPercent(body.getArpuTongbi()));
            body.setKedanjiaTongbi(dataFormatPercent(body.getKedanjiaTongbi()));
            body.setGoumaipinciTongbi(dataFormatPercent(body.getGoumaipinciTongbi()));
            body.setJiandanjiaTongbi(dataFormatPercent(body.getJiandanjiaTongbi()));
            body.setRenjunxiaoliangTongbi(dataFormatPercent(body.getRenjunxiaoliangTongbi()));
            body.setRenjunjianshuTongbi(dataFormatPercent(body.getRenjunjianshuTongbi()));
            // 格式化数据为两位小数
            body.setUser(dataFormatSetScale(body.getUser()));
            body.setDapan(dataFormatSetScale(body.getDapan()));
            body.setChengjiaojine(dataFormatSetScale(body.getChengjiaojine()));
            body.setXiaoliang(dataFormatSetScale(body.getXiaoliang()));
            body.setDingdan(dataFormatSetScale(body.getDingdan()));
            body.setArpu(dataFormatSetScale(body.getArpu()));
            body.setKedanjia(dataFormatSetScale(body.getKedanjia()));
            body.setGoumaipinci(dataFormatSetScale(body.getGoumaipinci()));
            body.setJiandanjia(dataFormatSetScale(body.getJiandanjia()));
            body.setRenjunxiaoliang(dataFormatSetScale(body.getRenjunxiaoliang()));
            body.setRenjunjianshu(dataFormatSetScale(body.getRenjunjianshu()));

        }
        log.info("查询返回值为：{}", JSON.toJSONString(orders));
        return result;
    }

    /**
     * 格式化数据为两位小数
     * @param data
     * @return
     */
    private String dataFormatSetScale(String data){
        try {
            if (!StringUtils.isEmpty(data)){
                return new BigDecimal(data).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
            }
        }catch (Exception e){
            return null;
        }
        return null;
    }

    /**
     * 格式化数据为百分数
     * @param data
     * @return
     */
    private String dataFormatPercent(String data){
        try {
            if (!StringUtils.isEmpty(data)){
                return decimalFormat.format(new BigDecimal(data));
            }
        }catch (Exception e){
            return null;
        }
        return null;
    }
}
