package io.abdul.pagination.service.implementation;


import io.abdul.pagination.dormain.User;
import io.abdul.pagination.repository.UserRepository;
import io.abdul.pagination.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j //for logging some stuffs
public class UserServiceimpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Page<User> getUsers(String name, int page, int size) {
        log.info("fetching users for page {} of size {}",page, size);
        return userRepository.findByNameContaining(name, PageRequest.of(page,size));
    }
}
