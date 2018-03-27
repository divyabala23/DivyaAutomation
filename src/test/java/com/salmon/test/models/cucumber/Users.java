package com.salmon.test.models.cucumber;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;



@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Users {

        String userId;
        String firstName;
        String username;
        String password;




}
