package br.com.ilegra.jt.testespark;

import static spark.Spark.*;

public class Server
{
    public static void main( String[] args )
    {
	stop();
        System.out.println( "Kill Jetty server of Spark!" );

    }
}
