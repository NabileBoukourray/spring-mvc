package nl.springMvc.datatables;

public class CustomerDTO {

    private Integer customer_id ;
    private String first_name;
    private String last_name;
    private String email;

    public CustomerDTO() {
    }

    public CustomerDTO(Integer customer_id, String first_name, String last_name, String email) {
        this.customer_id = customer_id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
    }


    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customer_id=" + customer_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
