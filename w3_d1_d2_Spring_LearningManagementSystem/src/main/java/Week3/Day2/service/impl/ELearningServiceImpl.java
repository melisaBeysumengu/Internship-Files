package Week3.Day2.service.impl;

import Week3.Day2.core.cache.ContentCache;
import Week3.Day2.model.content.ElearningContent;
import Week3.Day2.service.ELearningService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ELearningServiceImpl implements ELearningService {

    private ContentCache contentCache;
    private static final Logger LOGGER = LoggerFactory.getLogger(ELearningServiceImpl.class);

    @Autowired
    public ELearningServiceImpl(ContentCache contentCache) {
        this.contentCache = contentCache;
    }


    @Override
    public boolean createNewElearningContent(ElearningContent elearningContent) {

        contentCache.addContent(elearningContent);
        LOGGER.info("New e-learning content added: {}", elearningContent.getName());

        return true;
    }

    @Override
    public ElearningContent deleteElearningContent(ElearningContent elearningContent) {
        return (ElearningContent) contentCache.removeContent(elearningContent);
    }

    @Override
    public String getElearningUrl(Long id) {
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
