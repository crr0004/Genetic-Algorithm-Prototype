/**
 * 
 */
package me.crr.main;

/**
 * @author Chris
 * An interface for classes to fetch data from the main thread of the game
 * Allows proper data encapsulation and validation
 */
public interface MainChannel {

	
	public float getScreenHeight();
	public float getScreenWidth();
	public Object getShader(); //TODO Change the to a shader interface
}
