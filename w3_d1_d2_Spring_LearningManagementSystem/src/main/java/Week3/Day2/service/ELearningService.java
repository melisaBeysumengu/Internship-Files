package Week3.Day2.service;

import Week3.Day2.core.cache.ContentCache;
import Week3.Day2.model.content.ElearningContent;

public interface ELearningService {
    boolean createNewElearningContent(ElearningContent elearningContent);
    ElearningContent deleteElearningContent(ElearningContent elearningContent);
    String getElearningUrl(Long id);
    void updateCurrentTime(Long id, Long duration);
    ContentCache getContentCache();
}
