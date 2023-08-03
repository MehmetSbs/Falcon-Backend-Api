package com.internship.falcon.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String userSurname;
    private String userName;



    public UserDto(Builder builder){
        this.userName = builder.userName;
        this.userSurname = builder.userSurname;
    }

    @NoArgsConstructor
    public static class Builder{

        private String userSurname;
        private String userName;

        public Builder userName(final String userName){
            this.userName = userName;
            return this;
        }

        public Builder userSurname(final String userSurname){
            this.userSurname = userSurname;
            return this;
        }

        public UserDto build(){
            return new UserDto(this);
        }


    }


}
