package kr.toyauction.domain.product.entity;

import kr.toyauction.global.entity.BaseEntity;
import kr.toyauction.global.entity.EntitySupport;
import kr.toyauction.global.exception.DomainValidationException;
import kr.toyauction.global.property.Regex;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

import javax.persistence.*;


@Slf4j
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Product extends BaseEntity implements EntitySupport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private Long thumnailFileId;

    private String productName;

    private int minBidPrice;

    private int rightPrice;

    private LocalDateTime startSaleDateTime;

    private LocalDateTime endSaleDateTime;

    private int unitPrice;
    
    @Enumerated(EnumType.STRING)
	private PurchaseTime purchaseTime;
    
    @Enumerated(EnumType.STRING)
    private DeliveryOption deliveryOption;
    
    @Enumerated(EnumType.STRING)
    private ExchangeType exchangeType;

    @Enumerated(EnumType.STRING)
    private ProductCondition productCondition;

    @Column(length = 4000)
    private String detail;
    
    private long registerMemberId;
    
    @Enumerated(EnumType.STRING)
    private ProductSttus productSttus;

    @Override
    public void validation() {
        if (productName == null) {
            log.error("productName is null");
            throw new DomainValidationException();
        }

        if (startSaleDateTime == null) {
            log.error("startSaleDateTime is null");
            throw new DomainValidationException();
        }

        if (endSaleDateTime == null) {
            log.error("endSaleDateTime is null");
            throw new DomainValidationException();
        }

        if (purchaseTime == null) {
            log.error("purchaseTime is null");
            throw new DomainValidationException();
        }

        if (deliveryOption == null) {
            log.error("deliveryOption is null");
            throw new DomainValidationException();
        }

        if (exchangeType == null) {
            log.error("exchangeType is null");
            throw new DomainValidationException();
        }

        if (productCondition == null) {
            log.error("productCondition is null");
            throw new DomainValidationException();
        }

        if (detail == null) {
            log.error("detail is null");
            throw new DomainValidationException();
        }

        if (!productName.matches(Regex.PRODUCTNAME)) {
            log.error("productName : {}", productName);
            throw new DomainValidationException();
        }

        if (minBidPrice < 100) {
        	log.error("minBidPrice : {}", minBidPrice);
            throw new DomainValidationException();
        }

        if (rightPrice < 100 || rightPrice > 50000000) {
        	log.error("rightPrice : {}", rightPrice);
            throw new DomainValidationException();
        }

        if (unitPrice % 1000 != 0 || unitPrice > 10000000) {
        	log.error("unitPrice : {}", unitPrice);
            throw new DomainValidationException();
        }

        if (endSaleDateTime.isBefore(startSaleDateTime)) {
        	log.error("startSaleDateTime : {}", startSaleDateTime);
            throw new DomainValidationException();
        }

        if (detail.length() >= 10 && detail.length() <= 4000){
            log.error("detail : {}", detail);
            throw new DomainValidationException();
        }


    }

}
