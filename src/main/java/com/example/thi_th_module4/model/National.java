package com.example.thi_th_module4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.util.List;

@Entity
@Table(name = "nationals")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class National {@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
    private String name;
    @OneToMany(mappedBy = "nationals", fetch = FetchType.LAZY)
    @Where(clause = "deleted <> 'DELETED'")
    private List<City> cities;


}
