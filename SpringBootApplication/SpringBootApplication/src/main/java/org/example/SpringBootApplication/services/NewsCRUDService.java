package org.example.SpringBootApplication.services;

import org.example.SpringBootApplication.dto.News;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class NewsCRUDService implements CRUDService<News> {

    private final ConcurrentHashMap<Long, News> newsList = new ConcurrentHashMap<>();

    @Override
    public News getById(Long id) {
        return newsList.get(id);
    }

    @Override
    public Collection<News> getALL() {
        return newsList.values();
    }

    @Override
    public void create(News item) {
        Long nextId = (newsList.isEmpty() ? 0 : newsList.mappingCount()) + 1;
        item.setId(nextId);
        item.setDate(new Date().toInstant());
        newsList.put(nextId, item);
    }

    @Override
    public void update(News item) {
        if (!newsList.containsKey(item.getId())){
            return;
        }
        item.setId(item.getId());
        item.setDate(new Date().toInstant());
        newsList.put(item.getId(), item);
    }

    @Override
    public void delete(Long id) {
        newsList.remove(id);
    }
}
