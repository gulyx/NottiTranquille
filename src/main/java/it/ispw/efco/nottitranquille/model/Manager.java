package it.ispw.efco.nottitranquille.model;

import it.ispw.efco.nottitranquille.model.enumeration.StructureType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Claudio Pastorini Omar Shalby Federico Vagnoni Emanuele Vannacci
 */
@Entity
@DiscriminatorValue("manager")
public class Manager extends Role {

    @OneToMany(mappedBy = "managedBy", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Structure> managedStructures;

    @OneToMany(mappedBy = "requestedBy", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Request> requests;

    /**
     * Default constructor
     */
    public Manager() {
        this.managedStructures = new ArrayList<Structure>();
        this.requests = new ArrayList<Request>();
    }


    public void addManagedStructure(Structure structure) {
        managedStructures.add(structure);
    }

    public void removeManagedStructure(Structure structure) {
        managedStructures.remove(structure);
    }

    public List<Structure> getManagedStructures() {
        return managedStructures;
    }

    public void addRequest(Request request) {
        requests.add(request);
    }

    public List<Request> getRequests() {
        return requests;
    }

    public List<Structure> getStructuresByType(StructureType type) {
        List<Structure> structuresByType = new ArrayList<Structure>();

        for (Structure structure : managedStructures) {
            if (structure.getType() == type) {
                structuresByType.add(structure);
            }
        }

        return structuresByType;
    }

}