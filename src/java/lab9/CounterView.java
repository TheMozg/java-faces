package lab9;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@ManagedBean(name = "counterView")
@ViewScoped
public class CounterView implements Serializable {

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
