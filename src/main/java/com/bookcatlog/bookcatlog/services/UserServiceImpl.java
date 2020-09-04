package com.bookcatlog.bookcatlog.services;

import com.bookcatlog.bookcatlog.models.UserAudit;
import com.bookcatlog.bookcatlog.pojos.requests.ReqUser;
import com.bookcatlog.bookcatlog.pojos.responses.ResUser;
import com.bookcatlog.bookcatlog.repository.UserRepo;
import com.bookcatlog.bookcatlog.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    private  final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public ResUser createUser (ReqUser reqUser){
        UserAudit userAudit= new UserAudit();

        userAudit.setUserName(reqUser.getUserName());
        userAudit.setEmailId(reqUser.getEmailId());
        userAudit.setMobileNumber(reqUser.getMobileNumber());

        userAudit=userRepo.save(userAudit);
        int id=userAudit.getId();
        System.out.println(id);
        ResUser resUser= new ResUser("success",id);
        return resUser;
    }
}
