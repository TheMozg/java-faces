package lab9;
import java.util.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImgGenerator
{
    private static final double ImageResolutionR = 8;
    private static final int   PointRadius = 15;


    public static BufferedImage genImage(ArrayList<Point> items, double width, double height, double R)
    {
        BufferedImage result;

        int r_px;

        r_px = (int) ((R * height) / ImageResolutionR);

        result = new BufferedImage((int) width, (int) height, BufferedImage.TYPE_INT_RGB);
        Graphics g = result.createGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, (int) width, (int) height);

        paintArea(g, (int) width, (int) height, r_px);
        paintAxes(g, (int) width, (int) height, r_px);
        paintPoints(g, items, (int)width, (int)height, R);

        return result;
    }

    static void paintAxes(Graphics g, int width, int height, int R)
    {
        int XCenter = width/2;
        int YCenter = height/2;
        int HalfR = R/2;

        g.setColor(Color.BLACK);
        g.drawLine(0, YCenter, 2*XCenter,YCenter);
        g.drawLine(XCenter, 0, XCenter, 2*YCenter);

        g.drawLine(XCenter - R, YCenter + 5, XCenter - R, YCenter - 5);
        g.drawLine(XCenter + R, YCenter - 5, XCenter + R, YCenter + 5);
        g.drawLine(XCenter + 5, YCenter + R, XCenter - 5, YCenter + R);
        g.drawLine(XCenter + 5, YCenter - R, XCenter - 5, YCenter - R);

        g.drawLine(XCenter - HalfR, YCenter + 5, XCenter - HalfR, YCenter - 5);
        g.drawLine(XCenter + HalfR, YCenter - 5, XCenter + HalfR, YCenter + 5);
        g.drawLine(XCenter + 5, YCenter + HalfR, XCenter - 5, YCenter + HalfR);
        g.drawLine(XCenter + 5, YCenter - HalfR, XCenter - 5, YCenter - HalfR);
    }

    static void paintArea(Graphics g, int width, int height, int R)
    {
        int xc = width/2;
        int yc = height/2;
        
        g.setColor(Color.GRAY);

        g.fillArc(xc - R/2, yc - R/2, R, R, -270, 90);
        g.fillRect(xc, yc, R, R/2);
        g.fillPolygon(getTrianglePolygon(width, height, R));
    }

    static void paintPoints(Graphics g,ArrayList<Point> items, int width, int height, double R)
    {
        for(Point item : items)
        {
            Color color = (item.res == "IN" ? Color.GREEN : Color.RED);
            g.setColor(color);

            int item_y, item_x;

            item_y = (int)((item.getY()*height)/ImageResolutionR) +7;
            item_x = (int)((item.getX()*height)/ImageResolutionR)-7;

            item_x = width/2 + item_x;
            item_y = height/2 - item_y;


            g.setColor(color);
            g.fillOval(item_x , item_y, PointRadius, PointRadius);
        }
    }

    static Polygon getTrianglePolygon(int width, int height, int R)
    {
        Polygon result = null;
        int num = 3;
        int[] x_points = new int[num];
        int[] y_points = new int[num];

        x_points[0] = width/2;
        y_points[0] = height/2;

        x_points[1] = width/2 - R/2;
        y_points[1] = height/2;

        x_points[2] = width/2;
        y_points[2] = height/2 + R/2;

        result = new Polygon(x_points,y_points,num);
        return result;
    }
}