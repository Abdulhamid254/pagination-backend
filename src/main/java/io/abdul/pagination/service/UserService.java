package io.abdul.pagination.service;

import io.abdul.pagination.dormain.User;
import org.springframework.data.domain.Page;

public interface UserService {
    Page<User> getUsers(String name, int page, int size);
}
