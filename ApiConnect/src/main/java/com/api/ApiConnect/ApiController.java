package com.api.ApiConnect;

import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {

    @GetMapping("/api/connect/{var}")
    public ApiConnectResponse apiConnect(@PathVariable String var){
        return new ApiConnectResponse("Api Connected");
    }

    @PostMapping("api/connect")
    public ApiConnectResponse apiConnectPost(@RequestBody String data){
        return new ApiConnectResponse("Api " + data);
    }
}
