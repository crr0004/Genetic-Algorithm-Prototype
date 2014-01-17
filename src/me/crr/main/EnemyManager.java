/**
 * @author Chris
 */

package me.crr.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import me.crr.gamepieces.EnemyCore;
import me.tempus.math.Vector3;

public class EnemyManager {

	private List<EnemyCore> enemies;
	private Texture enemyCoreTexture;
	private int numberOfEnemies = 5;
	
	public EnemyManager(){
		enemies = new ArrayList<EnemyCore>(numberOfEnemies);
		try {
			enemyCoreTexture = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("textures/enemy_core"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createInitalEnemies(){
		for(int i = 0; i < numberOfEnemies; i++){
			enemies.add(i, new EnemyCore(new Vector3(i *20, 80, -150), enemyCoreTexture));
		}
	}
	
	public void update(){
		
		
		
		for(EnemyCore core : enemies){
			
			
			
			core.update();
		}
	}
	
	public void draw(){
		for(EnemyCore core : enemies){
			core.draw();
		}
	}
	
	public int destroyEnemy(EnemyCore enemy){
		int enemyIndex = enemies.indexOf(enemy);
		enemies.remove(enemyIndex);
		return enemyIndex;
	}
}
