package org.eijsink.service;

import org.eijsink.model.Ober;

import java.util.Optional;

public interface OberService {

    public Ober save(Ober ober);

    public Iterable<Ober> saveAll(Iterable<Ober> obers);

    public Optional<Ober> findById(Long id);

    public boolean existsById(Long id);

    public Iterable<Ober> findAll();

    public Iterable<Ober> findAllById(Iterable<Long> ids);

    public long count();

    public void deleteById(Long id);

    public void delete(Ober ober);

    public void deleteAll(Iterable<? extends Ober> obers);

    public void deleteAll();

}

