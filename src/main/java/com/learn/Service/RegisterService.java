package com.learn.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.Exception.EmailIdAlreadyExistsException;
import com.learn.model.User;
import com.learn.repository.RegisterRepository;

@Service
public class RegisterService {
	
	@Autowired
	private RegisterRepository regisRepo;
	
	public String createUser(User user) throws EmailIdAlreadyExistsException
	{
		String tempEmail=user.getEmailId();
		if(tempEmail!=null && !"".equals(tempEmail))
		{
			User existsUser=regisRepo.findByEmailId(tempEmail);
			
			if(existsUser!=null)
			{
				throw new EmailIdAlreadyExistsException("User","EmailId",existsUser.getEmailId());
			}
			
		}
		User user1=regisRepo.save(user);
		return "User with Id "+user1.getRegisterId()+" is registered successfully";
	}

	public User loginVerifyDetails(User user) throws Exception {

       String tempEmail=user.getEmailId();
       String tempPwd=user.getPassword();
        User userObject=null;
       if(tempEmail!=null && tempPwd!=null)
       {
    	   userObject=regisRepo.findByEmailIdAndPassword(tempEmail, tempPwd);
       }
		if(userObject==null)
		{
			throw new Exception("Bad Credentials");
		}
		return userObject;
	}

}
