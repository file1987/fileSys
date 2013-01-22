package com.file.system.model.user;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.Timestamp;
import org.apache.ibatis.type.Alias;
import com.file.system.exception.EncryptException;
import com.file.system.utils.EncryptUtil;
/**
 * 持久对象
 * 与数据库的t_system_user表对应
 * @author file
 *
 */
@Alias("user")
public class User {
	/** 登录名  */
	private String loginName;
	/** 用户名（昵称）  */
	private String userName;
	/** 密码 */
	private String password;
	/** 姓名  */
	private String name;
	/** 性别 */
	private String sex;
	/** 身份证 */
	private String cardNum;
	/** 电子邮箱 */
	private String email;
	/** 联系电话 */
	private String telephone;
	/** 地址 */
	private String address;
	/** 出生日期  */
	private Date   birthday;
	/** 头像 */
	private byte[] picture;
	/** 备注  */
	private String remark;
	/** 创建日期 */
	private Timestamp creationDate;
	/** 创建人 */
	private String createdBy;
	/** 更新日期  */
	private Timestamp updatedDate;
	/** 更新人  */
	private String updatedBy;
	
	
	public String getLoginName() {
		return loginName;
	}


	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		try {
			return password==null?null:EncryptUtil.getInstance().encrypt(password, password);
		} catch (EncryptException e) {
			e.printStackTrace();
			return password;
		}
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getCardNum() {
		return cardNum;
	}


	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public byte[] getPicture() {
		return picture;
	}


	public void setPicture(byte[] picture) {
		this.picture = picture;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public Timestamp getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public Timestamp getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}


	public String getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	@Override
	public String toString(){
		StringBuilder buider = new StringBuilder();
		Class<? extends User> clazz = this.getClass();
		buider.append("[");
		
		for(Method method :clazz.getMethods()){
			if(method.getName().startsWith("get")){
				try {
					buider.append(method.getName().substring(3)).append(":").append(method.invoke(this)).append(",");
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}

		return buider.append("]").toString();
	}
}
