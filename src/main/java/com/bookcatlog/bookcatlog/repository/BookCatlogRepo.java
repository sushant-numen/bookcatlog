package com.bookcatlog.bookcatlog.repository;

import com.bookcatlog.bookcatlog.models.BookCatlogAudit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookCatlogRepo extends JpaRepository <BookCatlogAudit,Integer>{
    void deleteByBookName(String bookName);
    void deleteByBookId(Integer bookId);
    List<BookCatlogAudit> findByBookName(String bookName);
    List<BookCatlogAudit> findByauthor(String author);
}
