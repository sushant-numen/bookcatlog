package com.bookcatlog.bookcatlog.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book_catlog")
@EntityListeners(AuditingEntityListener.class)
@Builder
public class BookCatlogAudit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @Column(name="book_id",columnDefinition = "Integer")
    private  Integer bookId;

    @Column(name = "book_name", columnDefinition = "TEXT")
    private String bookName;

    @Column(name = "author", columnDefinition = "TEXT")
    private String author;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime modifiedAt;

    public BookCatlogAudit(Integer bookId, String bookName, String author) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
    }


}
