
package com.tonon.curiosity.mars;

import javax.ws.rs.BadRequestException;

/**
 * 
 * @author carla
 *
 */

public class Ground{

	private static Ground ground = null;
	private int axisX;
	private int axisY;



	public int getAxisX(){
		return axisX;
	}

	public int getAxisY() {
		return axisY;
	}
	private Ground(String coords) {
		populateInput(coords);
	}

	public static Ground getInstance() {
		synchronized (Ground.class) {
			if(ground == null)
				ground = new Ground(InitGround.GROUND_INIT.groundValue);
		}
		return ground;
	}
	
	private void populateInput(String coords){
		String arrayCoords[] = coords.split(" ");
		if(arrayCoords.length!=2){
			throw new BadRequestException("Posição inválida: "+ coords);
		}
		axisX = Integer.valueOf(arrayCoords[0]).intValue();
		axisY = Integer.valueOf(arrayCoords[1]).intValue();
	}

}