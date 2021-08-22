package Week3.Day2.service;

import Week3.Day2.core.cache.ContentCache;
import Week3.Day2.model.content.VideoContent;

public interface VideoService {
    boolean createNewVideoContent(VideoContent videoContent);
    VideoContent deleteVideoContent(VideoContent videoContent);
    String getVideoUrl(Long id);
    void updateCurrentTime(Long id, Long duration);
    ContentCache getContentCache();

}
