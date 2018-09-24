package fasttrackse.ffse1703.fbms.service.mvpquanliduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.mvpquanliduan.ProjectDAO;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Projects;
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectDAO projectDAO;

	@Override
	public List<Projects> findAll() {
		
		return projectDAO.findAll();
	}

	@Override
	public Projects findById(String id) {
		
		return projectDAO.findById(id);
	}

	@Override
	public void addNew(Projects projects) {
		projectDAO.addNew(projects);
		
	}

	@Override
	public void update(Projects projects) {
		projectDAO.update(projects);
		
	}

	@Override
	public void delete(Projects projects) {
		projectDAO.delete(projects);
		
	}

	@Override
	public int checkNameProjects(String nameProjects) {
	
		return projectDAO.checkNameProjects(nameProjects);
	}

	@Override
	public int checkMaProjects(String idProjects) {
	
		return projectDAO.checkMaProjects(idProjects);
	}

}
