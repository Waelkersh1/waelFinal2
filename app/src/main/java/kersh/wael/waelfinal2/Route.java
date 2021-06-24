package kersh.wael.waelfinal2;

import android.location.Location;

import java.util.ArrayList;
import java.util.Date;

/**
 * this class for route ,
 */
public class Route {

    /**
     * this array contain the locations of athlete
     */
    private ArrayList<Location> locations=new ArrayList<>();
    /**
     * start date : the beginning hour .
     * end date : the hour when he ends the workout .
     */
    private Date startDate , endDate ;
    /**
     * this is the type of the sport that the athlete wants to practice.
     */
    private String type;//RUN WALK BICYCLE
    /**
     * this is the distance of the route.
     */
    private double  length;
    /**
     * this is the id for the owner
     *
     */
    private String key;
    /**
     * the owner is someone who has a profile
     */
    private String Owner ;
    //TreeMap<Integer,String> pics=new TreeMap<>() ;


    private int Calories ;

    public int getCalories() {
        return Calories;
    }

    public void setCalories(int calories) {
        Calories = calories;
    }

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
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
                ", Type='" + type + '\'' +
                ", length=" + length +
                '}';
    }
}
