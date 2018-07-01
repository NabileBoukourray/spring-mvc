package nl.springMvc.customers;

import nl.springMvc.entity.Customer;
import java.util.List;

class DataTableObject {

    private int sEcho;
    private int iTotalRecords;
    private int iTotalDisplayRecords;
    private int iSortCol_0;
    private String sSortDir_0;
    private List<Customer> aaData;

    public DataTableObject() {
    }

    public DataTableObject(int sEcho, int iTotalRecords, int iTotalDisplayRecords, int iSortCol_0, String sSortDir_0) {
        this.sEcho = sEcho;
        this.iTotalRecords = iTotalRecords;
        this.iTotalDisplayRecords = iTotalDisplayRecords;
        this.iSortCol_0 = iSortCol_0;
        this.sSortDir_0 = sSortDir_0;
        this.aaData = aaData;
    }

    public int getsEcho() {
        return sEcho;
    }

    public void setsEcho(int sEcho) {
        this.sEcho = sEcho;
    }

    public int getiTotalRecords() {
        return iTotalRecords;
    }

    public void setiTotalRecords(int iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }

    public int getiTotalDisplayRecords() {
        return iTotalDisplayRecords;
    }

    public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    public List<Customer> getAaData() {
        return aaData;
    }

    public void setAaData(List<Customer> aaData) {
        this.aaData = aaData;
    }

    public int getiSortCol_0() {
        return iSortCol_0;
    }

    public void setiSortCol_0(int iSortCol_0) {
        this.iSortCol_0 = iSortCol_0;
    }

    public String getsSortDir_0() {
        return sSortDir_0;
    }

    public void setsSortDir_0(String sSortDir_0) {
        this.sSortDir_0 = sSortDir_0;
    }

    @Override
    public String toString() {
        return "{" +
                "sEcho:" + sEcho +
                ", iTotalRecords:" + iTotalRecords +
                ", iTotalDisplayRecords:" + iTotalDisplayRecords +
                ", iSortCol_0:" + iSortCol_0 +
                ", sSortDir_0:" + sSortDir_0 +
                ", aaData:" + aaData +
                '}';
    }
}
