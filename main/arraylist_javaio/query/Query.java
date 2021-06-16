package main.arraylist_javaio.query;

public class Query {
    private String search;
    private String output;

    public Query(String search, String output) {
        setSearch(search);
        setOutput(output);
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}

