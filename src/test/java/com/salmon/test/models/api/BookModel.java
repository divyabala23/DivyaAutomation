package com.salmon.test.models.api;

/**
 * Created by ravuris on 17/04/2018.
 */

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class BookModel {

    String isbn;
    String title;
    String subtitle;
    String author;
    String publisher;
    int pages;
    String description;
    String website;

}
