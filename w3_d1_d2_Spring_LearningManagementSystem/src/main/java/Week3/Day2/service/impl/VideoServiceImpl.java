package Week3.Day2.service.impl;

import Week3.Day2.core.cache.ContentCache;
import Week3.Day2.model.content.VideoContent;
import Week3.Day2.service.VideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService {


    private ContentCache contentCache;
    private static final Logger LOGGER = LoggerFactory.getLogger(VideoServiceImpl.class);

    @Autowired
    public VideoServiceImpl(ContentCache contentCache) {
        this.contentCache = contentCache;
    }


    @Override
    public boolean createNewVideoContent(VideoContent videoContent) {
        contentCache.addContent(videoContent);
        LOGGER.info("New e-learning content added: {}", videoContent.getName());

        return true;
    }

    @Override
    public VideoContent deleteVideoContent(VideoContent videoContent) {
        return (VideoContent) contentCache.removeContent(videoContent);
    }

    @Override
    public String getVideoUrl(Long id) {
        return contentCache.getContent(id).getName();
    }

    @Override
    public void updateCurrentTime(Long id, Long duration) {
        contentCache.getContent(id).setPublishDate(duration);
        LOGGER.info("Current time updated to: {}", duration);
    }

    @Override
    public ContentCache getContentCache() {
        return contentCache;
    }
}
