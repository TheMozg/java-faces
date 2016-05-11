package lab9;
import java.util.*;

//import com.sun.msv.reader.Controller;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ApplicationScoped;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.SessionScoped;


@ManagedBean(name="ViewBean")
@SessionScoped
public class ViewBean implements Serializable
{

    @ManagedProperty(value="#{areaCheck}")
    private AreaCheck historyBean;

    public void setHistoryBean(AreaCheck historyBean) {
        this.historyBean = historyBean;
    }
    
    private StreamedContent image;

    private double imageWidht;

    private double imageHeight;

    @PostConstruct
    public void init()
    {
        imageWidht  = 400;
        imageHeight = 400;
    }


    public void setImage(StreamedContent image) {
        this.image = image;
    }

    public StreamedContent getImage() {
        setImage(gnImage());
        return image;
    }

    public void setImageWidht(double imageWidht) {
        this.imageWidht = imageWidht;
    }

    public void setImageHeight(double imageHeight) {
        this.imageHeight = imageHeight;
    }

    StreamedContent gnImage()
    {
        DefaultStreamedContent result = null;
        try
        {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ArrayList<Point> pointList = historyBean.getPointList();
            for(Point p : pointList){
                if(historyBean.contains(p.x,p.y,historyBean.getR()))
			        p.isInside = true;
		          else
			        p.isInside = false;
            }
            BufferedImage img = ImgGenerator.genImage(pointList, imageWidht, imageHeight, historyBean.getR());

            ImageIO.write(img, "png", os);

            result = new DefaultStreamedContent(new ByteArrayInputStream(os.toByteArray()), "image/png");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

        return result;
    }
}