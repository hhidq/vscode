package dao;

import java.util.List;
import java.util.Map;

import domain.Student;

/**
 * ѧ��������DAO
 */
public interface StudentDao {


    public List<Student> findAll();

   
    void add(Student student);

    void delete(int id);

    Student findById(int i);

    void update(Student student);

    /**
     * ��ѯ�ܼ�¼��
     * @return
     * @param condition
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * ��ҳ��ѯÿҳ��¼
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<Student> findByPage(int start, int rows, Map<String, String[]> condition);
}
