package com.bookcatlog.bookcatlog.repository;

import com.bookcatlog.bookcatlog.models.BookCatlogAudit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCatlogRepo extends JpaRepository <BookCatlogAudit,Integer>{

}
