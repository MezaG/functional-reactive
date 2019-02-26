package me.mezage.functionalreactive.models.omdb;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.util.List;

@Data
public class OmdbResponse {
    @JsonAlias("Search")
    List<SearchData> search;
}
