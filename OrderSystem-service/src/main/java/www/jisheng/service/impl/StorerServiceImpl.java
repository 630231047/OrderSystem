package www.jisheng.service.impl;

import com.zengjisheng.www.dao.impl.StorerDaoImpl;
import com.zengjisheng.www.po.Storer;
import com.zengjisheng.www.service.StorerService;

import java.util.List;

public class StorerServiceImpl implements StorerService{
	StorerDaoImpl<Storer> storerDaoImpl= new StorerDaoImpl<Storer>();
	@Override
	public boolean addStorer(Storer storer) {
		return storerDaoImpl.add(storer);
	}

	@Override
	public boolean removeStorer(Storer storer) {
		return storerDaoImpl.remove(storer);
	}

	@Override
	public List<Storer> lookSomeOne(Storer storer) {
		return storerDaoImpl.lookSomeOne(storer);
	}

	@Override
	public List<Storer> lookAll() {
		return storerDaoImpl.lookAll();
	}

	@Override
	public Storer lookSomeOne1(Storer storer) {
		return storerDaoImpl.lookSomeOne1(storer);
	}

	@Override
	public boolean updateStorer(Storer storer) {
		return storerDaoImpl.update(storer);
	}

	@Override
	public boolean updateMark(Storer storer) {
		return storerDaoImpl.updateMark(storer);
	}

	@Override
	public List<Storer> lookAllApply() {
		return storerDaoImpl.lookAllApply();
	}

	@Override
	public boolean updateStatus(Storer storer) {
		return storerDaoImpl.updateStatus(storer);
	}

	@Override
	public List<Storer> lookSomeOne2(Storer storer) {
		return storerDaoImpl.lookSomeOne2(storer);
	}
}
