package org.example.bephim.service.admin.linkvideo;

import org.example.bephim.dto.link_video.request.LinkVideoRequest;
import org.example.bephim.dto.link_video.response.LinkVideoResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface LinkVideoService {
    LinkVideoResponse createLinkVideo(MultipartFile video,LinkVideoRequest linkVideoRequest) throws IOException;
}
