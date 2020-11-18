package com.example.wsp_spring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    private final DBRepository dbRepository;

    @Autowired
    public ToDoService(DBRepository dbRepository) {
        this.dbRepository = dbRepository;
    }

    public List<ToDoItem> showToDoItemsByUserId(String userId) {
        return dbRepository.findToDoItemsByUserId(userId);
    }

    public int additionalToDoItems(String userId, String subject, String body) {
        return dbRepository.insertToDoItem(userId, subject, body);
    }

}
