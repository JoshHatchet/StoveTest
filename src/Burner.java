
public class Burner {
	private int timer = 0;
	public final static int TIME_DURATION = 2;
	Setting mySetting = Setting.OFF;
	Temperature myTemperature = Temperature.COLD;
	private int status = 0;
	private int settingStatus = 0;
	
	
	/**
	 * Represents Temperature
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
		timer = TIME_DURATION;
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
		timer = TIME_DURATION;
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
	public void getStatus() {
		
		if(myTemperature == Temperature.COLD) {
			status = 1;
		} 
		if(myTemperature == Temperature.WARM) {
			status = 2;
		} 
		if(myTemperature == Temperature.HOT) {
			status = 3;
		} 
		if(myTemperature == Temperature.BLAZING) {
			status = 4;
		} 
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
	public void updateTemperature() {
		Temperature current = myTemperature;
		if(timer == 0) {
			getStatus();
			switch(current) {
			case COLD:
				if(mySetting == Setting.OFF) {
					break;
				}
				myTemperature = Temperature.WARM;
				break;
			case WARM:
				if(settingStatus == 1) {
					myTemperature = Temperature.COLD;
				} 
				if(settingStatus == 2) {
					break;
				}
				if(settingStatus > 2) {
					myTemperature = Temperature.HOT;
				}
				break;
			case HOT:
				if(settingStatus < 3) {
					myTemperature = Temperature.WARM;
				} 
				if(settingStatus == 3) {
					break;
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
		if(timer != 0) {
			timer--;
		}
	}
	
	
	
}
