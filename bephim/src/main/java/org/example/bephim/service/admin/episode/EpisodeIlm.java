package org.example.bephim.service.admin.episode;

import org.example.bephim.dto.episode.request.EpisodeRequest;
import org.example.bephim.dto.episode.response.EpisodeResponse;
import org.example.bephim.dto.link_video.response.LinkVideoResponse;
import org.example.bephim.entity.Episode;
import org.example.bephim.entity.LinkVideo;
import org.example.bephim.entity.Movie;
import org.example.bephim.exception.NotFoundException;
import org.example.bephim.repository.EpisodeRepository;
import org.example.bephim.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpisodeIlm implements EpisodeService{
    private final EpisodeRepository episodeRepository;
    private  final MovieRepository movieRepository;

    public EpisodeIlm(EpisodeRepository episodeRepository, MovieRepository movieRepository) {
        this.episodeRepository = episodeRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public EpisodeResponse createEpisode(EpisodeRequest episodeRequest) {
        Movie movie=movieRepository.findById(episodeRequest.getMovieId()).orElseThrow(()->new NotFoundException("ko có id movie nay"));
        Episode episode = new Episode();
        episode.setTitle(episodeRequest.getTitle());
        episode.setEpisodeNumber(episodeRequest.getEpisodeNumber());

        if(movie.getTotalEpisodes()>=episodeRequest.getEpisodeNumber()){
            episode.setMovie(movie);
        }else{
            throw new RuntimeException("tập số không được lớn hơn số tập");
        }

        episodeRepository.save(episode);
        return mapToResponse(episode);
    }

    @Override
    public EpisodeResponse updateEpisode(Integer id, EpisodeRequest episodeRequest) {
        Movie movie=movieRepository.findById(episodeRequest.getMovieId()).orElseThrow(()->new NotFoundException("ko có id movie nay"));
        Episode episode=episodeRepository.findById(id).orElseThrow(()->new NotFoundException("ko co id episode này"));
        episode.setTitle(episodeRequest.getTitle());
        episode.setEpisodeNumber(episodeRequest.getEpisodeNumber());
        episode.setMovie(movie);
        episodeRepository.save(episode);
        return mapToResponse(episode);
    }
    @Override
    public List<EpisodeResponse> getAllEpisodes() {
        List<Episode> episodes=episodeRepository.findAll();
        return episodes.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public EpisodeResponse getEpisodeById(Integer episodeId) {
        Episode episode=episodeRepository.findById(episodeId).orElseThrow(()->new NotFoundException("ko co id episode này"));
        return mapToResponse(episode);
    }
    EpisodeResponse mapToResponse(Episode episode) {
        EpisodeResponse episodeResponse = new EpisodeResponse();
        episodeResponse.setId(episode.getId());
        episodeResponse.setTitle(episode.getTitle());
        episodeResponse.setEpisodeNumber(episode.getEpisodeNumber());
        episodeResponse.setCreateDate(episode.getCreateDate());
        episodeResponse.setUpdateDate(episode.getUpdateDate());
        episodeResponse.setMovieId(episode.getMovie().getId());
        List<LinkVideoResponse> linkVideoResponses=new ArrayList<>();
        for(LinkVideo linkVideo:episode.getLinkVideos()){
            LinkVideoResponse linkVideoResponse=new LinkVideoResponse();
            linkVideoResponse.setId(linkVideo.getId());
            linkVideoResponse.setName(linkVideo.getName());
            linkVideoResponse.setUrl(linkVideo.getUrl());
            linkVideoResponse.setEpisodeId(linkVideo.getEpisode().getId());
            linkVideoResponses.add(linkVideoResponse);
        }
        episodeResponse.setLinkVideos(linkVideoResponses);
        return episodeResponse;
    }
}
