package com.bookcatlog.bookcatlog.services.base;

import com.bookcatlog.bookcatlog.pojos.requests.ReqUser;
import com.bookcatlog.bookcatlog.pojos.responses.ResUser;

public interface UserService {
    ResUser createUser(ReqUser reqUser);
}
