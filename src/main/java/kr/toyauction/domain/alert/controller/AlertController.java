package kr.toyauction.domain.alert.controller;

import kr.toyauction.domain.alert.property.AlertPath;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AlertController {

    @GetMapping(AlertPath.ALERTS)
    public String getAlerts(){
        return "{\n" +
                "\t\"success\" : \"true\",\n" +
                "\t\"data\" : {\n" +
                "\t\t\"content\" : [\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"alertId\" : 12,\n" +
                "\t\t\t\t\"productId\" : 1,\n" +
                "\t\t\t\t\"alertTitle\" : {\n" +
                "\t\t\t\t\t\"code\" : \"A01\"\n" +
                "\t\t\t\t\t\"name\" : \"경매 성공\"\t// 구매\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t\"alertContents\" : \"이케아에서 산 홀더 경매에\\n <span style=\"color:#FF6495ED\">내 경매가 38,000원 낙찰완료<span> 되었습니다.\"\n" +
                "\t\t\t\t\"time\" : \"2022-08-03 22:03:16\",\n" +
                "\t\t\t\t\"url\" : \"/front/alert/detail/url/알려주세요/12\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"alertId\" : 15,\n" +
                "\t\t\t\t\"productId\" : 11,\n" +
                "\t\t\t\t\"alertTitle\" : {\n" +
                "\t\t\t\t\t\"code\" : \"A02\"\n" +
                "\t\t\t\t\t\"name\" : \"경매 실패\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t\"alertContents\" : \"이케아에서 산 홀더 경매에\\n <span style=\"color:#FF0000\">내 경매가 38,000원 낙찰실패<span> 하였습니다.\\n<span style=\"color:#FF0000\">최종 낙찰가는 56,000원<span> 입니다.\"\n" +
                "\t\t\t\t\"time\" : \"2022-08-03 22:03:16\",\n" +
                "\t\t\t\t\"url\" : \"/front/alert/detail/url/알려주세요/15\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"alertId\" : 112,\n" +
                "\t\t\t\t\"productId\" : 17,\n" +
                "\t\t\t\t\"alertTitle\" : {\n" +
                "\t\t\t\t\t\"code\" : \"A03\"\n" +
                "\t\t\t\t\t\"name\" : \"구매 응찰 완료\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t\"alertContents\" : \"이케아에서 산 홀더 경매에\\n <span style=\"color:#FF6495ED\">내 경매가 38,000원 응찰완료<span> 되었습니다.\"\n" +
                "\t\t\t\t\"time\" : \"2022-08-03 22:03:16\",\n" +
                "\t\t\t\t\"url\" : \"/front/alert/detail/url/알려주세요/112\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"alertId\" : 152,\n" +
                "\t\t\t\t\"productId\" : 111,\n" +
                "\t\t\t\t\"alertTitle\" : {\n" +
                "\t\t\t\t\t\"code\" : \"A04\"\n" +
                "\t\t\t\t\t\"name\" : \"경매 성공\" \t// 판매\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t\"alertContents\" : \"이케아에서 산 홀더 경매가\\n <span style=\"color:#FF6495ED\">내 경매가 38,000원 낙찰완료<span> 되었습니다.\"\n" +
                "\t\t\t\t\"time\" : \"2022-08-03 22:03:16\",\n" +
                "\t\t\t\t\"url\" : \"/front/alert/detail/url/알려주세요/152\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"alertId\" : 222,\n" +
                "\t\t\t\t\"productId\" : 112,\n" +
                "\t\t\t\t\"alertTitle\" : {\n" +
                "\t\t\t\t\t\"code\" : \"A05\"\n" +
                "\t\t\t\t\t\"name\" : \"경매 실패\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t\"alertContents\" : \"이케아에서 산 홀더 경매가\\n <span style=\"color:#FF0000\">응찰자 0명으로 낙찰실패<span> 하였습니다.\\n<span style=\"color:#FF0000\">재판매 2회 가능<span>합니다.\"\n" +
                "\t\t\t\t\"time\" : \"2022-08-03 22:03:16\",\n" +
                "\t\t\t\t\"url\" : \"/front/alert/detail/url/알려주세요/222\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"alertId\" : 333,\n" +
                "\t\t\t\t\"productId\" : 113,\n" +
                "\t\t\t\t\"alertTitle\" : {\n" +
                "\t\t\t\t\t\"code\" : \"A06\"\n" +
                "\t\t\t\t\t\"name\" : \"판매 등록 완료\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t\"alertContents\" : \"이케아에서 산 홀더 경매가\\n <span style=\"color:#FF6495ED\">최소 구매가 38,000원으로 판매 등록 완료<span> 되었습니다.\"\n" +
                "\t\t\t\t\"time\" : \"2022-08-03 22:03:16\",\n" +
                "\t\t\t\t\"url\" : \"/front/alert/detail/url/알려주세요/333\"\n" +
                "\t\t\t}\n" +
                "\t\t],\n" +
                "\t\t\"pageable\": {\n" +
                "\t\t\t\"sort\": {\n" +
                "\t\t\t\t\"sorted\": false,\t// 정렬상태\n" +
                "\t\t\t\t\"unsorted\": true,\n" +
                "\t\t\t\t\"empty\": true\n" +
                "\t\t\t},\n" +
                "\t\t\t\"pageSize\": 6,\t\t\t// 한 페이지에서 나타내는 게시글 수\n" +
                "\t\t\t\"pageNumber\": 2,\t\t// 현제 페이지\n" +
                "\t\t\t\"offset\": 11,\t\t\t// 첫번째 게시글 번호\n" +
                "\t\t\t\"paged\": true,\n" +
                "\t\t\t\"unpaged\": false\n" +
                "\t\t},\n" +
                "\t\t\"number\": 2,\t\t\t\t// 현재 페이지\n" +
                "\t\t\"sort\": {\n" +
                "\t\t\t\"sorted\": false,\n" +
                "\t\t\t\"unsorted\": true,\n" +
                "\t\t\t\"empty\": true\n" +
                "\t\t},\n" +
                "\t\t\"first\": false,\t\t\t\t// 첫 번째 페이지인지 여부\n" +
                "\t\t\"last\": false,\t\t\t\t// 마지막 페이지인지 여부\n" +
                "\t\t\"numberOfElements\": 5,\t\t// 현재 페이지에 조회한 데이터 개수\n" +
                "\t\t\"size\": 15,\n" +
                "\t\t\"empty\": false\n" +
                "\t}\n" +
                "}";
    }
}
