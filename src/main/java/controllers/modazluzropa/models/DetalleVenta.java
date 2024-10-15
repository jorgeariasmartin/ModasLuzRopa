package controllers.modazluzropa.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "detalle_venta", schema = "modasluz", catalog = "postgres")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Productos producto;

    @ManyToOne
    @JoinColumn(name = "id_venta", nullable = false)
    @JsonBackReference
    private Ventas venta;

    @ManyToOne
    @JoinColumn(name = "id_talla", nullable = false)
    private Talla talla;

    @Column(name = "cantidad_vendida", nullable = false)
    private int cantidadVendida;

    @Column(name = "precio_unitario", nullable = false)
    private double precioUnitario;
}
