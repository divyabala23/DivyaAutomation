package com.salmon.test.models.api;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Created by ravuris on 18/04/2018.
 *
 **/

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Book {

    String title;
    String subtitle;
    String author;
    String published;
    String publisher;
    int pages;
    String description;
    String website;

}
