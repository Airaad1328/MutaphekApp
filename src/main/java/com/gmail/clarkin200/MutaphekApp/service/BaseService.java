package com.gmail.clarkin200.MutaphekApp.service;

import java.util.List;

public interface BaseService<T,S>{
    T create (S request);
    List<T> fetchAll();
    T findById (Long id);
    T updateById (Long id,S request);
    boolean deleteById(Long id);
}
