package io.springmvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/project")
public class ProjectReadController {
//    @GetMapping("/{project}/version/{version}")
//    public Map<String, String> findAllProjectDetail(@PathVariable("project") String project,
//                                                                    @PathVariable("version") String version) {
//        return Map.of("name", project, "version", version);
//    }

    @GetMapping("/{projectID:[a-zA-Z]+}/detail")
    public Map<String, String> findAllProjectDetail(@PathVariable("projectID") String projectID){
        Map<String,String> allProjectDetail=new HashMap<>();
        allProjectDetail.put("projectID",projectID);
        return allProjectDetail;
    }
    @GetMapping("{project}/version/{version}")
    public Map<String,String> projectVersion(@PathVariable("project") String project,
                                                @PathVariable("version") String version,
                                             @PathVariable Map<String,String> allParam
                                             ){
        return Map.of("project",project,"version",version,
                "allParam",allParam.toString());
    }
}