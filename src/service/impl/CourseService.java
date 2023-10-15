package service.impl;

import java.util.List;
import java.util.Map;

import domain.Course;
import domain.PageBean;
public interface CourseService {
	
	/**
     * 查询所有课程信息
     * @return
     */
    public List<Course> findAll();


    /**
     * 保存Course
     * @param course
     */
    void addCourse(Course course);

    /**
     * 根据id删除Course
     * @param id
     */
    void deleteCourse(String id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Course findCourseById(String id);

    /**
     * 修改课程信息
     * @param course
     */
    void updateCourse(Course course);

    /**
     * 批量删除课程
     * @param ids
     */
    void delSelectedCourse(String[] ids);

    /**
     * 分页条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<Course> findCourseByPage(String currentPage, String rows, Map<String, String[]> condition);
}
