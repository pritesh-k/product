package com.app.product.model.api;

import java.util.Objects;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Attachment
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-17T09:26:55.271+05:30[Asia/Calcutta]")
public class Attachment {
	@JsonProperty("fileId")
	private UUID fileId = null;

	@JsonProperty("fileName")
	private String fileName = null;

	@JsonProperty("aspectRatio")
	private String aspectRatio = null;

	@JsonProperty("thumbnail")
	private String thumbnail = null;

	@JsonProperty("fileType")
	private String fileType = null;

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	@JsonProperty("type")
	private String type = null;

	public Attachment fileId(UUID fileId) {
		this.fileId = fileId;
		return this;
	}

	/**
	 * Get type
	 * 
	 * @return type
	 **/

	@Valid
	public String getType() {
		return type;
	}

	public String getAspectRatio() {
		return aspectRatio;
	}

	public void setAspectRatio(String aspectRatio) {
		this.aspectRatio = aspectRatio;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Attachment type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * Get fileId
	 * 
	 * @return fileId
	 **/
	@Valid
	public UUID getFileId() {
		return fileId;
	}

	public void setFileId(UUID fileId) {
		this.fileId = fileId;
	}

	public Attachment fileName(String fileName) {
		this.fileName = fileName;
		return this;
	}

	/**
	 * Get fileName
	 * 
	 * @return fileName
	 **/
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Attachment attachment = (Attachment) o;
		return Objects.equals(this.fileId, attachment.fileId) && Objects.equals(this.fileName, attachment.fileName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(fileId, fileName);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Attachment {\n");

		sb.append("    fileId: ").append(toIndentedString(fileId)).append("\n");
		sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
		sb.append("fileType").append(toIndentedString(fileType)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
