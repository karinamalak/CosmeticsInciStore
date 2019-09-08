package com.example.CosmeticsInciStore.repository;

import com.example.CosmeticsInciStore.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    public Role findByRole(String role);
}
