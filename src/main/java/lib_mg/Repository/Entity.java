package lib_mg.Repository;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String Name;
    private String Dept;
}
