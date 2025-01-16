package controllers.modazluzropa.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "talla_producto_precio", schema = "modasluz")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TallaProductoPrecio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Productos producto;

    @ManyToOne
    @JoinColumn(name = "id_talla", nullable = false)
    private Talla talla;

    @Column(name = "precio", nullable = false)
    private double precio;
}
