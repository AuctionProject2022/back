package kr.toyauction.domain.file.repository;

import kr.toyauction.domain.file.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
