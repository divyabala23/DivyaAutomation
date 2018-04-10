package com.salmon.test.models.api;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE) // Removes necessity to specify access modifier for every fields
public class RegistrationSuccessResponse {

public String SuccessCode;

//Variable where value of SuccessCode node will be copied
//The name should be exactly as the node name is present in json

public String Message;

//Variable where value of Message node will be copied
//The name should be exactly as the node name is present in json

}
