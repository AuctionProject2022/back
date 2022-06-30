package kr.toyauction.domain.alert.controller;

import kr.toyauction.domain.alert.property.AlertPath;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
                "\t\t\t\t\"alertTitle\" : \"경매 성공\",\n" +
                "\t\t\t\t\"alertContents\" : \"이케아에서 산 홀더 경매에\\n <span style=\"color:#FF6495ED\">내 경매가 38,000원 낙찰완료<span> 되었습니다.\",\n" +
                "\t\t\t\t\"createDatetime\" : \"2022-08-03 22:03:16\",\n" +
                "\t\t\t\t\"url\" : \"/프론트url/product/12\",\n" +
                "\t\t\t\t\"alertRead\" : false\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"alertId\" : 15,\n" +
                "\t\t\t\t\"alertTitle\" : \"경매 실패\",\n" +
                "\t\t\t\t\"alertContents\" : \"이케아에서 산 홀더 경매에\\n <span style=\"color:#FF0000\">내 경매가 38,000원 낙찰실패<span> 하였습니다.\\n<span style=\"color:#FF0000\">최종 낙찰가는 56,000원<span> 입니다.\",\n" +
                "\t\t\t\t\"createDatetime\" : \"2022-08-03 22:03:16\",\n" +
                "\t\t\t\t\"url\" : \"/프론트url/product/123\",\n" +
                "\t\t\t\t\"alertRead\" : false\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"alertId\" : 112,\n" +
                "\t\t\t\t\"alertTitle\" : \"구매 응찰 완료\",\n" +
                "\t\t\t\t\"alertContents\" : \"이케아에서 산 홀더 경매에\\n <span style=\"color:#FF6495ED\">내 경매가 38,000원 응찰완료<span> 되었습니다.\",\n" +
                "\t\t\t\t\"createDatetime\" : \"2022-08-03 22:03:16\",\n" +
                "\t\t\t\t\"url\" : \"/프론트url/product/122\",\n" +
                "\t\t\t\t\"alertRead\" : true\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"alertId\" : 152,\n" +
                "\t\t\t\t\"alertTitle\" : \"경매 성공\",\n" +
                "\t\t\t\t\"alertContents\" : \"이케아에서 산 홀더 경매가\\n <span style=\"color:#FF6495ED\">내 경매가 38,000원 낙찰완료<span> 되었습니다.\",\n" +
                "\t\t\t\t\"createDatetime\" : \"2022-08-03 22:03:16\",\n" +
                "\t\t\t\t\"url\" : \"/프론트url/product/112\",\n" +
                "\t\t\t\t\"alertRead\" : true\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"alertId\" : 222,\n" +
                "\t\t\t\t\"alertTitle\" : \"경매 실패\",\n" +
                "\t\t\t\t\"alertContents\" : \"이케아에서 산 홀더 경매가\\n <span style=\"color:#FF0000\">응찰자 0명으로 낙찰실패<span> 하였습니다.\\n<span style=\"color:#FF0000\">재판매 2회 가능<span>합니다.\",\n" +
                "\t\t\t\t\"createDatetime\" : \"2022-08-03 22:03:16\",\n" +
                "\t\t\t\t\"url\" : \"/프론트url/product/152\",\n" +
                "\t\t\t\t\"alertRead\" : true\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"alertId\" : 333,\n" +
                "\t\t\t\t\"alertTitle\" : \"판매 등록 완료\",\n" +
                "\t\t\t\t\"alertContents\" : \"이케아에서 산 홀더 경매가\\n <span style=\"color:#FF6495ED\">최소 구매가 38,000원으로 판매 등록 완료<span> 되었습니다.\",\n" +
                "\t\t\t\t\"createDatetime\" : \"2022-08-03 22:03:16\",\n" +
                "\t\t\t\t\"url\" : \"/프론트url/product/182\",\n" +
                "\t\t\t\t\"alertRead\" : true\n" +
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

    @GetMapping(AlertPath.ALERTS+"/{alertId}")
    public String getAlert(@PathVariable final Long alertId){
        return "{\n" +
                "\t\"success\" : \"true\",\n" +
                "\t\"data\" : {\n" +
                "\t\t\"alertTitle\": {\n" +
                "\t\t\t\"code\" : \"A01\"\n" +
                "\t\t\t\"name\" : \"경매 성공\"\n" +
                "\t\t},\n" +
                "\t\t\"time\" : \"2021-06-10 12:45:45\",\n" +
                "\t\t\"moneyComment\" : \"총 낙찰금액\"\n" +
                "\t\t\"money\" : 80000,\n" +
                "\t\t\"productTitle\" : \"이케아에서 사온 파도 조명 작은 것 한개와 홀더까지 같이 세트로 묶어서 팝니다\",\n" +
                "\t\t\"bidDetails\" : [\n" +
                "\t\t\t{\"order\" : 1, \"hopeMoney\" : 20000, \"time\" : \"2일 15시 8분 34초\"},\n" +
                "\t\t\t{\"order\" : 2, \"hopeMoney\" : 30000, \"time\" : \"2일 15시 8분 34초\"},\n" +
                "\t\t\t{\"order\" : 3, \"hopeMoney\" : 40000, \"time\" : \"2일 15시 8분 34초\"},\n" +
                "\t\t\t{\"order\" : 4, \"hopeMoney\" : 50000, \"time\" : \"2일 15시 8분 34초\"},\n" +
                "\t\t\t{\"order\" : 5, \"hopeMoney\" : 60000, \"time\" : \"2일 15시 8분 34초\"},\n" +
                "\t\t\t{\"order\" : 6, \"hopeMoney\" : 70000, \"time\" : \"2일 15시 8분 34초\"},\n" +
                "\t\t\t{\"order\" : 7, \"hopeMoney\" : 80000, \"time\" : \"2일 15시 8분 34초\"}\n" +
                "\t\t],\n" +
                "\t\t\"productInfomation\" : {\n" +
                "\t\t\t\"option\" : {\n" +
                "\t\t\t\tcode : \"정해주세요\"\n" +
                "\t\t\t\tname : \"직거래\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"buyTime\" : {\n" +
                "\t\t\t\tcode : \"정해주세요\"\n" +
                "\t\t\t\tname : \"1~2년 이내\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"status\" : {\n" +
                "\t\t\t\tcode : \"정해주세요\"\n" +
                "\t\t\t\tname : \"사용감 있음\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"exchangeable\" : {\n" +
                "\t\t\t\tcode : \"정해주세요\"\n" +
                "\t\t\t\tname : \"교환불가\"\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";
    }
}
