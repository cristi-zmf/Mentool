package com.cristi.web.mentool.exposition.resource;

import com.cristi.web.mentool.exposition.Dto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.String.format;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api")
public class FirstResource {
    @Value("${test}")
    private String test;


    @PostMapping(path = "/test")
//    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public ResponseEntity<String> getDto(@RequestBody Dto dto) {
        System.out.printf(format("Got the dto: value: %s , object: %s", dto.value, dto.object));
        return ok(test);
    }
}
