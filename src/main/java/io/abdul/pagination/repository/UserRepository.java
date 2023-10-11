package io.abdul.pagination.repository;

import io.abdul.pagination.dormain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
   //method for sorting and paging extended paging and sorting repository so we can use pageable
    Page<User> findByNameContaining(String name, Pageable pageable);
}
