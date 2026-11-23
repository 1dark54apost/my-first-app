package com.dark_apostle.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchByStringDTO {

    private String name;

    private Integer pageNum;

    private Integer pageSize;

}
