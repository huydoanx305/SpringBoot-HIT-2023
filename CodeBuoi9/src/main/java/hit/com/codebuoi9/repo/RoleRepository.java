package hit.com.codebuoi9.repo;

import hit.com.codebuoi9.enums.EnumRole;
import hit.com.codebuoi9.model.Role;
import hit.com.codebuoi9.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    Role findRoleByRoleName(EnumRole enumRole);
}
