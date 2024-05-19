package org.sau.sbweb.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="account")
public class Account {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(name = "branch")
        private String branch;

        @Column(name = "balance")
        private double balance;

        @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
        private Set<Depositor> depositors = new HashSet<>();
}
