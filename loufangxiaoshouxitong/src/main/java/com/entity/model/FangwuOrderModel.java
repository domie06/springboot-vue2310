package com.entity.model;

import com.entity.FangwuOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 房屋订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-23
 */
public class FangwuOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 房屋
     */
    private Integer fangwuId;


    /**
     * 客户
     */
    private Integer kehuId;


    /**
     * 订单类型
     */
    private Integer fangwuOrderTypes;


    /**
     * 预约看房时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date fangwuOrderTime;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：房屋
	 */
    public Integer getFangwuId() {
        return fangwuId;
    }


    /**
	 * 设置：房屋
	 */
    public void setFangwuId(Integer fangwuId) {
        this.fangwuId = fangwuId;
    }
    /**
	 * 获取：客户
	 */
    public Integer getKehuId() {
        return kehuId;
    }


    /**
	 * 设置：客户
	 */
    public void setKehuId(Integer kehuId) {
        this.kehuId = kehuId;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getFangwuOrderTypes() {
        return fangwuOrderTypes;
    }


    /**
	 * 设置：订单类型
	 */
    public void setFangwuOrderTypes(Integer fangwuOrderTypes) {
        this.fangwuOrderTypes = fangwuOrderTypes;
    }
    /**
	 * 获取：预约看房时间
	 */
    public Date getFangwuOrderTime() {
        return fangwuOrderTime;
    }


    /**
	 * 设置：预约看房时间
	 */
    public void setFangwuOrderTime(Date fangwuOrderTime) {
        this.fangwuOrderTime = fangwuOrderTime;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：订单创建时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
