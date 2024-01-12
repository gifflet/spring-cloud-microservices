package dev.gifflet.springcloudmicroservices.cards.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class ClientCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String cpf;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    private BigDecimal income;
}
