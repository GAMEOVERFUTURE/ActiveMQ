package com.iapppay.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.iapppay.consumer.utils.EncryptorUtils;

/**
 * 
 * @className: IappayActiveMQConnectionFactory
 * @classDescription:
 * @author lishiqiang
 * @create_date: 2019年4月24日 下午5:28:55
 * @update_date:
 */
public class IappayActiveMQConnectionFactory extends ActiveMQConnectionFactory {

	/** 为了安全，数据库登录用户名采有密文配置，应用访问时在重新进行解密 */
	@Override
	public void setUserName(String user) {
		String one = EncryptorUtils.getDecryptionString(user);
		String newUser = EncryptorUtils.getDecryptionString(one);
		super.setUserName(newUser);
	}

	/** 为了安全，数据库登录密码采有密文配置，应用访问时在重新进行解密 */
	@Override
	public void setPassword(String password) {
		String one = EncryptorUtils.getDecryptionString(password);
		String newPasswd = EncryptorUtils.getDecryptionString(one);
		super.setPassword(newPasswd);
	}

}
