package com.iuran_bulanan_warga.Models.Entities;

import com.iuran_bulanan_warga.Helpers.Entities.TypePicture;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ImageHouses")
public class ImageHouses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "house", referencedColumnName = "id")
    // Column rumah
    private Houses house;

    @NotBlank
    private String fileName;

    @NotBlank
    private String mimeType;

    @Enumerated(EnumType.STRING)
    private TypePicture typePicture;

    @Lob
    @Column(name = "source", columnDefinition = "MEDIUMBLOB")
    private byte[] source;

    private String path;

    public ImageHouses(Houses house, String fileName, String mimeType) {
        this.house = house;
        this.fileName = fileName;
        this.mimeType = mimeType;
    }
}