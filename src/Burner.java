
public class Burner {
	
	public final static int TIME_DURATION = 2;
	Setting mySetting = Setting.OFF;
	Temperature myTemperature = Temperature.COLD;
	
	
	public enum Temperature{
		BLAZING, HOT, WARM, COLD;
		
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
	
	
	
	
	
	
	
}
