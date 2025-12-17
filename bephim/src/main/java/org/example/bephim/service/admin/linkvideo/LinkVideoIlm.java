package org.example.bephim.service.admin.linkvideo;

import org.example.bephim.dto.link_video.request.LinkVideoRequest;
import org.example.bephim.dto.link_video.response.LinkVideoResponse;
import org.example.bephim.entity.Episode;
import org.example.bephim.entity.LinkVideo;
import org.example.bephim.exception.NotFoundException;
import org.example.bephim.repository.EpisodeRepository;
import org.example.bephim.repository.LinkVideoRepository;
import org.example.bephim.service.CloudinaryService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class LinkVideoIlm implements LinkVideoService {
    private final LinkVideoRepository linkVideoRepository;
    private final CloudinaryService cloudinaryService;
    private final EpisodeRepository episodeRepository;

    public LinkVideoIlm(LinkVideoRepository linkVideoRepository, CloudinaryService cloudinaryService, EpisodeRepository episodeRepository) {
        this.linkVideoRepository = linkVideoRepository;
        this.cloudinaryService = cloudinaryService;
        this.episodeRepository = episodeRepository;
    }

    @Override
    public LinkVideoResponse createLinkVideo(MultipartFile video, LinkVideoRequest linkVideoRequest) throws IOException {
        Episode episode = episodeRepository.findById(linkVideoRequest.getEpisodeId()).orElseThrow(()->new NotFoundException("ko co id episode nay"));
        LinkVideo linkVideo=new LinkVideo();
        linkVideo.setName(linkVideoRequest.getName());
        linkVideo.setEpisode(episode);
        String videoUrl=cloudinaryService.uploadVideo(video);
        linkVideo.setUrl(videoUrl);
        linkVideoRepository.save(linkVideo);

        return mapToResponse(linkVideo);
    }
    LinkVideoResponse mapToResponse(LinkVideo linkVideo) {
        LinkVideoResponse response=new LinkVideoResponse();
        response.setId(linkVideo.getId());
        response.setName(linkVideo.getName());
        response.setUrl(linkVideo.getUrl());
        response.setEpisodeId(linkVideo.getEpisode().getId());
        return response;
    }
}
