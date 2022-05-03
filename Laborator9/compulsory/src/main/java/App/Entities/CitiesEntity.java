package App.Entities;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "CITIES", schema = "STUDENT")
@NamedQueries({
        @NamedQuery(name = "City.findAll",
                query = "select e from CitiesEntity e order by e.name"),
})
public class CitiesEntity {
    @Basic
    @Column(name = "NAME")
    private String name;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Basic
    @Column(name = "ID")
    private String id;
    @Basic
    @Column(name = "CODE")
    private BigInteger code;
    @Basic
    @Column(name = "LATITUDE")
    private Double latitude;
    @Basic
    @Column(name = "LONGITUDE")
    private Double longitude;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigInteger getCode() {
        return code;
    }

    public void setCode(BigInteger code) {
        this.code = code;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }


    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CitiesEntity that = (CitiesEntity) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        return result;
    }
}
