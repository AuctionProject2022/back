package kr.toyauction.domain.product.controller;

import kr.toyauction.domain.product.property.ProductPath;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductController {

    @GetMapping(ProductPath.PRODUCTS + "/{productId}")
    public String getProduct(@PathVariable final Long productId) {

        String result = "{\n" +
                        "  \"success\": \"true\",\n" +
                        "  \"data\": {\n" +
                        "    \"memberId\": 1,\n" +
                        "    \"productId\": 1,\n" +
                        "    \"images\": [\n" +
                        "      {\n" +
                        "        \"imageId\": 1,\n" +
                        "        \"imageUrl\": \"https://example.com/IMG00001.png\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"imageId\": 2,\n" +
                        "        \"imageUrl\": \"https://example.com/IMG00002.png\"\n" +
                        "      }\n" +
                        "    ],\n" +
                        "    \"thumbnailImage\": {\n" +
                        "      \"imageId\": 2,\n" +
                        "      \"imageUrl\": \"https://example.com/IMG00002.png\"\n" +
                        "    },\n" +
                        "    \"productName\": \"Nike Air Zoom Iorem lorem lorem Pegasus 36 Miami\",\n" +
                        "    \"minBidPrice\": 10000,\n" +
                        "    \"rightPrice\": 38000,\n" +
                        "    \"startSaleDateTime\": \"2022-06-19 21:48:55\",\n" +
                        "    \"endSaleDateTime\": \"2022-06-19 21:48:55\",\n" +
                        "    \"unitPrice\": 1000,\n" +
                        "    \"purchaseTime\": \"6개월 이내\",\n" +
                        "    \"deliveryOption\": \"직거래\",\n" +
                        "    \"isExchange\": \"false\",\n" +
                        "    \"productCondition\": \"new\",\n" +
                        "    \"detail\": \"The nike Air max 270 React ENG combines a full-lengh React foam midsole with a 270 Max air unit for unrivaled comfor and striking visul experience. The nike Air max 270 React ENG combines a full-lengh React foam midsole with a 270 Max air unit for unrivaled comfor and striking visul experience. The nike Air max 270 React ENG combines a full-lengh React foam midsole with a 270 Max air unit for unrivaled comfor and striking visul experience. The nike Air max 270 React ENG combines a full-lengh React foam midsole with a 270 Max air unit for unrivaled comfor and striking visul experience.\",\n" +
                        "    \"bids\": [\n" +
                        "      {\n" +
                        "        \"bidId\": \"1\",\n" +
                        "        \"bidPrice\": 30000,\n" +
                        "        \"bidDateTime\": \"2022-06-19 21:48:55\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"bidId\": \"2\",\n" +
                        "        \"bidPrice\": 10000,\n" +
                        "        \"bidDateTime\": \"2022-06-19 21:48:55\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"bidId\": \"3\",\n" +
                        "        \"bidPrice\": 40000,\n" +
                        "        \"bidDateTime\": \"2022-06-19 21:48:55\"\n" +
                        "      }\n" +
                        "    ],\n" +
                        "    \"createDatetime\": \"2022-06-19 21:48:55\",\n" +
                        "    \"updateDatetime\": \"2022-06-19 21:48:55\",\n" +
                        "    \"enabled\": \"true\"\n" +
                        "  }\n" +
                        "}";

        return result;
    }
}
