package com.dark_apostle.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThesisContent {

    private Integer id;

    private Integer contentID;

    private String content;

    private String title;

}
