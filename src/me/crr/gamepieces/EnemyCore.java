/**
 * 
 */
package me.crr.gamepieces;

import me.tempus.collision.AABB;
import me.tempus.collision.IAABB;
import me.tempus.gameobjects.Plane;

/**
 * @author Chris
 *
 */
public class EnemyCore implements IAABB {

	private AABB volume;
	private Plane model;
	
	@Override
	public AABB getAABB() {
		// TODO Auto-generated method stub
		return null;
	}

}
