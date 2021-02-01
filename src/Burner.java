
public class Burner {
	private int timer = 0;
	public final static int TIME_DURATION = 2;
	Setting mySetting = Setting.OFF;
	Temperature myTemperature = Temperature.COLD;
	
	
	public enum Temperature{
		BLAZING("BLAZING"), HOT("HOT"), WARM("WARM"), COLD("COLD");
		private String string;
		Temperature (String string){
			this.string = string;
		}
		public String toString() {
			return string;
		}
	
		
	}
	public String getTemperature() {
		return mySetting.toString();
	}
	
	public void minusButton() {
		Setting current = mySetting;
		switch(current) {
		case OFF:
			break;
		case LOW:
			mySetting = Setting.OFF;
			break;
		case MEDIUM:
			mySetting = Setting.LOW;
			break;
		case HIGH:
			mySetting = Setting.MEDIUM;
			break;
		}
	}
	
	public void plusButton() {
		Setting curr = mySetting;
		switch(curr) {
		case OFF:
			mySetting = Setting.LOW;
			break;
		case LOW:
			mySetting = Setting.MEDIUM;
			break;
		case MEDIUM:
			mySetting = Setting.HIGH;
			break;
		case HIGH:
			break;
		}
	}
	
	
	public void display() {
		Setting current = mySetting;
		switch(current) {
		case OFF:
			System.out.println("[" + this.mySetting + "].....cooool");
			break;
		case LOW:
			System.out.println("[" + this.mySetting + "].....warm");
			break;
		case MEDIUM:
			System.out.println("[" + this.mySetting + "].....CAREFUL");
			break;
		case HIGH:
			System.out.println("[" + this.mySetting + "].....VERY HOT! DON'T TOUCH!");
			break;
		}
	}
	
	public void updateTemperature() {
		//todo
	}
	
	
	
}
