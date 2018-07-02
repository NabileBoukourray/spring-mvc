package nl.springMvc.form;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class FormModelAttribute {

    private String naam;
    private String bedrijf;
    private String startdatum;
    private String einddatum;
    private List<String> options;


    public FormModelAttribute() {
    }

    public FormModelAttribute(String naam, String bedrijf, String startdatum, String einddatum, List<String> options) {
        this.naam = naam;
        this.bedrijf = bedrijf;
        this.startdatum = startdatum;
        this.einddatum = einddatum;
        this.options = options;

    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getBedrijf() {
        return bedrijf;
    }

    public void setBedrijf(String bedrijf) {
        this.bedrijf = bedrijf;
    }

    public String getStartdatum() {
        return startdatum;
    }

    public void setStartdatum(String startdatum) {
        this.startdatum = startdatum;
    }

    public String getEinddatum() {
        return einddatum;
    }

    public void setEinddatum(String einddatum) {
        this.einddatum = einddatum;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "FormModelAttribute{" +
                "naam='" + naam + '\'' +
                ", bedrijf='" + bedrijf + '\'' +
                ", startdatum='" + startdatum + '\'' +
                ", einddatum='" + einddatum + '\'' +
                ", options=" + options.toString() +
                '}';
    }
}
