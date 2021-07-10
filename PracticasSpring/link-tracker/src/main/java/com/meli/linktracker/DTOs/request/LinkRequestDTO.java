package com.meli.linktracker.DTOs.request;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.annotation.processing.SupportedOptions;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Validated
public class LinkRequestDTO {

    @Size(min=4, max=5) //http o https
    public String scheme;

    @Size(min=5, max=30)
    @NotBlank
    @NotEmpty
    public String domain;

    @Size(max=50)
    public String path;

    @Override
    public String toString() {
        return scheme + "://" + domain + path;
    }
}
