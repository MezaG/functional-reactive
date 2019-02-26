package me.mezage.functionalreactive.models.omdb;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
 public class SearchData {
    @JsonAlias("Title")
    private String title;
}
