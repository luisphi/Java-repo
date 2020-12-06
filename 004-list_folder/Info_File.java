/**
 * 
 * @author luispazymino
 * @description Clase con los datos de un archivo
 *
 */

public class Info_File {
	String name;
	String path;
	Long lastModified;
	String extension;
	
	public Info_File(String name, String path, Long lastModified, String extension) {
		super();
		this.name = name;
		this.path = path;
		this.lastModified = lastModified;
		this.extension = extension;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Long getLastModified() {
		return lastModified;
	}

	public void setLastModified(Long lastModified) {
		this.lastModified = lastModified;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}
	
}
