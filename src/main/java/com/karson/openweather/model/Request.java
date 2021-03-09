package com.karson.openweather.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Request {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Length(min = 5, message = "Cannot be less than 5 digits")
  @Length(max = 5, message = "Cannot be more than 5 digits")
  @NotEmpty(message = "Cannot be empty")
  private String zip;

}
