package com.exercise.codingchallenge.service;

import com.exercise.codingchallenge.model.EmailList;

import java.util.List;

public interface EmailService {

    Integer getUniqueCount(List<String>emails);

}
