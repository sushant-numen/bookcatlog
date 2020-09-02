package com.bookcatlog.bookcatlog.services.base;

import com.bookcatlog.bookcatlog.models.BookCatlogAudit;
import com.bookcatlog.bookcatlog.pojos.requests.ReqBookCatlog;
import com.bookcatlog.bookcatlog.pojos.responses.ResBookCatlog;

import java.util.List;

public interface BookCatlogService {
       ResBookCatlog createBook(ReqBookCatlog reqBookCatlog);
       ResBookCatlog deleteBookById(Integer bookId);
       ResBookCatlog deleteByBookName(String bookName);
       List<BookCatlogAudit> searchByName(String bookName);



}
