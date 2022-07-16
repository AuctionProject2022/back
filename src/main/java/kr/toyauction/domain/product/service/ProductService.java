package kr.toyauction.domain.product.service;

import kr.toyauction.domain.product.repository.ProductRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.toyauction.domain.product.dto.ProductPostRequest;
import kr.toyauction.domain.product.entity.Product;
import kr.toyauction.domain.product.entity.ProductSttus;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public Product registerProduct(@NonNull final ProductPostRequest productPostRequest) {

        Product product = Product.builder()
                .productName(productPostRequest.getProductName())
                .minBidPrice(productPostRequest.getMinBidPrice())
                .rightPrice(productPostRequest.getMinBidPrice())
                .startSaleDateTime(productPostRequest.getStartSaleDateTime())
                .endSaleDateTime(productPostRequest.getEndSaleDateTime())
                .unitPrice(productPostRequest.getUnitPrice())
                .purchaseTime(productPostRequest.getPurchaseTime())
                .deliveryOption(productPostRequest.getDeliveryOption())
                .exchangeType(productPostRequest.getExchangeType())
                .productCondition(productPostRequest.getProductCondition())
                .detail(productPostRequest.getDetail())
//				.registerMemberId()
                .productSttus(ProductSttus.ON_SALE)
                .build();

        product.validation();

        Product saved = productRepository.save(product);

        return saved;
    }

}
