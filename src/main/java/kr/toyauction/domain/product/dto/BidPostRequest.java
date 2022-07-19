package kr.toyauction.domain.product.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BidPostRequest {

    private int bidPrice;

}
