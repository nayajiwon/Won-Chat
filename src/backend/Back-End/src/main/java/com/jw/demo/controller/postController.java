package com.jw.demo.controller;

import com.jw.demo.model.SearchParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class postController {

    //html <form>
    //ajax 의 검색
    //http post body -> data
    // 형태 : json, xml, multipart-form / text-plain
    //@PostMapping(value = "/postMethod", produces = {"application-json"})//형태 지정

    @PostMapping(value = "/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam){ //post의 바디에다가 searchParam의 값들을 받아옴.
        /*http request client 측에서 body로 json형태의 데이터를 보냄 -> searchParam으로 받은 다음에 객체의 변수에 저장
        * */
        return searchParam;
    }

}
