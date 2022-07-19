package kr.toyauction.domain.product.service;

import kr.toyauction.domain.product.dto.ProductPostRequest;
import kr.toyauction.domain.product.entity.Product;
import kr.toyauction.domain.product.entity.ProductSttus;
import kr.toyauction.domain.product.repository.ProductRepository;
import kr.toyauction.global.exception.DomainNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public Product registerProduct(@NonNull final ProductPostRequest productPostRequest) {

        //상품 설명 텍스트 입력시 자바스크립트 삽입 공격 방지
        productPostRequest.getDetail()
                .replaceAll("<","&lt;")
                .replaceAll(">","&gt;")
                .replaceAll("&","&amp;")
                .replaceAll("\"","&quot;");

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
                .productSttus(ProductSttus.ON_SALE)
                .build();

        product.validation();

        Product saved = productRepository.save(product);

        return saved;
    }

    @Transactional(readOnly = true)
    public Product getProduct(Long productId) {
        return this.productRepository.findById(productId)
                .orElseThrow(() -> new DomainNotFoundException(productId));
    }
}
