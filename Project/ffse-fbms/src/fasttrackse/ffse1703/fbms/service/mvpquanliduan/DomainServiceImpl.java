package fasttrackse.ffse1703.fbms.service.mvpquanliduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.mvpquanliduan.DomainDAO;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Domain;

@Service
public class DomainServiceImpl implements DomainService {
	@Autowired
	private DomainDAO domainDAO;

	@Override
	@Transactional
	public List<Domain> findAll() {
		return domainDAO.findAll();
	}

	@Override
	@Transactional
	public Domain findById(int id) {
		return domainDAO.findById(id);
	}

	@Override
	@Transactional
	public void addNew(Domain domain) {
		domainDAO.addNew(domain);
	}

	@Override
	@Transactional
	public void update(Domain domain) {
		domainDAO.update(domain);
	}

	@Override
	@Transactional
	public void delete(Domain domain) {
		domainDAO.delete(domain);
	}

	@Override
	@Transactional
	public int checkDomain(String nameDoamin) {
		return domainDAO.checkDomain(nameDoamin);
	}

}
