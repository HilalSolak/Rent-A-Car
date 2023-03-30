package kodlama.io.rentacar.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "models")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name="brand_id")//bunu yazmasak bile brand_id olarak alıyor ama nolur nolmaz yazdık.
    @JsonManagedReference
    private Brand brand;
    @OneToMany(mappedBy = "model")
    @JsonBackReference
    public List<Car> cars;
}
