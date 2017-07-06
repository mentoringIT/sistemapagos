package mx.com.mentoringit.web.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.mentoringit.model.dao.CourseDAO;
import mx.com.mentoringit.model.dao.ProductDAO;
import mx.com.mentoringit.model.dto.CourseDTO;
import mx.com.mentoringit.model.dto.ProductDTO;

@Service
public class NewIntructorService implements INewInstructorServices{

	private CourseDAO courseDAO;
	private ProductDAO productDAO;

	public CourseDAO getCourseDAO() {
		return courseDAO;
	}
	@Autowired
	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	
	public ProductDAO getProductDAO() {
		return productDAO;
	}
	@Autowired
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	@Override
	public List<CourseDTO> allCourse() throws Exception {
		return courseDAO.select();
	}
	@Override
	public List<ProductDTO> startDates(int id, String date1, String date2) throws Exception {
		return this.productDAO.startDate(id, date1, date2);
	}


}
