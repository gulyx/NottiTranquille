package it.ispw.efco.nottitranquille.controller;

import it.ispw.efco.nottitranquille.model.CatalogueDAO;
import it.ispw.efco.nottitranquille.model.Location;
import it.ispw.efco.nottitranquille.model.Request;
import it.ispw.efco.nottitranquille.view.SearchBean;
import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.util.*;

/**
 * @author Claudio Pastorini Omar Shalby Federico Vagnoni Emanuele Vannacci
 */
public class FilteredSearch {

    /**
     * Default constructor
     */
    public FilteredSearch() {
    }

    public static List<Location> getListOfStructures(SearchBean searchBean) throws Exception {
        if (searchBean.getCheckin().isAfter(searchBean.getCheckout()) && searchBean.getCheckin().isBeforeNow()) {
            throw new Exception(); //TODO to improve
        }
        int maxPrice = 0; //0 stands for infinite
        if (searchBean.getPricerange().equals("Fino a 100 euro")) {
            maxPrice = 100;
        }
        if (searchBean.getPricerange().equals("Fino a 200 euro")) {
            maxPrice = 200;
        }
        if (searchBean.getPricerange().equals("Fino a 500 euro")) {
            maxPrice = 500;
        }
        Interval inteval = new Interval(searchBean.getCheckin(),searchBean.getCheckout());
        CatalogueDAO catalogueDAO = new CatalogueDAO();
        List<Request> result = catalogueDAO.selectAcceptedRequests(searchBean.getNation(),searchBean.getCity());
        List<Location> final_result = new ArrayList<Location>();
        for (Request candidate : result) {
            for (Location location : candidate.getStructure().getLocations()) {
                if (location.isAvailable(inteval)) { //TODO price check to be added
                    final_result.add(location);
                }
            }
        }
        return final_result;
    }



}