package com.bdsoft.xtgl.service.serviceimpl;

import com.bdsoft.xtgl.service.RedisServiceI;
import com.bdsoft.xtgl.utils.packageutil.PackageUtil;
import com.bdsoft.xtgl.utils.redis.RedisUtils;
import com.bdsoft.xtgl.utils.table.TableUtils;
import com.bdsoft.xtgl.utils.utilimpl.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class RedisServiceImpl implements RedisServiceI {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private  TableUtils tableUtils;
    @Autowired
    private RedisUtils redisUtils;

    public final static String packagePath = "com.bdsoft.xtgl.entity";
    public TableUtils getTableUtils() {
        return tableUtils;
    }
    public void setTableUtils(TableUtils tableUtils) {
        this.tableUtils = tableUtils;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public RedisUtils getRedisUtils() {
        return redisUtils;
    }

    public void setRedisUtils(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }
    @Override
    public void convertAllToRedis() {
        //【1】 取得数据库中所有的表名
        List<String> list_table = tableUtils.getAllTables();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * FROM S%");

        for(String table : list_table){
            //【2】 取得该表所有的列名
            List<String> list_columns_table = tableUtils.getColumnsByTable(table);
            //【3】取得该表的主键列名
            String idColumn = tableUtils.getIdColumnByTable(table);
            String redisKey = table+":"+idColumn;
            String sql = String.format(stringBuilder.toString(),table);
            List<Map<String,Object>> list = this.jdbcTemplate.queryForList(sql);
            //【4】表 集合
            redisUtils.set(table,list);
            for(Map<String,Object> map : list){
                //【5】拼接
               String  redisKeyWidthId = redisKey +":"+ CommonUtils.convertNullToString(map.get(idColumn));
               //【6】 表、主键、集合
               redisUtils.set(redisKeyWidthId,map);
            }
        }

    }

    @Override
    public void convertAll2Redis() {
        //【1】扫描所有实体类 默认加载在定义的packagePath中
       Set<String> classSet =  PackageUtil.findPackageClass(packagePath);
       if( classSet.isEmpty() ){return;}
       //【2】 拼接表名 不一定存在
       Set<String> table = new HashSet<>();
       for (String str : classSet) {
           if(StringUtils.isEmpty(str)){continue;}
           table.add( Character.toLowerCase(str.charAt(0))+str.substring(1,str.length()-1) );
       }
       for(String tableName : table){
          if( tableUtils.isExistTable(tableName) ){
              //【3】取得该表的主键列名
              String idColumn = tableUtils.getIdColumnByTable(tableName);
              String redisKey = tableName+":"+idColumn;
              List<Map<String,Object>> list = tableUtils.getTableData(tableName);
              //【4】表 集合
              redisUtils.set(tableName,list);
              for(Map<String,Object> map : list){
                  //【5】拼接
                  String  redisKeyWidthId = redisKey +":"+ CommonUtils.convertNullToString(map.get(idColumn));
                  //【6】 表、主键、集合
                  redisUtils.set(redisKeyWidthId,map);
              }
          }
       }
    }
}
