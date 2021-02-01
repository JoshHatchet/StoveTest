
public enum Setting {
	OFF("---"), LOW("--+"), MEDIUM("-++"), HIGH("+++");
	
	private String string;

	Setting(String string) {
		this.string = string;
	}
	public String toString() {
		return string; 
	}
}
	
