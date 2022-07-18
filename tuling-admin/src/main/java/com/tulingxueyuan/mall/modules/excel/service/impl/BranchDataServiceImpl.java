package com.tulingxueyuan.mall.modules.excel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tulingxueyuan.mall.modules.excel.mapper.BranchDataMapper;
import com.tulingxueyuan.mall.modules.excel.model.BranchData;
import com.tulingxueyuan.mall.modules.excel.model.BranchSaleShopResultData;
import com.tulingxueyuan.mall.modules.excel.service.BranchDataService;
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
@Service
public class BranchDataServiceImpl extends ServiceImpl<BranchDataMapper, BranchData> implements BranchDataService {

    @Autowired
    BranchDataMapper branchDataMapper;

    DecimalFormat decimalFormat = new DecimalFormat("###,###.##%");

    @Override
    public void insertBranchData(List<BranchData> list){
        branchDataMapper.deleteAll();
        for (int i = 0; i < list.size(); i++) {
            branchDataMapper.insert(list.get(i));
        }
    }


    @Override
    public Page list(String branchName, String dataType, String anyMatch, Integer pageNum, Integer pageSize) {
        Page page=new Page(pageNum,pageSize);

        QueryWrapper<BranchData> queryWrapper = new QueryWrapper<>();

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

        queryWrapper.lambda().orderByAsc(BranchData::getId);

        Page result = this.page(page,queryWrapper);

        List<BranchData> orders = result.getRecords();
        for (BranchData body : orders) {
            if (!StringUtils.isEmpty(body.getUserTongbi())){
                body.setUserTongbi(decimalFormat.format(new BigDecimal(body.getUserTongbi())));
            }
            if (!StringUtils.isEmpty(body.getBranchDapanZhanbi())){
                body.setBranchDapanZhanbi(decimalFormat.format(new BigDecimal(body.getBranchDapanZhanbi())));
            }
            if (!StringUtils.isEmpty(body.getChengjiaojineTongbi())){
                body.setChengjiaojineTongbi(decimalFormat.format(new BigDecimal(body.getChengjiaojineTongbi())));
            }
            if (!StringUtils.isEmpty(body.getArpuTongbi())){
                body.setArpuTongbi(decimalFormat.format(new BigDecimal(body.getArpuTongbi())));
            }
            if (!StringUtils.isEmpty(body.getKedanjiaTongbi())){
                body.setKedanjiaTongbi(decimalFormat.format(new BigDecimal(body.getKedanjiaTongbi())));
            }
            if (!StringUtils.isEmpty(body.getGoumaipinciTongbi())){
                body.setGoumaipinciTongbi(decimalFormat.format(new BigDecimal(body.getGoumaipinciTongbi())));
            }
            if (!StringUtils.isEmpty(body.getJiandanjiaTongbi())){
                body.setJiandanjiaTongbi(decimalFormat.format(new BigDecimal(body.getJiandanjiaTongbi())));
            }
            if (!StringUtils.isEmpty(body.getRenjunxiaoliangTongbi())){
                body.setRenjunxiaoliangTongbi(decimalFormat.format(new BigDecimal(body.getRenjunxiaoliangTongbi())));
            }
            if (!StringUtils.isEmpty(body.getRenjunjianshuTongbi())){
                body.setRenjunjianshuTongbi(decimalFormat.format(new BigDecimal(body.getRenjunjianshuTongbi())));
            }

            if (!StringUtils.isEmpty(body.getUser())){
                body.setUser(new BigDecimal(body.getUser()).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            }
            if (!StringUtils.isEmpty(body.getDapan())){
                body.setDapan(new BigDecimal(body.getDapan()).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            }
            if (!StringUtils.isEmpty(body.getChengjiaojine())){
                body.setChengjiaojine(new BigDecimal(body.getChengjiaojine()).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            }
            if (!StringUtils.isEmpty(body.getXiaoliang())){
                body.setXiaoliang(new BigDecimal(body.getXiaoliang()).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            }
            if (!StringUtils.isEmpty(body.getDingdan())){
                body.setDingdan(new BigDecimal(body.getDingdan()).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            }
            if (!StringUtils.isEmpty(body.getArpu())){
                body.setArpu(new BigDecimal(body.getArpu()).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            }
            if (!StringUtils.isEmpty(body.getKedanjia())){
                body.setKedanjia(new BigDecimal(body.getKedanjia()).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            }
            if (!StringUtils.isEmpty(body.getGoumaipinci())){
                body.setGoumaipinci(new BigDecimal(body.getGoumaipinci()).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            }
            if (!StringUtils.isEmpty(body.getJiandanjia())){
                body.setJiandanjia(new BigDecimal(body.getJiandanjia()).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            }
            if (!StringUtils.isEmpty(body.getRenjunxiaoliang())){
                body.setRenjunxiaoliang(new BigDecimal(body.getRenjunxiaoliang()).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            }
            if (!StringUtils.isEmpty(body.getRenjunjianshu())){
                body.setRenjunjianshu(new BigDecimal(body.getRenjunjianshu()).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            }









        }

        return result;
    }
}
