package kr.toyauction.domain.file.repository;

import kr.toyauction.domain.file.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
