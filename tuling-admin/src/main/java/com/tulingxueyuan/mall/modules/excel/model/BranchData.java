package com.tulingxueyuan.mall.modules.excel.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 部门数据
 * </p>
 *
 * @author XuShu
 * @since 2022-07-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("branch_data")
@ApiModel(value="BranchData对象", description="部门数据")
public class BranchData implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "物理主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "日期")
    private String date;

    @ApiModelProperty(value = "部门")
    private String branchName;

    @ApiModelProperty(value = "数据类型")
    private String dataType;

    @ApiModelProperty(value = "用户")
    private String user;

    @ApiModelProperty(value = "用户同比")
    private String userTongbi;

    @ApiModelProperty(value = "母婴大盘用户数")
    private String dapan;

    @ApiModelProperty(value = "部门用户占比母婴大盘")
    private String branchDapanZhanbi;

    @ApiModelProperty(value = "成交金额")
    private String chengjiaojine;

    @ApiModelProperty(value = "成交金额同比")
    private String chengjiaojineTongbi;

    @ApiModelProperty(value = "销量")
    private String xiaoliang;

    @ApiModelProperty(value = "订单")
    private String dingdan;

    @ApiModelProperty(value = "ARPU")
    private String arpu;

    @ApiModelProperty(value = "ARPU同比")
    private String arpuTongbi;

    @ApiModelProperty(value = "客单价")
    private String kedanjia;

    @ApiModelProperty(value = "客单价同比")
    private String kedanjiaTongbi;

    @ApiModelProperty(value = "购买频次")
    private String goumaipinci;

    @ApiModelProperty(value = "购买频次同比")
    private String goumaipinciTongbi;

    @ApiModelProperty(value = "件单价")
    private String jiandanjia;

    @ApiModelProperty(value = "件单价同比")
    private String jiandanjiaTongbi;

    @ApiModelProperty(value = "人均销量")
    private String renjunxiaoliang;

    @ApiModelProperty(value = "人均销量同比")
    private String renjunxiaoliangTongbi;

    @ApiModelProperty(value = "人均件数")
    private String renjunjianshu;

    @ApiModelProperty(value = "人均件数同比")
    private String renjunjianshuTongbi;


}
