package com.unibuc.ro.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="order_review")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "review_id_Sequence")
    @SequenceGenerator(name = "review_id_Sequence", sequenceName = "REVIEW_ID_SEQ", allocationSize = 1)
    @Column(name = "review_id")
    private Long reviewId;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
}
