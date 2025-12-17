package org.example.bephim.controller.admin;

import org.example.bephim.dto.episode.request.EpisodeRequest;
import org.example.bephim.dto.episode.response.EpisodeResponse;
import org.example.bephim.service.admin.episode.EpisodeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/episode")
public class EpisodeController {
    private final EpisodeService episodeService;

    public EpisodeController(EpisodeService episodeService) {
        this.episodeService = episodeService;
    }
    @PostMapping("/create")
    EpisodeResponse createEpisode(@RequestBody EpisodeRequest episodeRequest){
        return episodeService.createEpisode(episodeRequest);
    }

    @PutMapping("/update/{id}")
    EpisodeResponse updateEpisode(@PathVariable("id") Integer id,@RequestBody EpisodeRequest episodeRequest){
        return episodeService.updateEpisode(id, episodeRequest);
    }

    @GetMapping
    List<EpisodeResponse> getAllEpisodes(){
        return episodeService.getAllEpisodes();
    }


    @GetMapping("/{id}")
    EpisodeResponse getEpisodeById(@PathVariable("id") Integer episodeId){
        return episodeService.getEpisodeById(episodeId);
    }
}
