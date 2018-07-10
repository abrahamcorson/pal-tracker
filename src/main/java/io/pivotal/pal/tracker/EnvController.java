package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    public Map<String, String> envMap = new HashMap<String,String>();

    public EnvController(@Value("${PORT:NOT_SET}") String port, @Value("${MEMORY_LIMIT:NOT_SET}") String memoryLimit,
                         @Value("${CF_INSTANCE_INDEX:NOT_SET}") String cfInstanceIndex, @Value("${CF_INSTANCE_ADDR:NOT_SET}") String cfInstanceAddr) {
        envMap.put("PORT", port);
        envMap.put("MEMORY_LIMIT", memoryLimit);
        envMap.put("CF_INSTANCE_INDEX", cfInstanceIndex);
        envMap.put("CF_INSTANCE_ADDR", cfInstanceAddr);
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        return envMap;
    }

}