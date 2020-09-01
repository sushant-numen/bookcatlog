package com.bookcatlog.bookcatlog.services.base;

import com.bookcatlog.bookcatlog.pojos.requests.ReqBookCatlog;
import com.bookcatlog.bookcatlog.pojos.responses.ResBookCatlog;

public interface BookCatlogService {
       ResBookCatlog createBook(ReqBookCatlog reqBookCatlog);

}
