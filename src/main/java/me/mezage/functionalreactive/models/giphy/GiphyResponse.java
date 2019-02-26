package me.mezage.functionalreactive.models.giphy;

import lombok.Data;

import java.util.List;

@Data
public class GiphyResponse {
    private List<GiphyData> data;
}
