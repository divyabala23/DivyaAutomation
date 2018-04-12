package com.salmon.test.enums;

public enum ServiceEndPoints {

        CITY("/city"),
        GET_POSTS_BY_ID("/posts/{id}"),
        COMMENTS("/comments"),
        GET_COMMENT_BY_ID("/comments/{id}"),
        USER_BY_EMAILID("user/{emailId}");

        private String url;

        private ServiceEndPoints(String url) {
            this.url = url;
        }
        public String getUrl(){
            return url;
        }
    }


