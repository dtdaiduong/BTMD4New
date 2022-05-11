package com.cg.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Tên thành phố bắt buộc nhập")
    @Size(min = 5, max = 30, message = "Tên thành phố nằm trong khoảng 5-30 ký tự")
    @Column(name = "city_name")
    private String cityName;

    @NotNull(message = "Tên quốc gia bắt buộc chọn")
    private String country;

    @NotNull(message = "Diện tích thành phố bắt buộc nhập")
    @Min(value = 1, message = "Diện tích thành phố phải lớn hơn 9")
    @Max(value = 10000, message = "Diện tích thành phố phải bé hơn 10.001")
    private int area;

    @NotNull(message = "Tổng dân số bắt buộc nhập")
    @DecimalMin(value = "10", message = "Tổng dân số phải lớn hơn 9")
    @DecimalMax(value = "1000000", message = "Tổng dân số phải bé hơn 1000001")
    private BigDecimal population;

    @NotNull(message = "GDP bắt buộc nhập")
    @Min(value = 1, message = "GDP bé nhất là 1")
    @Max(value = 10000, message = "GDP lớn nhất là 10000")
    private float gdp;

    @NotNull(message = "Mô tả về thành phố bắt buộc nhập")
    @Size(min = 10, message = "Mô tả quá ngắn")
    private String description;

    @Column(columnDefinition = "boolean default false")
    private boolean deleted;

    public City() {
    }

    public City(Long id, String cityName, String country, int area, BigDecimal population, float gdp, String description, Boolean deleted) {
        this.id = id;
        this.cityName = cityName;
        this.country = country;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
        this.description = description;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public BigDecimal getPopulation() {
        return population;
    }

    public void setPopulation(BigDecimal population) {
        this.population = population;
    }

    public float getGdp() {
        return gdp;
    }

    public void setGdp(float gdp) {
        this.gdp = gdp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
