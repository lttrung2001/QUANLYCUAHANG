package quanlycuahang.bean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.multipart.MultipartFile;

public class UploadFile {
	public String basePath;

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
	
	public String defaultName() {
		return "/resources/my_image/default.png";
	}
	
	public String setFileName(MultipartFile file) {
		String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss"));
		return date + file.getOriginalFilename();
	}
}
