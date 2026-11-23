package com.dark_apostle.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThesisDTO {

    private ThesisContentDTO contentDTO;

    private List<ThesisAuthorDTO> authorDTO;


}
