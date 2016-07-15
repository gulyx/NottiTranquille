package it.ispw.efco.nottitranquille.view;

import it.ispw.efco.nottitranquille.controller.ReservationController;
import it.ispw.efco.nottitranquille.model.Location;
import it.ispw.efco.nottitranquille.model.Service;
import it.ispw.efco.nottitranquille.model.enumeration.ReservationType;
import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.util.Iterator;
import java.util.List;

/**
 * JavaBean for {@link Location}
 *
 * @author Claudio Pastorini Omar Shalby Federico Vagnoni Emanuele Vannacci
 */
public class LocationBean {

    private String id;

    private String name;

    private String description;

    private List<Interval> enablesDate;

    private List<Interval> booked;

    private List<Service> services;

    private Float price;

    private String type;

    private String address;

    /**
     * Populate the instance with information from the model layer.
     *
     * @param id matching a {@link Location}
     */
    public void populate(String id) {

        Long ID = new Long(id);

        ReservationController controller = ReservationController.getInstance();
        Location location = controller.findLocation(ID);
        services = location.getServices();
        name = location.getName();
        description = location.getDescription();
        enablesDate = location.getAvailableDate();
        booked = location.getBooked();
        price = location.getPrice();
        address = location.getStructure().getAddress().getCity() +
                " " + location.getStructure().getAddress().getAddress() +
                " " + location.getStructure().getAddress().getPostalcode();


        if (location.getType().getReservationType() == ReservationType.WithConfirm)
            this.type = "WithConfirm";
        else
            this.type = "Direct";

        this.id = id;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEnablesDate() {
        String enable = "";

        Iterator<Interval> availableInterval = enablesDate.iterator();
        while (availableInterval.hasNext()) {
            Interval interval = availableInterval.next();
            DateTime start = interval.getStart();
            DateTime end = interval.getEnd();

            enable += String.format(" {from : [ %d, %d, %d ] , to: [%d,%d,%d] }",
                    start.getYear(), start.getMonthOfYear() - 1, start.getDayOfMonth() - 1,
                    end.getYear(), end.getMonthOfYear() - 1, end.getDayOfMonth() - 1);


            if (availableInterval.hasNext())
                enable += " , ";
        }

        return enable;
    }

    public String getDisableDate() {
        String disable = "";

        Iterator<Interval> bookedIterator = booked.iterator();
        while (bookedIterator.hasNext()) {
            Interval interval = bookedIterator.next();
            DateTime start = interval.getStart();
            DateTime end = interval.getEnd();

            disable += String.format(" {from : [ %d, %d, %d ] , to: [%d,%d,%d] }",
                    start.getYear(), start.getMonthOfYear() - 1, start.getDayOfMonth() - 1,
                    end.getYear(), end.getMonthOfYear() - 1, end.getDayOfMonth() - 1);


            if (bookedIterator.hasNext())
                disable += " , ";
        }

        return disable;
    }

    public void setEnablesDate(List<Interval> enablesDate) {
        this.enablesDate = enablesDate;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Interval> getBooked() {
        return booked;
    }

    public void setBooked(List<Interval> booked) {
        this.booked = booked;
    }
}