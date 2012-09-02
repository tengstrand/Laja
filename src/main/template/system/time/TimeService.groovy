
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeService {
	private timeFormat = "hh:mm:ss"
	private dateFormat = "yyyy-MM-dd"
	private datetimeFormat = "yyyy-MM-dd hh:mm"
	
	public void setTimeFormat(String format) {
		this.timeFormat = format
	}
	
	public void setDateFormat(String format) {
		this.dateFormat = format
	}
	
	public void setDatetimeFormat(String format) {
		this.datetimeFormat = format
	}
		
	String time() {
		return format(timeFormat)
	}
	
	String date() {
		return format(dateFormat)
	}

	String datetime() {
		return format(datetimeFormat)
	}
	
	String format(String formatting) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(formatting)
		return dateFormat.format(new Date())
	}
}
