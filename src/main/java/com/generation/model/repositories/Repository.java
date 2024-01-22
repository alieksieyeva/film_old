package com.generation.model.repositories;

import java.util.List;

public interface Repository <X>
{
    public List<X> findAll();

    public void save (X x);

}
