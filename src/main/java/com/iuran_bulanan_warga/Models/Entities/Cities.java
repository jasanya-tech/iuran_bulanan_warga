package com.iuran_bulanan_warga.Models.Entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cities", uniqueConstraints = {
  @UniqueConstraint(columnNames = "cityName")
})

public class Cities implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @NotBlank
  @Size(max = 50)
  private String cityName;

  @ManyToOne
  @JoinColumn(name = "province")
  private Provinces province;

  public Cities(String cityName, Provinces province) {
    this.cityName = cityName;
    this.province = province;
  }
}
