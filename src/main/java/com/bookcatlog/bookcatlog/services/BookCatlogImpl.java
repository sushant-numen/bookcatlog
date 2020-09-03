package com.bookcatlog.bookcatlog.services;

import com.bookcatlog.bookcatlog.models.BookCatlogAudit;
import com.bookcatlog.bookcatlog.pojos.requests.ReqBookCatlog;
import com.bookcatlog.bookcatlog.pojos.responses.ResBookCatlog;
import com.bookcatlog.bookcatlog.repository.BookCatlogRepo;
import com.bookcatlog.bookcatlog.services.base.BookCatlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BookCatlogImpl implements BookCatlogService {
    private final BookCatlogRepo bookCatlogRepo;

    @Autowired
    public  BookCatlogImpl ( BookCatlogRepo bookCatlogRepo){
        this.bookCatlogRepo=bookCatlogRepo;
    }
    @Override
    public ResBookCatlog createBook (ReqBookCatlog reqBookCatlog) {
         BookCatlogAudit bookCatlogAudit=new BookCatlogAudit();

         bookCatlogAudit.setBookName(reqBookCatlog.getBookName());
         bookCatlogAudit.setAuthor(reqBookCatlog.getAuthor());
         bookCatlogAudit.setBookId(reqBookCatlog.getBookId());

         bookCatlogAudit=bookCatlogRepo.save(bookCatlogAudit);
         ResBookCatlog resBookCatlog= new ResBookCatlog(("success"));
         bookCatlogRepo.save(bookCatlogAudit);

        return  resBookCatlog;
    }
    @Override
    public  ResBookCatlog updateBook(ReqBookCatlog reqBookCatlog){
        BookCatlogAudit existingBook=bookCatlogRepo.findByBookId(reqBookCatlog.getBookId());
        if(reqBookCatlog.getBookName().length()>0){
            existingBook.setBookName(reqBookCatlog.getBookName());
        }
        if(reqBookCatlog.getAuthor().length()>0){
            existingBook.setAuthor(reqBookCatlog.getAuthor());
        }
//        existingBook=bookCatlogRepo.save(existingBook);
        bookCatlogRepo.save(existingBook);


        ResBookCatlog resBookCatlog= new ResBookCatlog(("success"));
        return  resBookCatlog;


    }

    @Override
    public ResBookCatlog deleteBookById (Integer bookId) {

        bookCatlogRepo.deleteByBookId(bookId);
        ResBookCatlog resBookCatlog= new ResBookCatlog(("success"));
        return  resBookCatlog;


    }
    @Override
    public ResBookCatlog deleteByBookName (String bookName) {

        bookCatlogRepo.deleteByBookName(bookName);
        ResBookCatlog resBookCatlog= new ResBookCatlog(("success"));
        return  resBookCatlog;


    }

    @Override
    public List<BookCatlogAudit> searchBookByName(String bookName){
        return bookCatlogRepo.findByBookName(bookName);

    }
    @Override
    public List<BookCatlogAudit> searchBookByAuthor(String author){
        return bookCatlogRepo.findByauthor(author);

    }


    
}
