package com.mengu.dao;

import lombok.Data;
import org.springframework.stereotype.Repository;

/**
 * Repository
 *
 * @author mengu
 * @date 2018/11/13
 */
// 名字默认是类名首字母小写
@Data
@Repository
public class BookDao {

    private String lable = "1";

}
