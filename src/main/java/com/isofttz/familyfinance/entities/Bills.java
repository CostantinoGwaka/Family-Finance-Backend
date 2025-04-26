package com.isofttz.familyfinance.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bills")
public class Bills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Long amount;

    @Column(nullable = false)
    private String dueDate;

    @Column(nullable = false)
    private Boolean isPaid;

    @Column(nullable = false)
//    'monthly' | 'weekly' | 'none'
    private String repeatInterval;

    @Column(nullable = false)
    private String createdAt;

}
