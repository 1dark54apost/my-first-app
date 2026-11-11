package com.dark_apostle.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThesisAuthor {

    private Integer id;

    //名字
    private String name;

    //作者排位
    private Integer authorOrder;

    //论文标识
    private Integer contentID;
}
