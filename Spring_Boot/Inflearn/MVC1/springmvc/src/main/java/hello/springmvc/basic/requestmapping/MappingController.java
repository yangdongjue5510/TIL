package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MappingController {
    @RequestMapping(value = {"/hello-basic", "/hello-go"}, method = RequestMethod.GET)//매개변수가 배열도 지원
    public String helloBasic(){
        log.info("helloBasic");
        return "ok";
    }

    //간단하게 표현!
    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2(){
        log.info("mappingGetV2");
        return "ok";
    }

    //pathVariable
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data){
    //public String mappingPath(@PathVariable String userId){
        log.info("mappingPath = {}", data);
        return "ok";
    }

    //pathVariable 다중 사용
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable String orderId){
        log.info("mappingPath userid = {} orderId = {}",userId, orderId);
        return "ok";
    }

    //특정 쿼리 파라미터 조건
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    //헤더에 특정 조건
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    //미디어 타입조건 (Content-Type 헤더 기반 매핑)
    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }

    //미디어 타입조건 (Accept 헤더 기반 매핑)
    //Accept는 어떤 타입을 받을 수 있는지 나타낸 헤더값
    @PostMapping(value = "/mapping-produce", produces="text/html")
    public String mappingProduces(){
        log.info("mappingProduces");
        return "ok";
    }

}
