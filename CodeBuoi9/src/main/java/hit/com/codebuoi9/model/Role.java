package hit.com.codebuoi9.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hit.com.codebuoi9.enums.EnumRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(value = EnumType.STRING)
    private EnumRole roleName;


    @JsonIgnore
    @OneToMany(mappedBy = "role" , fetch = FetchType.EAGER)
    private List<User> users;
}
