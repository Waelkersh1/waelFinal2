package kersh.wael.waelfinal2;

import android.location.Location;

import java.util.ArrayList;
import java.util.Date;

public class Route {
    private ArrayList<Location> locations ;
    private Date startDate , endDate ;
    private String Type;//RUN WALK BICYCLE
    private double  length;

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Route{" +
                "locations=" + locations +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", Type='" + Type + '\'' +
                ", length=" + length +
                '}';
    }
}
