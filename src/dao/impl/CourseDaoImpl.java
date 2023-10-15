package dao.impl;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import dao.CourseDao;
import domain.Course;
import util.JDBCUtils;

public class CourseDaoImpl implements CourseDao{
	
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Course> findAll() {
        //使用JDBC操作数据库...
        //1.定义sql
        String sql = "select * from course";
        List<Course> course = template.query(sql, new BeanPropertyRowMapper<Course>(Course.class));

        return course;
    }

    

    @Override
    public void add(Course course) {
        //1.定义sql
        String sql = "insert into course values(null,?,?,?,?,?)";
        //2.执行sql
        template.update(sql,course.getCourseno(), course.getCoursename(), course.getType(), course.getPeriod(), course.getCredit());
    }
    
    @Override
    public Course findById(int id) {
        String sql = "select * from course where id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Course>(Course.class), id);
    }

    @Override
    public void update(Course course) {
        String sql = "update student set courseno = ?,coursename = ? ,type = ? , period = ? , credit = ? where id = ?";
        template.update(sql, course.getCourseno(), course.getCoursename(), course.getType(),course.getPeriod(), course.getCredit(),course.getId());
    }
    

    @Override
    public void delete(int id) {
        //1.定义sql
        String sql = "delete from course where id = ?";
        //2.执行sql
        template.update(sql, id);
    }


    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //1.定义模板初始化sql
        String sql = "select count(*) from course where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {

            //排除分页条件参数
            if("method".equals(key) || "currentPage".equals(key) || "rows".equals(key)){
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                //有值
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//？条件的值
            }
        }
        //System.out.println(sb.toString());
        //System.out.println(params);

        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<Course> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from course  where 1 = 1 ";

        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {

            //排除分页条件参数
            if("method".equals(key)||"currentPage".equals(key) || "rows".equals(key)){
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                //有值
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//？条件的值
            }
        }

        //添加分页查询
        sb.append(" limit ?,? ");
        //添加分页查询参数值
        params.add(start);
        params.add(rows);
        sql = sb.toString();
        System.out.println(sql);
        System.out.println(params);

        return template.query(sql,new BeanPropertyRowMapper<Course>(Course.class),params.toArray());
    }

	
}