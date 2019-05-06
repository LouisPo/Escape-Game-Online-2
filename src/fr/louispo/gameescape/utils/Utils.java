package fr.louispo.gameescape.utils;

/**
 * La classe utilitaire.
 * @author Louis 
 *
 */
public class Utils {
	
	/**
	 * Vider la console.
	 */
	public final static void clearConsole()
	{
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    }
	}
}
