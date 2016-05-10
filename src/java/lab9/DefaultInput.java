package lab9;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.util.*;
import javax.faces.model.SelectItem;
import javax.annotation.*;

@ManagedBean(name = "default")
@SessionScoped
public class DefaultInput implements Serializable {

  private int xval;
  private double yval;
  private double zval;


  private List<SelectItem> xvals;

//For X
  public int getXval() {
    return xval;
  }

  public void setXval(int xval) {
    this.xval = xval;
  }

  public List<SelectItem> getxvals() {
    return xvals;
  }

//For Z
  public double getYval() {
    return yval;
  }

  public void setYval(double yval) {
    this.yval = yval;
  }

//For Z
  public double getZval() {
    return zval;
  }

  public void setZval(double zval) {
    this.zval = zval;
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
}
