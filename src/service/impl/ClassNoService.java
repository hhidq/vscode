package service.impl;

import java.util.List;
import java.util.Map;

import domain.ClassNo;
import domain.PageBean;

public interface ClassNoService {
	
	/**
     * 查询所有班级信息
     * @return
     */
    public List<ClassNo> findAll();


    /**
     * 保存班级信息
     * @param user
     */
    void addClassNo(ClassNo classNo);

    /**
     * 根据id删除班级信息
     * @param id
     */
    void deleteClassNo(String id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    ClassNo findClassNoById(String id);

    /**
     * 修改班级信息
     * @param user
     */
    void updateClassNo(ClassNo classNo);

    /**
     * 批量删除用户
     * @param ids
     */
    void delSelectedClassNo(String[] ids);

    /**
     * 分页条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<ClassNo> findClassNoByPage(String currentPage, String rows, Map<String, String[]> condition);
}

