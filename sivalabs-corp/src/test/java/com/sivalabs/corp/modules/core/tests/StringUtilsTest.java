/**
 * 
 */
package com.sivalabs.corp.modules.core.tests;

import org.junit.Assert;
import org.junit.Test;

import com.sivalabs.corp.modules.core.utils.StringUtils;

/**
 * @author skatam
 *
 */
public class StringUtilsTest
{
	@Test
	public void testIsEmpty()
	{
		String str = null;
		Assert.assertEquals(true, StringUtils.isEmpty(str));
		str="";
		Assert.assertEquals(true, StringUtils.isEmpty(str));
		str = " ";
		Assert.assertEquals(true, StringUtils.isEmpty(str));
		str = "siva";
		Assert.assertEquals(false, StringUtils.isEmpty(str));
	}
}
