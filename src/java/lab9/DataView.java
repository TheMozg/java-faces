package lab9;

import java.io.Serializable;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DataView implements Serializable {

    private DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private Date date = new Date();
    private String dateString = dateFormat.format(date);

    public String getDateString() {
        return dateString;
    }

    public void refreshDate() {
      date = new Date();
      dateString = dateFormat.format(date);
    }
}
