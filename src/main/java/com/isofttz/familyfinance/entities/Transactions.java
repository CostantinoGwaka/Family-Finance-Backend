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
@Table(name = "transaction")
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
//    'income' | 'expense'
    private String type;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Long amount;

    @Column(nullable = false)
    private String note;

    @Column(nullable = false)
    private String paymentMethod;

    @Column(nullable = false)
    private Boolean isRecurring;

    @Column(nullable = false)
    private String createdAt;

}
