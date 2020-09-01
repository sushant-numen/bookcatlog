package com.bookcatlog.bookcatlog.services;

import com.bookcatlog.bookcatlog.models.BookCatlogAudit;
import com.bookcatlog.bookcatlog.pojos.requests.ReqBookCatlog;
import com.bookcatlog.bookcatlog.pojos.responses.ResBookCatlog;
import com.bookcatlog.bookcatlog.repository.BookCatlogRepo;
import com.bookcatlog.bookcatlog.services.base.BookCatlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookCatlogImpl implements BookCatlogService {
    private final BookCatlogRepo bookCatlogRepo;

    @Autowired
    public  BookCatlogImpl ( BookCatlogRepo bookCatlogRepo){
        this.bookCatlogRepo=bookCatlogRepo;
    }
    @Override
    public ResBookCatlog createBook (ReqBookCatlog reqBookCatlog) {

        BookCatlogAudit bookCatlogAudit = new BookCatlogAudit();

        bookCatlogAudit.setBookName(reqBookCatlog.getBookName());
        bookCatlogAudit.setBookId(reqBookCatlog.getBookId());
        bookCatlogAudit.setAuthor(reqBookCatlog.getAuthor());

        bookCatlogAudit=bookCatlogRepo.save(bookCatlogAudit);
        ResBookCatlog resBookCatlog =new ResBookCatlog("Book Created");
        bookCatlogRepo.save(bookCatlogAudit);

        return  resBookCatlog;
    }

    
}
