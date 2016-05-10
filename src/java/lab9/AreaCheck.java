package lab9;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="areaCheck")
@SessionScoped
public class AreaCheck implements Serializable{
	String x;
	String y;
	String r;
	String res;

  private List<SelectItem> xvals;

  public List<SelectItem> getXvals() {
    return xvals;
  }

  @PostConstruct
  public void init() {
    xvals = new ArrayList<SelectItem>();
    xvals.add(new SelectItem(-5));
    xvals.add(new SelectItem(-4));
    xvals.add(new SelectItem(-3));
    xvals.add(new SelectItem(-2));
    xvals.add(new SelectItem(-1));
    xvals.add(new SelectItem(0));
    xvals.add(new SelectItem(1));
    xvals.add(new SelectItem(2));
    xvals.add(new SelectItem(3));
  }

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public String getR() {
		return r;
	}

	public void setR(String r) {
		this.r = r;
	}

	public String getRes() {
		return res;
	}

	public void setRes(String res) {
		this.res = res;
	}

	private static final ArrayList<Point> pointList =
		new ArrayList<Point>(Arrays.asList(

		new Point("A0001", "Intel CPU", "700.00", "1"),
		new Point("A0002", "Harddisk 10TB", "500.00", "2"),
		new Point("A0003", "Dell Laptop", "11600.00", "8"),
		new Point("A0004", "Samsung LCD", "5200.00", "3"),
		new Point("A0005", "A4Tech Mouse", "100.00", "10")
	));

	public ArrayList<Point> getPointList() {
		return pointList;
	}

	public String addAction(String r) {
		Point point = new Point(this.x, this.y, r, this.res);
		if(point.x == null)
			point.x = "(empty)";
		if(point.y == null)
			point.y = "(empty)";
		if(point.r == null)
			point.r = "(empty)";
		point.res = "WRONG INPUT";
		/*if(inputIsCorrect(point.x, point.y, point.r)){
			if(contains(x,y,r))
				point.res = "IN";
			else
				point.res = "OUT";
		}*/
		pointList.add(point);

		return null;
	}

	public String deleteAction(Point point) {
		pointList.remove(point);
		return null;
	}

    public boolean inputIsCorrect(String x, String y, String r){
		return false;
	}

	public boolean contains(double x, double y, double r)
	{
		//rectangle
		if (x <= 0 &&
				x >= -r &&
				y <= 0 &&
				y >= -r/2)
		return true;

		//triangle
		if (x >= 0 &&
				y <= 0 &&
				y >= 2*x-r)
		return true;

		//circle
		if (x >= 0 &&
				y >= 0 &&
				(x*x + y*y) <= r*r)
		return true;

		return false;
	}

	public static class Point{
		String x;
		String y;
		String r;
		String res;

		public Point(String x, String y, String r, String res) {
			this.x = x;
			this.y = y;
			this.r = r;
			this.res = res;
		}

		public String getX() {
			return x;
		}
		public void setX(String x) {
			this.x = x;
		}
		public String getY() {
			return y;
		}
		public void setY(String y) {
			this.y = y;
		}
		public String getR() {
			return r;
		}
		public void setR(String r) {
			this.r = r;
		}
		public String getRes() {
			return res;
		}
		public void setRes(String res) {
			this.res = res;
		}
	}
}
