package kr.toyauction.domain.product.repository;

import kr.toyauction.domain.product.entity.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidRepository extends JpaRepository<Bid, Long> {

}
