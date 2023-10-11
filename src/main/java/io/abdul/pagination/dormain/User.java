package io.abdul.pagination.dormain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity  //entities for jpa to manage
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter @Setter

//@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonInclude(NON_DEFAULT) // if something has default value eg its null not pushed to the frontend
public class User {
    @Id @GeneratedValue(strategy = IDENTITY)
    private long id;
    private String name;
    private String email;
    private  String status;

    private String address;
    private String phone;
    private String imageUrl;
}
