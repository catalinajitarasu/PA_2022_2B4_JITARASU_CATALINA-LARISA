package model;

import dao.Database;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.management.ConstructorParameters;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@AllArgsConstructor
@Setter
@Getter
public class Country {
    private int id;
    private String name;
    private String code;
    private String continent;

    public String toString() {
        final StringBuilder sb = new StringBuilder("Country{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", code=").append(code);
        sb.append(", continent=").append(continent);
        sb.append('}');
        return sb.toString();
    }


}
