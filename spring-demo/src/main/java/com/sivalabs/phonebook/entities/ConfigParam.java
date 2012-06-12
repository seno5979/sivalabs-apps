/**
 * 
 */
package com.sivalabs.phonebook.entities;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author siva
 *
 */
public class ConfigParam 
{
	private Integer id;
	private String name;
	private Object value;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
	
}
