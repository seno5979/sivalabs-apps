package com.sivalabs.loadbalancer;

import java.util.Date;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	LoadBalancer lb = LoadBalancerBuilder.build("DEFAULT_CLUSTER", "ROUND_ROBBIN");
        
        Request request = new Request();
        Task task = new Task() {
            @Override
            public Object execute() {
                System.err.println("Executing Task1 at :"+new Date());
                return "Success";
            }
        };
        request.setTask(task);
        Response response = lb.process(request);
        Object result = response.getResult();
        System.err.println("=====>"+result);

    }
}
