package com.entity.vo;

import com.entity.FangwuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 房屋
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-23
 */
@TableName("fangwu")
public class FangwuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 房屋名称
     */

    @TableField(value = "fangwu_name")
    private String fangwuName;


    /**
     * 房屋户型
     */

    @TableField(value = "fangwu_huxing_types")
    private Integer fangwuHuxingTypes;


    /**
     * 房屋地址
     */

    @TableField(value = "fangwu_weizhi")
    private String fangwuWeizhi;


    /**
     * 房屋特点
     */

    @TableField(value = "fangwu_tedian")
    private String fangwuTedian;


    /**
     * 交房日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "fangwu_time")
    private Date fangwuTime;


    /**
     * 房屋缩略图
     */

    @TableField(value = "fangwu_photo")
    private String fangwuPhoto;


    /**
     * 价格(每平米)
     */

    @TableField(value = "fangwu_new_money")
    private Integer fangwuNewMoney;


    /**
     * 平米
     */

    @TableField(value = "fangwu_pingmi")
    private Integer fangwuPingmi;


    /**
     * 剩余套数
     */

    @TableField(value = "fangwu_number")
    private Integer fangwuNumber;


    /**
     * 房屋详情
     */

    @TableField(value = "fangwu_content")
    private String fangwuContent;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：房屋名称
	 */
    public String getFangwuName() {
        return fangwuName;
    }


    /**
	 * 获取：房屋名称
	 */

    public void setFangwuName(String fangwuName) {
        this.fangwuName = fangwuName;
    }
    /**
	 * 设置：房屋户型
	 */
    public Integer getFangwuHuxingTypes() {
        return fangwuHuxingTypes;
    }


    /**
	 * 获取：房屋户型
	 */

    public void setFangwuHuxingTypes(Integer fangwuHuxingTypes) {
        this.fangwuHuxingTypes = fangwuHuxingTypes;
    }
    /**
	 * 设置：房屋地址
	 */
    public String getFangwuWeizhi() {
        return fangwuWeizhi;
    }


    /**
	 * 获取：房屋地址
	 */

    public void setFangwuWeizhi(String fangwuWeizhi) {
        this.fangwuWeizhi = fangwuWeizhi;
    }
    /**
	 * 设置：房屋特点
	 */
    public String getFangwuTedian() {
        return fangwuTedian;
    }


    /**
	 * 获取：房屋特点
	 */

    public void setFangwuTedian(String fangwuTedian) {
        this.fangwuTedian = fangwuTedian;
    }
    /**
	 * 设置：交房日期
	 */
    public Date getFangwuTime() {
        return fangwuTime;
    }


    /**
	 * 获取：交房日期
	 */

    public void setFangwuTime(Date fangwuTime) {
        this.fangwuTime = fangwuTime;
    }
    /**
	 * 设置：房屋缩略图
	 */
    public String getFangwuPhoto() {
        return fangwuPhoto;
    }


    /**
	 * 获取：房屋缩略图
	 */

    public void setFangwuPhoto(String fangwuPhoto) {
        this.fangwuPhoto = fangwuPhoto;
    }
    /**
	 * 设置：价格(每平米)
	 */
    public Integer getFangwuNewMoney() {
        return fangwuNewMoney;
    }


    /**
	 * 获取：价格(每平米)
	 */

    public void setFangwuNewMoney(Integer fangwuNewMoney) {
        this.fangwuNewMoney = fangwuNewMoney;
    }
    /**
	 * 设置：平米
	 */
    public Integer getFangwuPingmi() {
        return fangwuPingmi;
    }


    /**
	 * 获取：平米
	 */

    public void setFangwuPingmi(Integer fangwuPingmi) {
        this.fangwuPingmi = fangwuPingmi;
    }
    /**
	 * 设置：剩余套数
	 */
    public Integer getFangwuNumber() {
        return fangwuNumber;
    }


    /**
	 * 获取：剩余套数
	 */

    public void setFangwuNumber(Integer fangwuNumber) {
        this.fangwuNumber = fangwuNumber;
    }
    /**
	 * 设置：房屋详情
	 */
    public String getFangwuContent() {
        return fangwuContent;
    }


    /**
	 * 获取：房屋详情
	 */

    public void setFangwuContent(String fangwuContent) {
        this.fangwuContent = fangwuContent;
    }
    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
