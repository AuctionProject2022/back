package kr.toyauction.domain.product.controller;

import kr.toyauction.domain.product.property.ProductPath;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @DeleteMapping(ProductPath.PRODUCTS + "/{productId}")
    public String deleteProduct(@PathVariable final Long productId) {
        String result = "{\n" +
                        "  \"success\": \"true\"\n" +
                        "}";

        return result;
    }

    @GetMapping(ProductPath.PRODUCTS)
    public String getProducts() {
        String result = "{\n" +
                        "  \"success\": \"true\",\n" +
                        "  \"data\": [\n" +
                        "    {\n" +
                        "      \"memberId\": 1,\n" +
                        "      \"productId\": 1,\n" +
                        "      \"images\": [\n" +
                        "        {\n" +
                        "          \"imageId\": 1,\n" +
                        "          \"imageUrl\": \"https://example.com/IMG00001.png\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"imageId\": 2,\n" +
                        "          \"imageUrl\": \"https://example.com/IMG00002.png\"\n" +
                        "        }\n" +
                        "      ],\n" +
                        "      \"thumbnailImage\": {\n" +
                        "        \"imageId\": 2,\n" +
                        "        \"imageUrl\": \"https://example.com/IMG00002.png\"\n" +
                        "      },\n" +
                        "      \"productName\": \"Nike Air Zoom Iorem lorem lorem Pegasus 36 Miami\",\n" +
                        "      \"minBidPrice\": 10000,\n" +
                        "      \"rightPrice\": 38000,\n" +
                        "      \"startSaleDateTime\": \"2022-06-19 21:48:55\",\n" +
                        "      \"endSaleDateTime\": \"2022-06-19 21:48:55\",\n" +
                        "      \"unitPrice\": 1000,\n" +
                        "      \"purchaseTime\": \"6개월 이내\",\n" +
                        "      \"deliveryOption\": \"직거래\",\n" +
                        "      \"isExchange\": \"false\",\n" +
                        "      \"productCondition\": \"new\",\n" +
                        "      \"detail\": \"The nike Air max 270 React ENG combines a full-lengh React foam midsole with a 270 Max air unit for unrivaled comfor and striking visul experience. The nike Air max 270 React ENG combines a full-lengh React foam midsole with a 270 Max air unit for unrivaled comfor and striking visul experience. The nike Air max 270 React ENG combines a full-lengh React foam midsole with a 270 Max air unit for unrivaled comfor and striking visul experience. The nike Air max 270 React ENG combines a full-lengh React foam midsole with a 270 Max air unit for unrivaled comfor and striking visul experience.\",\n" +
                        "      \"bids\": [\n" +
                        "        {\n" +
                        "          \"bidId\": \"1\",\n" +
                        "          \"bidPrice\": 30000,\n" +
                        "          \"bidDateTime\": \"2022-06-19 21:48:55\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"bidId\": \"2\",\n" +
                        "          \"bidPrice\": 10000,\n" +
                        "          \"bidDateTime\": \"2022-06-19 21:48:55\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"bidId\": \"3\",\n" +
                        "          \"bidPrice\": 40000,\n" +
                        "          \"bidDateTime\": \"2022-06-19 21:48:55\"\n" +
                        "        }\n" +
                        "      ],\n" +
                        "      \"createDatetime\": \"2022-06-19 21:48:55\",\n" +
                        "      \"updateDatetime\": \"2022-06-19 21:48:55\",\n" +
                        "      \"enabled\": \"true\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"memberId\": 2,\n" +
                        "      \"productId\": 2,\n" +
                        "      \"images\": [\n" +
                        "        {\n" +
                        "          \"imageId\": 3,\n" +
                        "          \"imageUrl\": \"https://example.com/IMG00003.png\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"imageId\": 4,\n" +
                        "          \"imageUrl\": \"https://example.com/IMG00004.png\"\n" +
                        "        }\n" +
                        "      ],\n" +
                        "      \"thumbnailImage\": {\n" +
                        "        \"imageId\": 3,\n" +
                        "        \"imageUrl\": \"https://example.com/IMG00003.png\"\n" +
                        "      },\n" +
                        "      \"productName\": \"아디다스 갤럭시5 런닝화 블랙 남자 운동화 FW5717\",\n" +
                        "      \"minBidPrice\": 10000,\n" +
                        "      \"rightPrice\": 28000,\n" +
                        "      \"startSaleDateTime\": \"2022-06-19 21:48:55\",\n" +
                        "      \"endSaleDateTime\": \"2022-06-19 21:48:55\",\n" +
                        "      \"unitPrice\": 1000,\n" +
                        "      \"purchaseTime\": \"1~2년 이내\",\n" +
                        "      \"deliveryOption\": \"배송가능\",\n" +
                        "      \"isExchange\": \"true\",\n" +
                        "      \"productCondition\": \"사용감 있음\",\n" +
                        "      \"detail\": \"아디다스 갤럭시5 런닝화 블랙 남자 운동화 FW5717 1년 전에 샀어요. 사용감 있어요. 배송 가능합니다.\",\n" +
                        "      \"bids\": [\n" +
                        "        {\n" +
                        "          \"bidId\": \"4\",\n" +
                        "          \"bidPrice\": 30000,\n" +
                        "          \"bidDateTime\": \"2022-06-19 21:48:55\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"bidId\": \"5\",\n" +
                        "          \"bidPrice\": 10000,\n" +
                        "          \"bidDateTime\": \"2022-06-19 21:48:55\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"bidId\": \"6\",\n" +
                        "          \"bidPrice\": 40000,\n" +
                        "          \"bidDateTime\": \"2022-06-19 21:48:55\"\n" +
                        "        }\n" +
                        "      ],\n" +
                        "      \"createDatetime\": \"2022-06-19 21:48:55\",\n" +
                        "      \"updateDatetime\": \"2022-06-19 21:48:55\",\n" +
                        "      \"enabled\": \"true\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}";

        return result;
    }


}
