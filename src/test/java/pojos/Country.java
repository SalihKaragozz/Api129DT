package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {

    private String name;
    private List<State> states;

    public Country() {
    }

    public Country(String name, List<State> states) {
        this.name = name;
        this.states = states;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", states=" + states +
                '}';
    }
}