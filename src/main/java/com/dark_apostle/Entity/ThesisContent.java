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
    private String contentID;

    //论文标题
    private String title;

    //论文体
    private String content;

    //是否被删除
    private boolean isDelete;

    public ThesisContent(ThesisContentDTO dto,String contentID,boolean isDelete){
        id = null;
        this.contentID = contentID;
        this.isDelete = isDelete;
        title = dto.getTitle();
        content = dto.getContent();
    }


}
