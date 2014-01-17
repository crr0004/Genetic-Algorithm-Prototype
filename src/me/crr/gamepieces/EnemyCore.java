/**
 * 
 */
package me.crr.gamepieces;

import org.newdawn.slick.opengl.Texture;

import me.tempus.math.Vector3;
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
	private Vector3 pos;
	private float speed = 1f;
	
	public EnemyCore(Vector3 pos){
		model = new Plane(pos, new Vector3(1,1,1));
		this.pos = pos;
		
	}
	
	public EnemyCore(Vector3 pos, Texture texture){
		this(pos);
		model.create(texture, 1);
		volume = AABB.findAABB(model.getVertices(), model.getIndices());
	}
	
	public void update(){
		pos.add(Vector3.scale(speed, Vector3.down));
	}
	
	public void draw(){
		model.draw();
	}
	
	@Override
	public AABB getAABB() {
		return volume;
	}

}
