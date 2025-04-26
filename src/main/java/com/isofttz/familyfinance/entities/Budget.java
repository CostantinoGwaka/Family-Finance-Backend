package com.isofttz.familyfinance.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "budgets")
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String categoryId;

    @Column(nullable = false)
//    Month/year
    private String month;

    @Column(nullable = false)
    private Long amount;

    @Column(nullable = false)
    private String createdAt;
}
