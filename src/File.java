
public class File {
	private String fileName;
	private String fileType;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) throws IllegalArgumentException{
		if(fileName == null || fileName.trim().isEmpty()) throw new IllegalArgumentException("fileName cant be null or empty");
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) throws IllegalArgumentException{
		if(fileType == null || fileType.trim().isEmpty()) throw new IllegalArgumentException("fileType cant be null or empty");
		this.fileType = fileType;
	}
	public File(String fileName, String fileType) {
		setFileName(fileName);
		setFileType(fileType);
	}
	
	public String toString() {
		return "FileName: " + getFileName() + ", fileType: " + getFileType();
	}
}
