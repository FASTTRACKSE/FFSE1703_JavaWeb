package fasttrackse.ffse1703.fbms.dao.quanlyduan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quanlyduan.DuAnTeam1;

@Repository
public class DuAnTeam1DaoImpl implements DuAnTeam1Dao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<DuAnTeam1> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from DuAnTeam1 where isDelete =0",DuAnTeam1.class).list();

	}

	@Override
	public void delete(String maDuAn) {
		Session session = this.sessionFactory.getCurrentSession();
		DuAnTeam1 db=session.get(DuAnTeam1.class,maDuAn);	
		db.setIsDelete(1);
		session.update(db);	
		
	}

	@Override
	public void save(DuAnTeam1 duAn) {
		Session session=this.sessionFactory.getCurrentSession();
		session.save(duAn);
		
	}

	@Override
	public DuAnTeam1 getById(String maDuAn) {
		Session session=this.sessionFactory.getCurrentSession();
		return session.get(DuAnTeam1.class,maDuAn);		
	}

	@Override
	public void update(DuAnTeam1 duAn) {
		Session session=this.sessionFactory.getCurrentSession();
		session.update(duAn);		
		
	}

	@Override
	public void setIsDelete(String maDuAn) {
		Session session = this.sessionFactory.getCurrentSession();
		DuAnTeam1 db=session.get(DuAnTeam1.class,maDuAn);	
		db.setIsDelete(0);
		session.update(db);	
	}

	@Override
	public int getName(String tenDuAn) {
		Session session = this.sessionFactory.getCurrentSession();
		List<DuAnTeam1> db = session.createQuery("from DuAnTeam1 where 	ten_du_an = '"+tenDuAn+"' AND isDelete =0", DuAnTeam1.class).list();	
		return  db.size();
	}

}