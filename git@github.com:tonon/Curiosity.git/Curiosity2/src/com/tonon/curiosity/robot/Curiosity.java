package com.tonon.curiosity.robot;

import java.util.HashMap;
import java.util.Map;

import org.jboss.resteasy.spi.BadRequestException;

import com.tonon.curiosity.mars.Ground;

/**
 * 
 * @author carla
 *
 */

public class Curiosity {

	private static final Map <String, Integer> DIRECTION_STRING_TO_INT;
	private static final Map <Integer, String> DIRECTION_INT_TO_STRING;
	private int posX;
	private int posY;
	private int direction;

	static{
		DIRECTION_STRING_TO_INT = new HashMap <String, Integer>();
		DIRECTION_INT_TO_STRING = new HashMap <Integer, String>();
		DIRECTION_STRING_TO_INT.put("N", Integer.valueOf(1));
		DIRECTION_STRING_TO_INT.put("E", Integer.valueOf(2));
		DIRECTION_STRING_TO_INT.put("W", Integer.valueOf(4));
		DIRECTION_STRING_TO_INT.put("S", Integer.valueOf(3));
		DIRECTION_INT_TO_STRING.put(Integer.valueOf(1), "N");
		DIRECTION_INT_TO_STRING.put(Integer.valueOf(2), "E");
		DIRECTION_INT_TO_STRING.put(Integer.valueOf(4), "W");
		DIRECTION_INT_TO_STRING.put(Integer.valueOf(3), "S");
	}


	public Curiosity(){
		extractInputs(InitRobot.ROBOT_INIT.robotValue);
	}

	private void extractInputs(String inputs){
		String inputArray[] = inputs.split(" ");
		if(inputArray.length != 3)
			throw new BadRequestException("Posição Inválida");
		posX = Integer.valueOf(inputArray[0]).intValue();
		posY = Integer.valueOf(inputArray[1]).intValue();
		if(!DIRECTION_STRING_TO_INT.containsKey(inputArray[2].toUpperCase())){
			throw new BadRequestException("Posição Inválida (N,S,E,W)\"");
		} else	{
			direction = ((Integer)DIRECTION_STRING_TO_INT.get(inputArray[2].toUpperCase())).intValue();
			return;
		}
	}

	public String move(String moversString)	{
		moversString = moversString.toUpperCase();
		for(int index = 0; index < moversString.length(); index++){
			char c = moversString.charAt(index);
			move(c);
		}

		return (posX + " " + posY + " " + DIRECTION_INT_TO_STRING.get(Integer.valueOf(direction)));
	}

	private void move(char c){
		switch(c){
		case 'L':
		case 'R':
			changeDirection(c);
			break;

		case 'M':
			move();
			break;
		default:
			throw new BadRequestException("Comando Invalido");
		}


	}

	private void move()	{
		switch(direction){
		
		default:
			break;

		case 1:
			if(posY+1>Ground.getInstance().getAxisY()){
				throw new BadRequestException("Posição inválida");
			}
			posY++;
			break;

		case 2:
			if(posX + 1 > Ground.getInstance().getAxisX()){
				throw new BadRequestException("Posição inválida");
			}
			posX++;
			break;

		case 3:
			if(posY - 1 < 0){
				throw new BadRequestException("Posição inválida");
			}
			posY--;
			break;

		case 4:
			if(posX - 1 < 0){
				throw new BadRequestException("Posição inválida");
			}
			posX--;
			break;
		}
	}

	private void changeDirection(char c){
		if(c == 'L')
			direction--;
		if(c == 'R')
			direction++;
		if(direction == 0)
			direction = 4;
		if(direction == 5)
			direction = 1;
	}

}
