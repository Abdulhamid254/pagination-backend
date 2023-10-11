package io.abdul.pagination.resource;


import io.abdul.pagination.dormain.HttpResponse;
import io.abdul.pagination.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;


import static java.time.LocalDateTime.now;
import static javax.security.auth.callback.ConfirmationCallback.OK;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor // for dependency injection
public class UserResource {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<HttpResponse>getUsers(@RequestParam Optional<String>name,@RequestParam Optional<Integer>page,@RequestParam Optional<Integer> size) throws InterruptedException {


        TimeUnit.SECONDS.sleep(3);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timestamp(now().toString())
                        //orElse is another way of setting default values by also using optional incase they don't key in anything
                        .data(Map.of("page", userService.getUsers(name.orElse(""),page.orElse(0),size.orElse(10))))
                        .message("Users Retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                                .build()); //build is how we're going to create the object here
    }
}
