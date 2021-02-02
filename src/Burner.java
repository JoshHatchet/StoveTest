
public class Burner {
	private int timer = 0;
	public final static int TIME_DURATION = 2;
	Setting mySetting = Setting.OFF;
	Temperature myTemperature = Temperature.COLD;
	private int settingStatus = 0;
	
	/**
	 * Represents Temperature of burner
	 */
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
		return myTemperature.toString();
	}
	
	/**
	 * Lowers the Setting of the burner
	 */
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
		timer = TIME_DURATION;
	}
	
	/**
	 * Increases the Setting of the burner
	 */
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
		timer = TIME_DURATION;
	}
	
	/**
	 * Displays the setting and temperature of burner
	 */
	public void display() {
		Setting current = mySetting;
		switch(current) {
		case OFF:
			System.out.print("[" + this.mySetting + "]");
			break;
		case LOW:
			System.out.print("[" + this.mySetting + "]");
			break;
		case MEDIUM:
			System.out.print("[" + this.mySetting + "]");
			break;
		case HIGH:
			System.out.print("[" + this.mySetting + "]");
			break;
		}
		switch(myTemperature) {
		case COLD:
			System.out.println(".....cooool");
			break;
		case WARM:
			System.out.println(".....warm");
			break;
		case HOT:
			System.out.println(".....CAREFUL");
			break;
		case BLAZING:
			System.out.println(".....VERY HOT! DON'T TOUCH!");
			break;
		}
	}
	
	/**
	 * sets the setting to an integer, that way it can be used in inequalities
	 */
	public void getStatus() {
		if(mySetting == Setting.OFF) {
			settingStatus = 1;
		}
		if(mySetting == Setting.LOW) {
			settingStatus = 2;
		}
		if(mySetting == Setting.MEDIUM) {
			settingStatus = 3;
		}
		if(mySetting == Setting.HIGH) {
			settingStatus = 4;
		}
	}
	
	/**
	 * updates the temperature based on the current temperature and the setting
	 */
	public void updateTemperature() {
		Temperature current = myTemperature;
		if(timer == 1) {
			getStatus();
			switch(current) {
			case COLD:
				if(mySetting != Setting.OFF) {
					myTemperature = Temperature.WARM;
				}
				break;
			case WARM:
				if(settingStatus == 1) {
					myTemperature = Temperature.COLD;
				} 
				if(settingStatus > 2) {
					myTemperature = Temperature.HOT;
				}
				break;
			case HOT:
				if(settingStatus < 3) {
					myTemperature = Temperature.WARM;
				} 
				if(settingStatus > 3) {
					myTemperature = Temperature.BLAZING;
				}
				break;
			case BLAZING:
				if(settingStatus != 4) {
					myTemperature = Temperature.HOT;
				}
				break;
			}
			timer = TIME_DURATION;
		}
		else {
			timer--;
		}
	}
}
