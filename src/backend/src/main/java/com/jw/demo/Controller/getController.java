package com.jw.demo.Controller;
import com.jw.demo.Model.SearchParam;
import com.jw.demo.Properties.OauthProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class getController {


    @Autowired
    OauthProperties oauthProperties;

    /*
    getMethod : url접근, parameter 사용 가능, 캐시를 생성하기 때문에 효율적으로 접근 가능함.
    * */
    //parameter 못받음.
    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")
    public String getRequest(){

        System.out.println("is getMethod!!");
        return "Hi, getMethod";
    }

    @GetMapping("/demo/hello") public String HelloWorld(){
        System.out.println("hello world~~");
        return "Hello World!! \n"; }


    @GetMapping("/getParameter")
    public String getParameter(@RequestParam String id, @RequestParam String password){
        //파라미터값은 전역변수로 선언하는 것이 좋다.
        System.out.println("id : "+id);
        System.out.println("pass : "+password);
        return id+password;
    }


    //객체로 뺄 수도 있음. 객체는 getter setter형태임.
    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam){
        //public String getMultiParameter(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        //return "OK";
        //객체 타입으로 리턴할 경우 스프링에서 자동으로 json형태로 변환시켜 리턴하게됨.
        //서블릿에서는 직접 json라이브러리를 통해 변형해줬지만, 스프링부트에서는 자동으로 만들어줌.
        return searchParam;
    }

}
