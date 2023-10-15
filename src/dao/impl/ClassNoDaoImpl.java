package dao.impl;

import dao.ClassNoDao;
import domain.ClassNo;
import util.JDBCUtils;

public class ClassNoDaoImpl<JdbcTemplate> implements ClassNoDao{
	
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<ClassNo> findAll() {
        //ʹ��JDBC�������ݿ�...
        //1.����sql
        String sql = "select * from class";
        List<ClassNo> classNo = template.query(sql, new BeanPropertyRowMapper<ClassNo>(ClassNo.class));

        return classNo;
    }

    @Override
    public void add(ClassNo classNo) {
        //1.����sql
        String sql = "insert into class values(null,?,?,?)";
        //2.ִ��sql
        template.update(sql,classNo.getCno(), classNo.getClassName(), classNo.getDepartment());
    }
    
    @Override
    public ClassNo findById(int id) {
        String sql = "select * from class where id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<ClassNo>(ClassNo.class), id);
    }

    @Override
    public void update(ClassNo classNo) {
        String sql = "update class set cno = ?,classname = ? ,department = ? where id = ? ";
        template.update(sql, classNo.getCno(), classNo.getClassName(), classNo.getDepartment(),classNo.getId());
    }
    

    @Override
    public void delete(int id) {
        //1.����sql
        String sql = "delete from class where id = ?";
        //2.ִ��sql
        template.update(sql, id);
    }

  

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //1.����ģ���ʼ��sql
        String sql = "select count(*) from class where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.����map
        Set<String> keySet = condition.keySet();
        //��������ļ���
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {

            //�ų���ҳ��������
            if("method".equals(key) || "currentPage".equals(key) || "rows".equals(key)){
                continue;
            }

            //��ȡvalue
            String value = condition.get(key)[0];
            //�ж�value�Ƿ���ֵ
            if(value != null && !"".equals(value)){
                //��ֵ
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//��������ֵ
            }
        }
        //System.out.println(sb.toString());
        //System.out.println(params);

        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<ClassNo> findByPage(int start, int rows, Map<String, String[]> condition) {
        
    	String sql = "select * from class where 1 = 1 ";

        StringBuilder sb = new StringBuilder(sql);
        //2.����map
        Set<String> keySet = condition.keySet();
        //��������ļ���
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {

            //�ų���ҳ��������
            if("method".equals(key)||"currentPage".equals(key) || "rows".equals(key)){
                continue;
            }

            //��ȡvalue
            String value = condition.get(key)[0];
            //�ж�value�Ƿ���ֵ
            if(value != null && !"".equals(value)){
                //��ֵ
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//��������ֵ
            }
        }

        //���ӷ�ҳ��ѯ
        sb.append(" limit ?,? ");
        //���ӷ�ҳ��ѯ����ֵ
        params.add(start);
        params.add(rows);
        sql = sb.toString();
        System.out.println(sql);
        System.out.println(params);

        return template.query(sql,new BeanPropertyRowMapper<ClassNo>(ClassNo.class),params.toArray());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findTotalCount'");
    }

    @Override
    public List<ClassNo> findByPage(int start, int rows, Map<String, String[]> condition) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPage'");
    }
}
