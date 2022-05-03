package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Country {
    private String id; //data[4]
    private String name; // data[0]

    public String toString() {
        final StringBuilder sb = new StringBuilder("Country{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }


}
