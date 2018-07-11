package com.dialogflow.springmvc.controller;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dialogflow.springmvc.domain.Message;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.dialogflow.springmvc.domain.Dialogflow;
import com.dialogflow.springmvc.domain.Response;
 
@RestController
public class DialogController {
	static String fm;
	static String ei;
	static Date m;
	static Date currDate = new Date();
	
    @RequestMapping("/")
    public String welcome() {//Welcome page, non-rest
        return "SERVER TEST 00000001";
    }
 
    @RequestMapping(value="/webhook", method=RequestMethod.POST)
    public Response res(@RequestBody HashMap<String, Object> body) throws JsonParseException, JsonMappingException, IOException, ParseException {//Welcome page, non-rest
 	   /*ClassLoader classLoader = getClass().getClassLoader();
 	   File jsonString = new File(classLoader.getResource("test/t.json").getFile());*/
 	    
 	   String json = new ObjectMapper().writeValueAsString(body);
 	   String jsonString = json.toString();
 	   
 	   ObjectMapper mapper = new ObjectMapper(); 
 	   mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
 	   Dialogflow flow = null;
 	   flow = mapper.readValue(jsonString, Dialogflow.class);
 	   m = flow.getQueryResult().getParameters().getIDate();
 	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
 	   fm = formatter.format(m);
 		if(m.before(currDate)) {
 			ei = "นี้คือข้อมูลของบริษัท "+flow.getQueryResult().getParameters().getCompany() + " ณ วันที่ "+ fm;
 			//flow.getResult().getParameters().setIDate(new SimpleDateFormat("MM-dd-yyyy").format(m));
 		}else {
 			ei = "ขอโทษคะเรายังไม่มีข้อมลูของวันที่ท่านกล่าว กรุณณาระบุวันอื่นค่ะ";
 		}
 	   Response res = new Response(ei,"webhook-echo-sample");
        return res;
    }
    @RequestMapping("/hello/{player}")
    public Message message(@PathVariable String player) {//REST Endpoint.
 
        Message msg = new Message(player, "Hello " + player);
        return msg;
    }
 
}