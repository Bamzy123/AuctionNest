package org.babi.Models;

import lombok.Getter;
import lombok.Setter;
import org.babi.Enums.Role;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String username;
    private String email;
    private String password;
    @DBRef
    private Role role;
    private boolean banned;
}
