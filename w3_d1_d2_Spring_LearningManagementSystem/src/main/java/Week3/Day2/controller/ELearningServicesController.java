package Week3.Day2.controller;

import Week3.Day2.model.content.Content;
import Week3.Day2.model.content.ElearningContent;
import Week3.Day2.service.ELearningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/e-learning-service")
public class ELearningServicesController {

    private ELearningService eLearningService;

    @Autowired
    public ELearningServicesController(ELearningService eLearningService){
        this.eLearningService = eLearningService;
    }

    @PostMapping("/create")
    public boolean createNewVideoContent(@RequestBody ElearningContent elearningContent){

        /*if(elearningContent.getName()==null){
            throw new NameNotFoundException("no name", elearningContent);
        }*/

        return eLearningService.createNewElearningContent(elearningContent);
    }

    @DeleteMapping("/delete")
    public Content deleteVideoContent(@RequestBody ElearningContent elearningContent){
        return eLearningService.deleteElearningContent(elearningContent);
    }

    @GetMapping("get/{id}")
    public String getVideoUrl(@PathVariable("id") long id){
        return eLearningService.getElearningUrl(id);
    }

}
