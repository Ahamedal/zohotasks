package virtualclassroom;

public class Materials {
private String materialType;
private String subject;
private String fileSize;
private long postTim;
private long modifiedTime;
private int userId;
public String getMaterialType() {
	return materialType;
}
public void setMaterialType(String materialType) {
	this.materialType = materialType;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getFileSize() {
	return fileSize;
}
public void setFileSize(String fileSize) {
	this.fileSize = fileSize;
}
public long getPostTim() {
	return postTim;
}
public void setPostTim(long postTim) {
	this.postTim = postTim;
}
public long getModifiedTime() {
	return modifiedTime;
}
public void setModifiedTime(long modifiedTime) {
	this.modifiedTime = modifiedTime;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
@Override
public String toString() {
	return "[materialType=" + materialType + "\nfileSize=" + fileSize + "\npostTim=" + postTim
			+ "\nmodifiedTime=" + modifiedTime + "\nuserId=" + userId + "]";
}



}
