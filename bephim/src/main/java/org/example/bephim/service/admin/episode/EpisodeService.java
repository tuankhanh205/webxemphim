package org.example.bephim.service.admin.episode;

import org.example.bephim.dto.episode.request.EpisodeRequest;
import org.example.bephim.dto.episode.response.EpisodeResponse;

import java.util.List;

public interface EpisodeService {
    EpisodeResponse createEpisode(EpisodeRequest episodeRequest);
    EpisodeResponse updateEpisode(Integer id,EpisodeRequest episodeRequest);
    List<EpisodeResponse> getAllEpisodes();
    EpisodeResponse getEpisodeById(Integer episodeId);
}
