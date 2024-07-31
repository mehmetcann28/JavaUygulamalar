package week04.kks.refactoring.utility;

import week04.kks.refactoring.entities.BaseEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DatabaseManager<T extends BaseEntity> implements ICRUD<T> {
	
	ArrayList<T> veriListesi = new ArrayList<>();
	
	@Override
	public T save(T t) {
		if (veriListesi.add(t)) {
			return t;
		}
		else {
			return null;
		}
	}
	
	@Override
	public List<T> saveAll(Iterable<T> t) {
		if (veriListesi.addAll((Collection<? extends T>) t)) {
			return (List<T>) t;
		}
		else {
			return null;
		}
	}
	
	@Override
	public T update(BaseEntity originalEntitiyt, T t) {
		int index = veriListesi.indexOf(originalEntitiyt);
		return veriListesi.set(index, t);
	}
	
	
	@Override
	public List<T> findAll() {
		return veriListesi;
	}
	
	@Override
	public T findByID(int id) {
		return null;
	}
}