package service.impl;

import java.util.List;

import java.util.Map;

import dao.CourseDao;
import dao.impl.CourseDaoImpl;
import domain.Course;
import domain.PageBean;

public class CourseServiceImpl implements CourseService{
	
	private CourseDao dao = new CourseDaoImpl();

    @Override
    public List<Course> findAll() {
        //调用Dao完成查询
        return dao.findAll();
    }

    @Override
    public void addCourse(Course course) {
        dao.add(course);
    }

    @Override
    public void deleteCourse(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public Course findCourseById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateCourse(Course course) {
        dao.update(course);
    }

    @Override
    public void delSelectedCourse(String[] ids) {
        if(ids != null && ids.length > 0){
            //1.遍历数组
            for (String id : ids) {
                //2.调用dao删除
                dao.delete(Integer.parseInt(id));
            }
        }

    }

    @Override
    public PageBean<Course> findCourseByPage(String _currentPage, String _rows, Map<String, String[]> condition) {

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if(currentPage <=0) {
            currentPage = 1;
        }
        //1.创建空的PageBean对象
        PageBean<Course> pb = new PageBean<Course>();
        //2.设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //3.调用dao查询总记录数
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        //4.调用dao查询List集合
        //计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<Course> list = dao.findByPage(start,rows,condition);
        
        
        pb.setList(list);

        //5.计算总页码
        int totalPage = (totalCount % rows)  == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);


        return pb;
    }
}
