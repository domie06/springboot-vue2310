package com.entity.model;

import com.entity.FangwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 房屋
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-23
 */
public class FangwuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 房屋名称
     */
    private String fangwuName;


    /**
     * 房屋户型
     */
    private Integer fangwuHuxingTypes;


    /**
     * 房屋地址
     */
    private String fangwuWeizhi;


    /**
     * 房屋特点
     */
    private String fangwuTedian;


    /**
     * 交房日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date fangwuTime;


    /**
     * 房屋缩略图
     */
    private String fangwuPhoto;


    /**
     * 价格(每平米)
     */
    private Integer fangwuNewMoney;


    /**
     * 平米
     */
    private Integer fangwuPingmi;


    /**
     * 剩余套数
     */
    private Integer fangwuNumber;


    /**
     * 房屋详情
     */
    private String fangwuContent;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 获取：房屋名称
	 */
    public String getFangwuName() {
        return fangwuName;
    }


    /**
	 * 设置：房屋名称
	 */
    public void setFangwuName(String fangwuName) {
        this.fangwuName = fangwuName;
    }
    /**
	 * 获取：房屋户型
	 */
    public Integer getFangwuHuxingTypes() {
        return fangwuHuxingTypes;
    }


    /**
	 * 设置：房屋户型
	 */
    public void setFangwuHuxingTypes(Integer fangwuHuxingTypes) {
        this.fangwuHuxingTypes = fangwuHuxingTypes;
    }
    /**
	 * 获取：房屋地址
	 */
    public String getFangwuWeizhi() {
        return fangwuWeizhi;
    }


    /**
	 * 设置：房屋地址
	 */
    public void setFangwuWeizhi(String fangwuWeizhi) {
        this.fangwuWeizhi = fangwuWeizhi;
    }
    /**
	 * 获取：房屋特点
	 */
    public String getFangwuTedian() {
        return fangwuTedian;
    }


    /**
	 * 设置：房屋特点
	 */
    public void setFangwuTedian(String fangwuTedian) {
        this.fangwuTedian = fangwuTedian;
    }
    /**
	 * 获取：交房日期
	 */
    public Date getFangwuTime() {
        return fangwuTime;
    }


    /**
	 * 设置：交房日期
	 */
    public void setFangwuTime(Date fangwuTime) {
        this.fangwuTime = fangwuTime;
    }
    /**
	 * 获取：房屋缩略图
	 */
    public String getFangwuPhoto() {
        return fangwuPhoto;
    }


    /**
	 * 设置：房屋缩略图
	 */
    public void setFangwuPhoto(String fangwuPhoto) {
        this.fangwuPhoto = fangwuPhoto;
    }
    /**
	 * 获取：价格(每平米)
	 */
    public Integer getFangwuNewMoney() {
        return fangwuNewMoney;
    }


    /**
	 * 设置：价格(每平米)
	 */
    public void setFangwuNewMoney(Integer fangwuNewMoney) {
        this.fangwuNewMoney = fangwuNewMoney;
    }
    /**
	 * 获取：平米
	 */
    public Integer getFangwuPingmi() {
        return fangwuPingmi;
    }


    /**
	 * 设置：平米
	 */
    public void setFangwuPingmi(Integer fangwuPingmi) {
        this.fangwuPingmi = fangwuPingmi;
    }
    /**
	 * 获取：剩余套数
	 */
    public Integer getFangwuNumber() {
        return fangwuNumber;
    }


    /**
	 * 设置：剩余套数
	 */
    public void setFangwuNumber(Integer fangwuNumber) {
        this.fangwuNumber = fangwuNumber;
    }
    /**
	 * 获取：房屋详情
	 */
    public String getFangwuContent() {
        return fangwuContent;
    }


    /**
	 * 设置：房屋详情
	 */
    public void setFangwuContent(String fangwuContent) {
        this.fangwuContent = fangwuContent;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
