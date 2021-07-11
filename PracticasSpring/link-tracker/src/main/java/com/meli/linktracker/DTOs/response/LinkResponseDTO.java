package com.meli.linktracker.DTOs.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkResponseDTO {

    public Long id;
    public String url;
    public String linkID;
    //public String

}
