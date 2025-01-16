package controllers.modazluzropa.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "stock", schema = "modasluz")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_talla", nullable = false)
    private Talla talla;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Productos producto;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;
}
