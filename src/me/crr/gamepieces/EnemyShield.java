package me.crr.gamepieces;

import me.tempus.collision.AABB;
import me.tempus.collision.IAABB;
import me.tempus.gameobjects.Plane;

public class EnemyShield implements IAABB {

	private AABB volume;
	private Plane model;
	
	public EnemyShield(){
		
	}
	
	@Override
	public AABB getAABB() {
		// TODO Auto-generated method stub
		return null;
	}

}
