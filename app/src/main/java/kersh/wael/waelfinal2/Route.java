package kersh.wael.waelfinal2;

import android.location.Location;
import android.os.Parcelable;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class Route {
    private ArrayList<Location> locations=new ArrayList<>(); ;
    private Date startDate , endDate ;
    private String Type;//RUN WALK BICYCLE
    private double  length;
    private String key;
    private String Owner ;
    //TreeMap<Integer,String> pics=new TreeMap<>() ;

    public Route() {

        //locations.add(new Location())
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

//    public TreeMap<Location, String> getPics() {
//        return pics;
//    }
//
//    public void setPics(TreeMap<Location, String> pics) {
//        this.pics = pics;
//    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

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
