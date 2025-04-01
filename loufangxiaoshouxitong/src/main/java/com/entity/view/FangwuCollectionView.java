package com.entity.view;

import com.entity.FangwuCollectionEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 房屋收藏
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-23
 */
@TableName("fangwu_collection")
public class FangwuCollectionView extends FangwuCollectionEntity implements Serializable {
    private static final long serialVersionUID = 1L;



		//级联表 fangwu
			/**
			* 房屋名称
			*/
			private String fangwuName;
			/**
			* 房屋户型
			*/
			private Integer fangwuHuxingTypes;
				/**
				* 房屋户型的值
				*/
				private String fangwuHuxingValue;
			/**
			* 房屋地址
			*/
			private String fangwuWeizhi;
			/**
			* 房屋特点
			*/
			private String fangwuTedian;
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			/**
			* 交房日期
			*/
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

		//级联表 kehu
			/**
			* 姓名
			*/
			private String kehuName;
			/**
			* 手机号
			*/
			private String kehuPhone;
			/**
			* 身份证号
			*/
			private String kehuIdNumber;
			/**
			* 头像
			*/
			private String kehuPhoto;
			/**
			* 性别
			*/
			private Integer sexTypes;
				/**
				* 性别的值
				*/
				private String sexValue;

	public FangwuCollectionView() {

	}

	public FangwuCollectionView(FangwuCollectionEntity fangwuCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, fangwuCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}










				//级联表的get和set fangwu
					/**
					* 获取： 房屋名称
					*/
					public String getFangwuName() {
						return fangwuName;
					}
					/**
					* 设置： 房屋名称
					*/
					public void setFangwuName(String fangwuName) {
						this.fangwuName = fangwuName;
					}
					/**
					* 获取： 房屋户型
					*/
					public Integer getFangwuHuxingTypes() {
						return fangwuHuxingTypes;
					}
					/**
					* 设置： 房屋户型
					*/
					public void setFangwuHuxingTypes(Integer fangwuHuxingTypes) {
						this.fangwuHuxingTypes = fangwuHuxingTypes;
					}


						/**
						* 获取： 房屋户型的值
						*/
						public String getFangwuHuxingValue() {
							return fangwuHuxingValue;
						}
						/**
						* 设置： 房屋户型的值
						*/
						public void setFangwuHuxingValue(String fangwuHuxingValue) {
							this.fangwuHuxingValue = fangwuHuxingValue;
						}
					/**
					* 获取： 房屋地址
					*/
					public String getFangwuWeizhi() {
						return fangwuWeizhi;
					}
					/**
					* 设置： 房屋地址
					*/
					public void setFangwuWeizhi(String fangwuWeizhi) {
						this.fangwuWeizhi = fangwuWeizhi;
					}
					/**
					* 获取： 房屋特点
					*/
					public String getFangwuTedian() {
						return fangwuTedian;
					}
					/**
					* 设置： 房屋特点
					*/
					public void setFangwuTedian(String fangwuTedian) {
						this.fangwuTedian = fangwuTedian;
					}
					/**
					* 获取： 交房日期
					*/
					public Date getFangwuTime() {
						return fangwuTime;
					}
					/**
					* 设置： 交房日期
					*/
					public void setFangwuTime(Date fangwuTime) {
						this.fangwuTime = fangwuTime;
					}
					/**
					* 获取： 房屋缩略图
					*/
					public String getFangwuPhoto() {
						return fangwuPhoto;
					}
					/**
					* 设置： 房屋缩略图
					*/
					public void setFangwuPhoto(String fangwuPhoto) {
						this.fangwuPhoto = fangwuPhoto;
					}
					/**
					* 获取： 价格(每平米)
					*/
					public Integer getFangwuNewMoney() {
						return fangwuNewMoney;
					}
					/**
					* 设置： 价格(每平米)
					*/
					public void setFangwuNewMoney(Integer fangwuNewMoney) {
						this.fangwuNewMoney = fangwuNewMoney;
					}
					/**
					* 获取： 平米
					*/
					public Integer getFangwuPingmi() {
						return fangwuPingmi;
					}
					/**
					* 设置： 平米
					*/
					public void setFangwuPingmi(Integer fangwuPingmi) {
						this.fangwuPingmi = fangwuPingmi;
					}
					/**
					* 获取： 剩余套数
					*/
					public Integer getFangwuNumber() {
						return fangwuNumber;
					}
					/**
					* 设置： 剩余套数
					*/
					public void setFangwuNumber(Integer fangwuNumber) {
						this.fangwuNumber = fangwuNumber;
					}
					/**
					* 获取： 房屋详情
					*/
					public String getFangwuContent() {
						return fangwuContent;
					}
					/**
					* 设置： 房屋详情
					*/
					public void setFangwuContent(String fangwuContent) {
						this.fangwuContent = fangwuContent;
					}













				//级联表的get和set kehu
					/**
					* 获取： 姓名
					*/
					public String getKehuName() {
						return kehuName;
					}
					/**
					* 设置： 姓名
					*/
					public void setKehuName(String kehuName) {
						this.kehuName = kehuName;
					}
					/**
					* 获取： 手机号
					*/
					public String getKehuPhone() {
						return kehuPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setKehuPhone(String kehuPhone) {
						this.kehuPhone = kehuPhone;
					}
					/**
					* 获取： 身份证号
					*/
					public String getKehuIdNumber() {
						return kehuIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setKehuIdNumber(String kehuIdNumber) {
						this.kehuIdNumber = kehuIdNumber;
					}
					/**
					* 获取： 头像
					*/
					public String getKehuPhoto() {
						return kehuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setKehuPhoto(String kehuPhoto) {
						this.kehuPhoto = kehuPhoto;
					}
					/**
					* 获取： 性别
					*/
					public Integer getSexTypes() {
						return sexTypes;
					}
					/**
					* 设置： 性别
					*/
					public void setSexTypes(Integer sexTypes) {
						this.sexTypes = sexTypes;
					}


						/**
						* 获取： 性别的值
						*/
						public String getSexValue() {
							return sexValue;
						}
						/**
						* 设置： 性别的值
						*/
						public void setSexValue(String sexValue) {
							this.sexValue = sexValue;
						}












}
