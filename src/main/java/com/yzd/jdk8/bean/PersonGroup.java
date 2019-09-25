package com.yzd.jdk8.bean;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/***
 *
 * @author : yanzhidong
 * @date : 2019/9/20 
 * @version : V1.0
 *
 */
@Data
@Accessors(chain = true)
public class PersonGroup {
    private String name;
    private List<Person> persons;
}
