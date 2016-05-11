package lab9;

	public class Point{
		double x;
		double y;
		double r;
		String res;

		public Point(double x, double y, double r, String res) {
			this.x = x;
			this.y = y;
			this.r = r;
			this.res = res;
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
	}
