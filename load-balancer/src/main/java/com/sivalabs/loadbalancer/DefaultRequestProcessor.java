/**
 * 
 */
package com.sivalabs.loadbalancer;

/**
 * @author Siva
 *
 */
public class DefaultRequestProcessor implements RequestProcessor
{

	@Override
    public Response process(Request request)
    {
        Object result = request.getTask().execute();
        Response response = new Response();
        response.setResult(result);
        return response;
    }

}
