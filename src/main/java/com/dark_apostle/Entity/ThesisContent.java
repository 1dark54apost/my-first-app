package com.dark_apostle.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThesisContent {

    private Integer id;

    //论文标识
    private Integer contentID;

    //论文标题
    private String title;

    //论文体
    private String content;



}
