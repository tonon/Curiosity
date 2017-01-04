package com.tonon.curiosity.tests;

import javax.ws.rs.BadRequestException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.tonon.curiosity.robot.Curiosity;

import junit.framework.TestCase;

public class RobotTests extends TestCase {

	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	//MMRMMRMM
		@Test
		public void testMovimentMMRMMRMM(){
			final String movements = "MMRMMRMM";
			final Curiosity curiosity = new Curiosity();
			final String finalPos = curiosity.move(movements);
			assertEquals(finalPos, "2 0 S");
			
		}

		//MML
		@Test
		public void testMovimentMML(){
			final String movements = "MML";
			final Curiosity curiosity = new Curiosity();
			final String finalPos = curiosity.move(movements);
			assertEquals(finalPos, "0, 2, W)");
			
		}
		
		//AAA
		@Test
		public void testMovimentAAA(){
			final String movements = "AAA";
			final Curiosity curiosity = new Curiosity();
			final String finalPos = curiosity.move(movements);
			thrown.expect(BadRequestException.class);
		    thrown.expectMessage("Comando Invalido");
			
		}
		
		//MMMMMMMMMMMMMMMMMMMMMMMM
				@Test
				public void testMovimentMMMMMMMMMMMMMMMMMMMMMMMM(){
					final String movements = "MMMMMMMMMMMMMMMMMMMMMMMM";
					final Curiosity curiosity = new Curiosity();
					final String finalPos = curiosity.move(movements);
					thrown.expect(BadRequestException.class);
				    thrown.expectMessage("Comando Invalido");
					
				}
}
