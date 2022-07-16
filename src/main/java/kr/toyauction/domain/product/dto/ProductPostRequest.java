package kr.toyauction.domain.product.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kr.toyauction.domain.file.entity.FileEntity;
import kr.toyauction.domain.product.entity.DeliveryOption;
import kr.toyauction.domain.product.entity.ExchangeType;
import kr.toyauction.domain.product.entity.ProductCondition;
import kr.toyauction.domain.product.entity.PurchaseTime;
import kr.toyauction.global.property.Regex;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductPostRequest {

    @NotBlank
    @Pattern(regexp = Regex.PRODUCTNAME, message = "{REGEX_PRODUCT_NAME}")
    private String productName ;

    private List<Long> imageIds;

    private Long thumbnailImageId;

    private int minBidPrice;

    private int rightPrice;

    LocalDateTime startSaleDateTime;

    LocalDateTime endSaleDateTime;

    private int unitPrice;

    private PurchaseTime purchaseTime;

    private DeliveryOption deliveryOption;

    private ExchangeType exchangeType;

    private ProductCondition productCondition;

    @NotBlank
    private String detail;
}
