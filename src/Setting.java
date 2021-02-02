/**
 * 
 * @author Joshua Bordick and Mark Shonbeck 
 * 2/1/21
 *
 */
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
	
