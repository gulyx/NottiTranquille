package it.ispw.efco.nottitranquille.model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.*;


/**
 * @author Claudio Pastorini Omar Shalby Federico Vagnoni Emanuele Vannacci
 */
@Entity
@DiscriminatorValue("manager")
@SuppressWarnings("JpaDataSourceORMInspection")
public class Manager extends Role implements Applicant {

    @OneToMany
    @JoinTable(name = "Manager_Reservation",
            joinColumns = {@JoinColumn(name = "ManagerId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "ReservationId", referencedColumnName = "id")})
    @Cascade(CascadeType.ALL)
    private List<Reservation> toApprove;

    /**
     * Default constructor
     */
    public Manager() {
        toApprove = new ArrayList<Reservation>();
    }

    public boolean addReservationToApprove(Reservation reservation) {
        for (Reservation r : toApprove)
            if (r.equals(reservation))
                return false;

        toApprove.add(reservation);
        return true;
    }

    public boolean deleteReservationToApprove(Reservation reservation) {
        Iterator list = toApprove.iterator();
        while (list.hasNext()) {
            Reservation r = (Reservation) list.next();

            if (r.equals(reservation)) {
                list.remove();
                return true;
            }
        }

        return false;
    }

    public void update(Manager toUpdate) {
        this.toApprove = toUpdate.getToApprove();
    }

    public List<Reservation> getToApprove() {
        return toApprove;
    }
}