package me.mezage.functionalreactive.models.giphy;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class GiphyData {
    private String type;
    private String id;
    private ImageData images;
}
