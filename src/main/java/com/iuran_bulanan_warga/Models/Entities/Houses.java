package com.iuran_bulanan_warga.Models.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "houses")

public class Houses implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Size(max = 50)
  private String houseName;

  private String street;

  private Integer houseNumber;

  private String rt;

  private String rw;

  @CreatedDate
  private Date created_at = new Date();

  @ManyToOne
  @JoinColumn(name = "owner", referencedColumnName = "id")
  // Column pemilik rumah
  private Users owner;

  @ManyToOne
  @JoinColumn(name = "city")
  private Cities city;

  @OneToMany
  @JoinColumn(name = "house", referencedColumnName = "id")
  // Column rumah
  private Set<ImageHouses> pictures;

  @ManyToMany
  @JoinTable(name = "house_users", joinColumns = @JoinColumn(name = "house_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
  // Column penghuni rumah
  private Set<Users> occupants = new HashSet<>();

  @ManyToMany
  @JoinTable(name = "monthlyDues", joinColumns = @JoinColumn(name = "houseId"), inverseJoinColumns = @JoinColumn(name = "duesTypeId"))
  private Set<DuesType> monthlyDues = new HashSet<>();

  public Houses(String houseName, String street, Integer houseNumber, String rt, String rw, Users owner, Cities city) {
    this.houseName = houseName;
    this.street = street;
    this.houseNumber = houseNumber;
    this.rt = rt;
    this.rw = rw;
    this.owner = owner;
    this.city = city;
  }
}
