package id.web.sahir.tutorial.springboot.mvc.controller.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.web.sahir.tutorial.springboot.mvc.controller.domain.DokuDTU;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/")
public class DefaultController {


    public String homeAction() {
        return "home";
    }
    @RequestMapping(value = "/test")
    @ResponseBody
    public String testAction() throws IOException {
        List<DokuDTU> dokuDTUList = new ArrayList<>();

        DokuDTU dokuDTU;
        for(int i=1;i<=10;i++) {
            dokuDTU = new DokuDTU();
            dokuDTU.setTourCode("tourcode " + i);
            dokuDTU.setRrNo("rrno");
            dokuDTU.setPnr("pnr");
            dokuDTU.setAmount("amoun");
            dokuDTU.setRemark("remark");
            dokuDTU.setWords("work");

            dokuDTUList.add(dokuDTU);

        }

        for (DokuDTU tmp: dokuDTUList) {
            System.out.println(tmp.toString());
        }
        try {
            final ObjectMapper mapper = new ObjectMapper();
            System.out.println(mapper.writeValueAsString(dokuDTUList));

        } catch (IOException e) {

        }


        return "test";

    }

}
