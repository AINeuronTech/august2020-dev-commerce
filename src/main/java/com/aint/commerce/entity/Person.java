package com.aint.commerce.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Person")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;
    @Column(name = "personName")
    private String personName;
    @Column(name = "personPhoneNumber")
    private String personPhoneNumber;
    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    @JsonIgnore
    public List<Product> products;

}
