package com.project.kubernetes.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.project.kubernetes.entity.MessageBody;

public class ElasticSearchRepository implements ElasticsearchRepository<MessageBody, String>{

	@Override
	public Iterable<MessageBody> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<MessageBody> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends MessageBody> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends MessageBody> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<MessageBody> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<MessageBody> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<MessageBody> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(MessageBody entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends MessageBody> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<MessageBody> searchSimilar(MessageBody entity, String[] fields, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
