package controllers.modazluzropa.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "productos", schema = "modasluz", catalog = "postgres")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name= "color", nullable = false)
    private String color;
}
