package nl.springMvc.customers;

public abstract class DTColumns {

    enum CUSTOMERSCOL{
        CUSTOMER_ID (0, "customer_id"),
        STORE_ID (1,"store_id"),
        FIRST_NAME(2,"first_name"),
        LAST_NAME(3,"last_name"),
        EMAIL(4,"email"),
        ADDRESS_ID(5, "address_id"),
        ACTIVE(6,"active"),
        CREATE_DATE(7,"create_date"),
        LAST_UPDATE(8,"last_update");

        private int id;
        private String name;

        CUSTOMERSCOL(int id, String name){
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static CUSTOMERSCOL getById(int id)
        {
            for (CUSTOMERSCOL e : CUSTOMERSCOL.values())
            {
                if (id == e.getId()) return e;
            }

            return CUSTOMER_ID;
        }
    }


}
