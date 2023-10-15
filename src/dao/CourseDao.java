package dao;

import java.util.List;
import java.util.Map;

import domain.Course;

/**
 * 课程操作的DAO
 */
public interface CourseDao {


    public List<Course> findAll();

    void add(Course course);

    void delete(int id);

    Course findById(int i);

    void update(Course course);

    /**
     * 查询总记录数
     * @return
     * @param condition
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页查询每页记录
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<Course> findByPage(int start, int rows, Map<String, String[]> condition);
}
