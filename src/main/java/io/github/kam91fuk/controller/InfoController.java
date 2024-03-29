package io.github.kam91fuk.controller;

import io.github.kam91fuk.config.TaskConfigurationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InfoController {
    private DataSourceProperties dataSource;
    private TaskConfigurationProperties myProp;



    @GetMapping("/info/url")
    String url() {
        return dataSource.getUrl();
    }
    @GetMapping("/info/prop")
    boolean myProp() {
        return myProp.getTemplate().isAllowMultipleTasks();
    }
}
