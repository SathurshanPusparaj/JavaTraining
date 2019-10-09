class Application{
	public static void main(String args[]){
		Staticclass sclass = new Staticclass();
		sclass.run();
		sclass.call();
		sclass = null;
		sclass.run();
		sclass.call();
	}
}


/*
*
*
*
ser@delegate-ThinkCentre-M710s:~/Desktop/java/static$ java Application
Run
Call
Run
Exception in thread "main" java.lang.NullPointerException
	at Application.main(Application.java:8)
*/
