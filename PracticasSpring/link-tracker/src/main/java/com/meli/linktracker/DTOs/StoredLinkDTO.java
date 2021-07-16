package com.meli.linktracker.DTOs;

import com.meli.linktracker.DTOs.response.LinkResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoredLinkDTO {

    public Long id;
    public String url;
    public String linkID;
    public Long calls;
    public String passwordHash;

    public StoredLinkDTO(LinkResponseDTO linkResponseDTO, String hash) {
        this.id = linkResponseDTO.getId();
        this.url = linkResponseDTO.getUrl();
        this.linkID = linkResponseDTO.getLinkID();
        this.calls = 0L;
        this.passwordHash = hash;
    }

    public void addCall() {
        calls = calls + 1;
    }
}
