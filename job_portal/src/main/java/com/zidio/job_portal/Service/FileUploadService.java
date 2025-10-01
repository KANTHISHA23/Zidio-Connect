package com.zidio.job_portal.Service;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.utils.ObjectUtils;
import com.zidio.job_portal.Security.CloudinaryConfig;

@Service
public class FileUploadService {

	@Autowired 
	private CloudinaryConfig cloudinaryConfig;
	
	public String uploadFile(MultipartFile file, String folder) throws IOException{
		try {
			Map uploadFile= cloudinaryConfig.cloudinary().uploader().upload(file.getBytes(),ObjectUtils.asMap("folder",folder));
			return(String)uploadFile.get("secure_url");
		}
	    catch(IOException e){
	    	e.printStackTrace();
	    }
		return folder;
	}
	
	public void validateAndProcessImage(MultipartFile file) throws IOException {
        // Validate content type
        if (!file.getContentType().equalsIgnoreCase("image/jpeg")) {
            throw new IllegalArgumentException("Only JPG files are allowed.");
        }

        // Validate file extension
        String fileName = file.getOriginalFilename();
        if (fileName == null || !fileName.toLowerCase().endsWith(".jpg")) {
            throw new IllegalArgumentException("Invalid file type.");
        }

        // Try reading the image
        BufferedImage image = ImageIO.read(file.getInputStream());
        if (image == null) {
            throw new IllegalArgumentException("File is not a valid image.");
        }

        // You can now process or save the image
        // e.g., resize, store to Cloudinary, etc.
    }

}
