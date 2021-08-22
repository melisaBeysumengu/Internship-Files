package Week3.Day2.core.cache;

import Week3.Day2.model.content.Content;

public interface ContentCache {
    Content getContent(Long id);
    boolean addContent(Content content);
    Content removeContent(Content content);
    void printCacheSize();
}
