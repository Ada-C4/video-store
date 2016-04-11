package com.video.store;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoStoreController {
	
	private static final String template = "It works, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/zomg")
    public Zomg zomg(@RequestParam(value="name", defaultValue="World") String name) {
        return new Zomg(counter.incrementAndGet(),
                            String.format(template, name));
    }

}
