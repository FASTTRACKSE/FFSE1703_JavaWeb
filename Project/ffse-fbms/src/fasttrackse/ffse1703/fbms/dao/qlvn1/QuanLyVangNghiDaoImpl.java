package fasttrackse.ffse1703.fbms.dao.qlvn1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.qlvn1.DonNghi;
import fasttrackse.ffse1703.fbms.entity.qlvn1.LyDo;
import fasttrackse.ffse1703.fbms.entity.qlvn1.TinhTrangNghi;
import fasttrackse.ffse1703.fbms.entity.security.UserAccount;

@Repository
public class QuanLyVangNghiDaoImpl implements QuanLyVangNghiDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addDon(DonNghi dn) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(dn);
		tx.commit();
		session.close();
	}


	@Override
	public UserAccount getThongTinUser(String username) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		UserAccount user = session.createQuery("from UserAccount where username='" + username + "'", UserAccount.class)
				.getSingleResult();
		session.close();
		return user;
	}

	@Override
	public TinhTrangNghi getTinhTrang(int id_nv) {
		// TODO Auto-generated method stub
		TinhTrangNghi tinhTrang = null;
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			tinhTrang = session.createQuery("from TinhTrangNghi where id_nv=" + id_nv + "", TinhTrangNghi.class).getSingleResult();
		}catch (Exception e) {
			tinhTrang= null;
		}
		
		session.close();
		return tinhTrang;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LyDo> listLyDo() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		List<LyDo> list = session.createQuery("from LyDo").list();
		session.close();
		return list;
	}

	@Override
	public List<DonNghi> listDonNghi() {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<DonNghi> listDn = session.createQuery("from DonNghi").list();
		session.close();
		return listDn;
	}
	
}