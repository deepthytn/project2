package model;

import java.io.Serializable;

import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;


public class UploadFile implements Serializable{
	
	private String filename;
	@Transient
	private MultipartFile image;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	
	
}
