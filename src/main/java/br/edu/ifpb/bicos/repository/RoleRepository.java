package br.edu.ifpb.bicos.repository;

import br.edu.ifpb.bicos.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<Role, Long> {
}
