/**
 * 
 */
package com.sivalabs.jforum.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @author skatam
 *
 */
public class JaxbDateAdapter extends XmlAdapter<String, Date>{

	private SimpleDateFormat dateFormat = new SimpleDateFormat(GlobalConstants.DEFAULT_DATE_FORMAT);
	
    @Override
    public String marshal(Date date) throws Exception {
        return dateFormat.format(date);
    }
 
    @Override
    public Date unmarshal(String date) throws Exception {
        return dateFormat.parse(date);
    }
}
