package it.ispw.efco.nottitranquille.model;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Claudio Pastorini Omar Shalby Federico Vagnoni Emanuele Vannacci
 */
@Entity
public class Structure {

    public Structure(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Structure(List<Service> services) {
        this.services = services;
    }

    public String getName() {
        return name;
    }

    public Address getStructureAddress() {
        return address;
    }

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String numberOfLocations;

    /**
     * 
     */
    @ElementCollection
    private Set<String> photos;

    /**
     * 
     */
    private String termsOfService;

    /**
     * 
     */
    private String termsOfCancellation;

    /**
     * 
     */
    private DateTime checkIn;

    /**
     * 
     */
    private DateTime checkOut;

    @ManyToOne
    private Person managedBy;

    @ManyToOne
    //TODO Make List<Person>
    private Person owner;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    private Address address;

    @ManyToOne
    private StructureType type;

    @OneToMany
    private List<Service> services;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Location> locations = new ArrayList<Location>();

    public void setRequest(Request request) {
        this.request = request;
    }

    @OneToOne(optional=false, mappedBy="structure")
    private Request request;

    public Structure() {
    }

    @Override
    public String toString() {
        return "Structure{" +
                "name='" + name + '\'' +
                ", numberOfLocations='" + numberOfLocations + '\'' +
                ", photos=" + photos +
                ", termsOfService='" + termsOfService + '\'' +
                ", termsOfCancellation='" + termsOfCancellation + '\'' +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", managedBy=" + managedBy +
                ", owner=" + owner +
                ", address=" + address +
                ", type=" + type +
                ", services=" + services +
                ", id=" + id +
                '}';
    }

    public void addLocation(Location location) {
        this.locations.add(location);
    }

    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setNumberOfLocations(String numberOfLocations) {
        this.numberOfLocations = numberOfLocations;
    }

    public void setTermsOfService(String termsOfService) {
        this.termsOfService = termsOfService;
    }

    public void setTermsOfCancellation(String termsOfCancellation) {
        this.termsOfCancellation = termsOfCancellation;
    }

    public void setCheckIn(DateTime checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(DateTime checkOut) {
        this.checkOut = checkOut;
    }

    public void setManagedBy(Person managedBy) {
        this.managedBy = managedBy;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void setType(StructureType type) {
        this.type = type;
    }

    public Request getRequest() {
        return request;
    }
}