package Week3.Day2.core.cache.impl;

import Week3.Day2.core.cache.ContentCache;
import Week3.Day2.model.content.Content;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
//@Scope("singleton") default
@Scope("prototype")
public class InMemoryContentCache implements ContentCache {

    private Map<Long, Content> contentMap = new ConcurrentHashMap<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(InMemoryContentCache.class);

    @Override
    public Content getContent(Long id) {
        return contentMap.get(id);
    }

    @Override
    public boolean addContent(Content content) {
        contentMap.put((long)(contentMap.size()+1),content);
        LOGGER.info("Content added: {}",content.getName());
        return true;
    }

    @Override
    public Content removeContent(Content content) {

        for (int i = 0; i < contentMap.size(); i++) {
            if(contentMap.get(i) == content){
                LOGGER.info("Content removed: {}",contentMap.get(i).getName());
                contentMap.remove(i,content);
            }
        }

        return content;
    }

    @Override
    public void printCacheSize() {

        LOGGER.info("Cache size is: {}",contentMap.size());

    }
}
