/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sivalabs.loadbalancer;

/**
 *
 * @author skatam
 */
public interface Server
{
	public String getId();
    public void start();
    public Response process(Request request);
    public void stop();
    public ServerStatus getStatus();
    public void updateStatus(ServerStatus status);
    public long getProcessedRequestsCount();
}
