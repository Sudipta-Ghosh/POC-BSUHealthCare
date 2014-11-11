package com.java.tcs.healthcare.vo;


import java.io.InputStream;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


// TODO: Auto-generated Javadoc
/**
 * The Class FileTO.
 */
@JsonIgnoreProperties({"content"})
public class FileTO {
	
	

	/** The file name. */
	private String fileName;
	
	/** The file size. */
	private String fileSize;
	
	/** The file type. */
	private String fileType;
	
	/** The twitter. */
	private String twitter;

	
	/** The content. */
	private InputStream content;
	
	
	
	/**
	 * Gets the file name.
	 *
	 * @return the file name
	 */
	public String getFileName() {
		return fileName;
	}
	
	/**
	 * Sets the file name.
	 *
	 * @param fileName the new file name
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * Gets the file size.
	 *
	 * @return the file size
	 */
	public String getFileSize() {
		return fileSize;
	}
	
	/**
	 * Sets the file size.
	 *
	 * @param fileSize the new file size
	 */
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	
	/**
	 * Gets the file type.
	 *
	 * @return the file type
	 */
	public String getFileType() {
		return fileType;
	}
	
	/**
	 * Sets the file type.
	 *
	 * @param fileType the new file type
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	public InputStream getContent(){
		return this.content;
	}
	
	/**
	 * Sets the content.
	 *
	 * @param content the new content
	 */
	public void setContent(InputStream content){
		this.content = content;
	}
	
	/**
	 * Gets the twitter.
	 *
	 * @return the twitter
	 */
	public String getTwitter(){
		return this.twitter;
	}
	
	/**
	 * Sets the twitter.
	 *
	 * @param twitter the new twitter
	 */
	public void setTwitter(String twitter){
		this.twitter = twitter;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FileMeta [fileName=" + fileName + ", fileSize=" + fileSize
				+ ", fileType=" + fileType + "]";
	}
	
	
	
}
