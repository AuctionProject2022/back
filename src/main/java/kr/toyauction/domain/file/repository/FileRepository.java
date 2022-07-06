package kr.toyauction.domain.file.repository;

import kr.toyauction.domain.file.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
}
