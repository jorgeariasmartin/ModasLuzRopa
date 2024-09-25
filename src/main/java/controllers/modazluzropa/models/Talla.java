package controllers.modazluzropa.models;

import controllers.modazluzropa.enumns.TipoTalla;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "talla", schema = "modasluz", catalog = "postgres")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Talla {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tipo_talla")
    @Enumerated(EnumType.ORDINAL)
    private TipoTalla talla;

    @Column(name = "descripcion")
    private String descripcion;
}
