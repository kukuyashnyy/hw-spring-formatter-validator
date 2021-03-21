package org.itstep.domain.repository;

import org.itstep.domain.dto.CustomUserDto;
import org.itstep.domain.entity.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomUserRepository extends JpaRepository<CustomUser, Integer> {

}
