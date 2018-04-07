package com.ufrest;

import com.ufrest.exception.GatorException;
import com.ufrest.util.ParameterStringBuilder;
import com.ufrest.util.RequestCaller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@SpringBootApplication
@SuppressWarnings("unused")
public class Application  {

    public static void main(String args[]) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/")
    String index() {
        return "index.html";
    }

    @RequestMapping("/courses/{year}/{semester}")
    @ResponseBody
    Object getCourses(@PathVariable String year, @PathVariable String semester) {
        String scheduleOfCoursesURL = "https://one.ufl.edu/apix/soc/schedule/?";
        Map<String, String> requestParameters = new HashMap<>();

        if (semester.toUpperCase().equals("SPRING")) {
            requestParameters.put("category", "RES");
            requestParameters.put("term", year + "1");
        }
        else if (semester.toUpperCase().equals("SUMMER")) {
            scheduleOfCoursesURL = "https://one.ufl.edu/apix/soc-summer/schedule?";
            requestParameters.put("category", "RES");
            requestParameters.put("term", year + "5");
        }
        else if (semester.toUpperCase().equals("FALL")) {
            if (year.equals("2018")) {
                requestParameters.put("category", "CWSP"); // The "regular" program is CWSP for this semester
                requestParameters.put("term", "2188"); // For some reason the API is missing the 0 from 2018
            }
            else {
                requestParameters.put("category", "RES");
                requestParameters.put("term", year + "8");
            }
        }
        else {
            throw new GatorException("Course resource not found");
        }

        // TODO: Attach course filters request parameters
        scheduleOfCoursesURL += ParameterStringBuilder.getParamsString(requestParameters);

        return RequestCaller.callSOC(scheduleOfCoursesURL, requestParameters);
    }
}
