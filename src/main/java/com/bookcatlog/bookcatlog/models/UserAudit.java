package com.bookcatlog.bookcatlog.models;

import com.bookcatlog.bookcatlog.pojos.requests.ReqUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_table")
@EntityListeners(AuditingEntityListener.class)
@Builder
public class UserAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @Column(name="user_name",columnDefinition = "TEXT")
    private String userName;

    @Column(name = "email_id", columnDefinition = "TEXT")
    private String emailId;

    @Column(name = "mobile_number", columnDefinition = "TEXT")
    private String mobileNumber;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime modifiedAt;

    public UserAudit(ReqUser reqUser) {
        this.userName = reqUser.getUserName();
        this.emailId = reqUser.getEmailId();
        this.mobileNumber = reqUser.getMobileNumber();
    }
}
