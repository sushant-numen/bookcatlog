package com.bookcatlog.bookcatlog.repository;

import com.bookcatlog.bookcatlog.models.UserAudit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserAudit, Integer> {
}
