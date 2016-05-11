package lab9;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.annotation.PostConstruct;

public class AreaCheck implements Serializable{
	double x;
	double y;
	double r;
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

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public String getRes() {
		return res;
	}

	public void setRes(String res) {
		this.res = res;
	}

	private static final ArrayList<Point> pointList =
		new ArrayList<Point>();

	public ArrayList<Point> getPointList() {
		return pointList;
	}

	public String addAction(double r) {
		this.r = r;
		if(contains(x,y,r))
			this.res = "IN";
		else
			this.res = "OUT";

		Point point = new Point(this.x, this.y, this.r, this.res);
		pointList.add(point);

		return null;
	}

	public boolean contains(double x, double y, double r)
	{
		//rectangle
		if (x >= 0 &&
			x <= r &&
			y <= 0 &&
			y >= -r/2)
		return true;

		//triangle
		if (x <= 0 &&
			y <= 0 &&
			y >= -x-r/2)
		return true;

		//circle
		if (x <= 0 &&
			y >= 0 &&
			(x*x + y*y) <= r*r)
		return true;

		return false;
	}
}
