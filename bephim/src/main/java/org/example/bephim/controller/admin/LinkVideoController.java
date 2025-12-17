package org.example.bephim.controller.admin;

import org.example.bephim.dto.link_video.request.LinkVideoRequest;
import org.example.bephim.dto.link_video.response.LinkVideoResponse;
import org.example.bephim.service.admin.linkvideo.LinkVideoService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/admin/linkVideo")
public class LinkVideoController {
    private final LinkVideoService linkVideoService;

    public LinkVideoController(LinkVideoService linkVideoService) {
        this.linkVideoService = linkVideoService;
    }
    @PostMapping(value = "/create",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    LinkVideoResponse createLinkVideo(@RequestPart("video") MultipartFile video, @RequestPart("data") LinkVideoRequest linkVideoRequest) throws IOException{
        return linkVideoService.createLinkVideo(video, linkVideoRequest);
    }

}
