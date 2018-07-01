package nl.springMvc.temp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DataTablesColumns {

    private Map<Integer, String> columns;

    public DataTablesColumns(String ...names){
        columns = new HashMap<>();
        List<String> namesList = Arrays.asList(names);
        namesList.stream().forEach(x -> columns.put(namesList.indexOf(x), x));
    }

    public Map<Integer, String> getColumns() {
        return columns;
    }

    public void setColumns(Map<Integer, String> columns) {
        this.columns = columns;
    }
}
