package com.salmon.test.models.api;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;


/**
 * Created by ravuris on 23/04/2018.
 */

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Books {

    List<Book> books;

}
