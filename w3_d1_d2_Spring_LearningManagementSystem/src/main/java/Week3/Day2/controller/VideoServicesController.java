package Week3.Day2.controller;

import Week3.Day2.model.content.Content;
import Week3.Day2.model.content.VideoContent;
import Week3.Day2.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/video-service")
public class VideoServicesController {
    private VideoService videoService;

    @Autowired
    public VideoServicesController(VideoService videoService){
        this.videoService = videoService;
    }

    @PostMapping("/create")
    public boolean createNewVideoContent(@RequestBody VideoContent videoContent){
        return videoService.createNewVideoContent(videoContent);
    }

    @DeleteMapping("/delete")
    public Content deleteVideoContent(@RequestBody VideoContent videoContent){
        return videoService.deleteVideoContent(videoContent);
    }

    @GetMapping("get/{id}")
    public String getVideoUrl(@PathVariable("id") long id){
        return videoService.getVideoUrl(id);
    }

}
