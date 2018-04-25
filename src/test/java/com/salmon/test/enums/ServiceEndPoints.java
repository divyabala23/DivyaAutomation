package com.salmon.test.enums;

public enum ServiceEndPoints {

        CITY("/city"),
        GET_POSTS_BY_ID("/posts/{id}"),
        COMMENTS("/comments"),
        GET_COMMENT_BY_ID("/comments/{id}"),
        USER_BY_EMAILID("user/{emailId}"),
        GET_AUTHENTICATION("authentication/CheckForAuthentication"),
        GET_WEATHER_BY_CITY("utilities/weather/city/"),
        GET_ALLBOOKS("utilities/books/getallbooks"),
        POST_CUSTOMER("customer/register");

        private String url;

        private ServiceEndPoints(String url) {
            this.url = url;
        }
        public String getUrl(){
            return url;
        }
    }


