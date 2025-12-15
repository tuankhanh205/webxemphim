package org.example.bephim.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.example.bephim.config.cloudinary.CloudinaryConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service

public class CloudinaryService {
    private final Cloudinary cloudinary;

    public CloudinaryService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    public String uploadVideo(MultipartFile file) throws IOException {
        Map video= cloudinary.uploader().upload(file.getBytes(),
                ObjectUtils.asMap(
                        "resource_type", "video",
                        "folder", "bePhim"
                ));
         return video.get("secure_url").toString();
    }

    public String uploadFile(MultipartFile file) {
        try {
            // Upload file lên Cloudinary
            Map<String, Object> data = cloudinary.uploader().upload(file.getBytes(), Map.of());

            // Lấy URL từ map trả về
            String url = (String) data.get("secure_url");

            return url;
        } catch (IOException e) {
            throw new RuntimeException("Image upload failed", e);
        }
    }
}
