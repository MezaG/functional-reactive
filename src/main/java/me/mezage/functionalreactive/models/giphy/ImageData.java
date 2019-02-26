package me.mezage.functionalreactive.models.giphy;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class ImageData {

    @JsonAlias("original_still")
    private OriginalImage originalImage;
}
