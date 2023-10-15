package dao;

import java.util.List;
import java.util.Map;

import domain.ClassNo;

public interface ClassNoDao {
	
	public List<ClassNo> findAll();
	   
    void add(ClassNo classNo);

    void delete(int id);

    ClassNo findById(int i);

    void update(ClassNo classNo);

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
    List<ClassNo> findByPage(int start, int rows, Map<String, String[]> condition);
}
