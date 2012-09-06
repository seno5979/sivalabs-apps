/**
 * 
 */
package com.sivalabs.loadbalancer;

/**
 * @author Siva
 *
 */
public abstract class AbstractServer implements Server
{
	private ServerStatus status = ServerStatus.UN_INITIALIZED;
	private long processedRequests = 0;
	
    @Override
    public void start()
    {
        System.err.println("###############  "+getId()+".start() ###################");
        status = ServerStatus.READY;
    }
    @Override
    public void stop()
    {
    	System.err.println("###############  "+getId()+".stop() ###################");
        status = ServerStatus.DOWN;
    }
    
    @Override
    public Response process(Request request)
    {
        Response response = getRequestProcessor().process(request);
        processedRequests++;
        return response;
    }

	@Override
	public ServerStatus getStatus()
	{
		return status;
	}
	@Override
	public void updateStatus(ServerStatus status)
	{
		this.status = status;
	}
	
	@Override
	public long getProcessedRequestsCount()
	{
		return processedRequests;
	}
	
	public RequestProcessor getRequestProcessor()
	{
		return new DefaultRequestProcessor();
	}

}
