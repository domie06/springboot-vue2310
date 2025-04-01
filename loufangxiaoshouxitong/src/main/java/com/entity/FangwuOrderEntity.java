package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 房屋订单
 *
 * @author 
 * @email
 * @date 2021-04-23
 */
@TableName("fangwu_order")
public class FangwuOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FangwuOrderEntity() {

	}

	public FangwuOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 房屋
     */
    @TableField(value = "fangwu_id")

    private Integer fangwuId;


    /**
     * 客户
     */
    @TableField(value = "kehu_id")

    private Integer kehuId;


    /**
     * 订单类型
     */
    @TableField(value = "fangwu_order_types")

    private Integer fangwuOrderTypes;


    /**
     * 预约看房时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "fangwu_order_time",fill = FieldFill.UPDATE)

    private Date fangwuOrderTime;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：房屋
	 */
    public Integer getFangwuId() {
        return fangwuId;
    }


    /**
	 * 获取：房屋
	 */

    public void setFangwuId(Integer fangwuId) {
        this.fangwuId = fangwuId;
    }
    /**
	 * 设置：客户
	 */
    public Integer getKehuId() {
        return kehuId;
    }


    /**
	 * 获取：客户
	 */

    public void setKehuId(Integer kehuId) {
        this.kehuId = kehuId;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getFangwuOrderTypes() {
        return fangwuOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setFangwuOrderTypes(Integer fangwuOrderTypes) {
        this.fangwuOrderTypes = fangwuOrderTypes;
    }
    /**
	 * 设置：预约看房时间
	 */
    public Date getFangwuOrderTime() {
        return fangwuOrderTime;
    }


    /**
	 * 获取：预约看房时间
	 */

    public void setFangwuOrderTime(Date fangwuOrderTime) {
        this.fangwuOrderTime = fangwuOrderTime;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "FangwuOrder{" +
            "id=" + id +
            ", fangwuId=" + fangwuId +
            ", kehuId=" + kehuId +
            ", fangwuOrderTypes=" + fangwuOrderTypes +
            ", fangwuOrderTime=" + fangwuOrderTime +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
