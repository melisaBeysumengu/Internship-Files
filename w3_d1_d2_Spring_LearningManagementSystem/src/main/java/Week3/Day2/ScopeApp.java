package Week3.Day2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScopeApp {

    /*
    * CREATE DATABASE ContactDB;
    * */

    private static final Logger LOGGER = LoggerFactory.getLogger(ScopeApp.class);

    /*@Autowired
    private ELearningService eLearningService;

    @Autowired
    private VideoService videoService;*/

    public static void main(String[] args) {
        SpringApplication.run(ScopeApp.class, args);

        /*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeAppConfig.class);

        ELearningService eLearningService = context.getBean(ELearningService.class);
        VideoService videoService = context.getBean(VideoService.class);
        ContentCache contentCache = context.getBean(ContentCache.class);

        eLearningService.getContentCache().addContent(new ElearningContent("elearn1", 1l,2l,2.5));
        eLearningService.getContentCache().addContent(new ElearningContent("elearn2", 1l,2l,2.5));
        videoService.getContentCache().addContent(new PowerPointContent("powerpoint1", 1l,2l,2.5));
        videoService.getContentCache().addContent(new VideoContent("video1", 1l,2l,2.5));

        eLearningService.getContentCache().printCacheSize();
        videoService.getContentCache().printCacheSize();
        contentCache.printCacheSize();*/

    }

    /*@Override
    public void run(String... args) throws Exception {
        //LOGGER.info("Requested Urls is: {}",videoService.getVideoUrl(123l));
        //LOGGER.info("Requested Urls is: {}",eLearningService.getElearningUrl(123l));
    }*/
}
