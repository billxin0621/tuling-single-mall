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
 * 部门采销店铺结果数据
 * </p>
 *
 * @author XuShu
 * @since 2022-07-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("branch_sale_shop_result_data")
@ApiModel(value="BranchSaleShopResultData对象", description="部门采销店铺结果数据")
public class BranchSaleShopResultData implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "物理主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "总用户")
    private String dealPinTotal;

    @ApiModelProperty(value = "总用户同比")
    private String tongbiTotal;

    @ApiModelProperty(value = "新用户")
    private String dealPinNew;

    @ApiModelProperty(value = "新用户同比")
    private String tongbiNew;

    @ApiModelProperty(value = "老用户")
    private String dealPinOld;

    @ApiModelProperty(value = "老用户同比")
    private String tongbiOld;


}
