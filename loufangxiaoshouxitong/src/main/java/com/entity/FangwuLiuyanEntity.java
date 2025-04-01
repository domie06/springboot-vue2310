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
 * 房屋留言
 *
 * @author 
 * @email
 * @date 2021-04-23
 */
@TableName("fangwu_liuyan")
public class FangwuLiuyanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FangwuLiuyanEntity() {

	}

	public FangwuLiuyanEntity(T t) {
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
     * 留言内容
     */
    @TableField(value = "fangwu_liuyan_content")

    private String fangwuLiuyanContent;


    /**
     * 回复内容
     */
    @TableField(value = "reply_content")

    private String replyContent;


    /**
     * 留言时间
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
	 * 设置：留言内容
	 */
    public String getFangwuLiuyanContent() {
        return fangwuLiuyanContent;
    }


    /**
	 * 获取：留言内容
	 */

    public void setFangwuLiuyanContent(String fangwuLiuyanContent) {
        this.fangwuLiuyanContent = fangwuLiuyanContent;
    }
    /**
	 * 设置：回复内容
	 */
    public String getReplyContent() {
        return replyContent;
    }


    /**
	 * 获取：回复内容
	 */

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }
    /**
	 * 设置：留言时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：留言时间
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
        return "FangwuLiuyan{" +
            "id=" + id +
            ", fangwuId=" + fangwuId +
            ", kehuId=" + kehuId +
            ", fangwuLiuyanContent=" + fangwuLiuyanContent +
            ", replyContent=" + replyContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
