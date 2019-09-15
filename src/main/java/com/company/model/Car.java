package com.company.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "cars")
@Table(name = "cars")
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @NotBlank(message = "Model is mandatory")
  @Column(name = "model")
  private String model;

  @NotBlank(message = "Mark is mandatory")
  @Column(name = "mark")
  private String mark;

  @Column(name = "color")
  private String color;

  @Column(name = "bodyType")
  private String bodyType;

  @Column(name = "price")
  private long price;

  @Column(name = "year")
  private long year;

  public Car() {
  }

  public Car(String model, String mark) {
    this.model = model;
    this.mark = mark;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getMark() {
    return mark;
  }

  public void setMark(String mark) {
    this.mark = mark;
  }

  public String getBodyType() {
    return bodyType;
  }

  public void setBodyType(String bodyType) {
    this.bodyType = bodyType;
  }

  public long getPrice() {
    return price;
  }

  public void setPrice(long price) {
    this.price = price;
  }

  public long getYear() {
    return year;
  }

  public void setYear(long year) {
    this.year = year;
  }

}