package kr.toyauction.domain.product.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kr.toyauction.domain.file.entity.FileEntity;
import kr.toyauction.domain.product.entity.DeliveryOption;
import kr.toyauction.domain.product.entity.ExchangeType;
import kr.toyauction.domain.product.entity.ProductCondition;
import kr.toyauction.domain.product.entity.PurchaseTime;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductPostRequest {

    @NotBlank
    private String productName ;

    private List<FileEntity> images ;

    private FileEntity thumbnailImage ;

    private int minBidPrice;

    private int rightPrice;

    //@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    LocalDateTime startSaleDateTime;

    //@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    LocalDateTime endSaleDateTime;

    private int unitPrice;

    private PurchaseTime purchaseTime;

    private DeliveryOption deliveryOption;

    private ExchangeType exchangeType;

    private ProductCondition productCondition;

    @NotBlank
    private String detail;
}
