package com.bookcatlog.bookcatlog.controller;


import com.bookcatlog.bookcatlog.models.BookCatlogAudit;
import com.bookcatlog.bookcatlog.pojos.BaseResponse;
import com.bookcatlog.bookcatlog.pojos.requests.ReqBookCatlog;
import com.bookcatlog.bookcatlog.pojos.responses.ResBookCatlog;
import com.bookcatlog.bookcatlog.services.base.BookCatlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book/v1/")
public class BookCatlogController {

    private final Logger logger = LoggerFactory.getLogger(BookCatlogController.class);

    private final BookCatlogService bookCatlogService;

    @Autowired
    public BookCatlogController(BookCatlogService bookCatlogService) {
        this.bookCatlogService = bookCatlogService;
    }
    //create book
    @PostMapping(value = "/createBook",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<ResBookCatlog>> createBook(@RequestBody ReqBookCatlog reqBookCatlog)  {
        return new ResponseEntity<>(
                new BaseResponse<>(
                        "success",
                        bookCatlogService.createBook(reqBookCatlog)
                ),
                HttpStatus.OK
        );
    }
    @DeleteMapping(value="/deleteBookById")
    public ResponseEntity<BaseResponse<ResBookCatlog>> deleteBookById(@RequestParam Integer bookId )  {
        return new ResponseEntity<>(
                new BaseResponse<>(
                        "success",
                        bookCatlogService.deleteBookById(bookId)
                ),
                HttpStatus.OK
        );
    }

    @DeleteMapping(value="/deleteBookByName")
    public ResponseEntity<BaseResponse<ResBookCatlog>>deleteBookByName (@RequestParam String bookName )  {
        return new ResponseEntity<>(
                new BaseResponse<>(
                        "success",
                        bookCatlogService.deleteByBookName(bookName)
                ),
                HttpStatus.OK
        );
    }

    @PostMapping(value = "/searchBookByName")
    public ResponseEntity<BaseResponse<List<BookCatlogAudit>>>searchBookByName (@RequestParam String bookName)  {
        return new ResponseEntity<>(
                new BaseResponse<>(
                        "success",
                        bookCatlogService.searchBookByName(bookName)
                ),
                HttpStatus.OK
        );
    }

    @PostMapping(value = "/searchBookByAuthor")
    public ResponseEntity<BaseResponse<List<BookCatlogAudit>>>searchBookByAuthor (@RequestParam String author)  {
        return new ResponseEntity<>(
                new BaseResponse<>(
                        "success",
                        bookCatlogService.searchBookByAuthor(author)
                ),
                HttpStatus.OK
        );
    }

    @PutMapping(value ="/updateBookByBookId")
    public ResponseEntity<BaseResponse<ResBookCatlog>>updateBookByBookId (@RequestBody ReqBookCatlog reqBookCatlog ) {
        return new ResponseEntity<>(
                new BaseResponse<>(
                        "success",
                        bookCatlogService.updateBook(reqBookCatlog)
                ),
                HttpStatus.OK
        );
    }


}
