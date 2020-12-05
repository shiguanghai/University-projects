package service;

import javax.security.sasl.SaslException;

import mapping.UsersMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import entity.Users;
import entity.UsersExample;

@Service
public class LoginService {
	@Autowired
	private UsersMapper usersMapper;

	public boolean validate(String username, String password) throws SaslException {
		Users user;
		UsersExample example  = new UsersExample();
		example.createCriteria().andUsernameEqualTo(username);
		if(!(usersMapper.selectByExample(example).isEmpty())) {
			user = usersMapper.selectByExample(example).get(0);
		} else {
			// �û������ڣ���½ʧ�ܣ�
			return false;
		}
	
		// ��ȡ���ݿ������
		String passwordDB = user.getPassword();
		if(passwordDB.equals(password))
			return true;
		// �������
		return false;
	}
	
}
