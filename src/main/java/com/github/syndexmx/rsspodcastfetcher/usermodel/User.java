package com.github.syndexmx.rsspodcastfetcher.usermodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private String userName;

    private String userPassword;

    private String mail;

}
