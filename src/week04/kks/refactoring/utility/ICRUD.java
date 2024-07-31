package week04.kks.refactoring.utility;

import week04.kks.refactoring.entities.BaseEntity;

import java.util.List;

public interface ICRUD <T>{
	T save(T t);
	Iterable<T> saveAll(Iterable<T> t);
	
	T update(BaseEntity originalEntitiyt, T t);
	
	Iterable<T> findAll();
	T findByID(int id);
}