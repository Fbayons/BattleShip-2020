package BattleShip;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class ShooterTest {

	/*
	 * Test que comprueba si el n�mero de barcos no tocados en el tablero es 0.
	 * */
	@Test
	public void ShotTest(){
		Board board = new Board(5,5,5);
		board.initBoard();
		int n_ship;
		//Board amb 2 Ship
		board.matrix[1][1]='S';
		board.matrix[3][3]='S';
		n_ship=board.countShip();
		assertFalse(n_ship == 0);
		
		//Board amb 0 Ship
		board.matrix[1][1]='X';
		board.matrix[3][3]='X';
		n_ship=board.countShip();
		assertTrue(n_ship == 0);
	}
	
	
	/*
	 * Test que comprueba que los cambios producidos en la matriz se realizan correctamente. 
	 * Se ha realizado tambi�n valors l�mit y forntera y particiones equivalentes.
	 * */
	@Test
	void getCoordinatesTest() {
		int countO=0,countX=0,countS=0,x=0,y=0;
	
		Board board = new Board(5,5,5);
		board.initBoard();
		//setShip
		board.matrix[1][1]='S';
		board.matrix[3][3]='S';
		board.matrix[2][4]='S';
		board.matrix[1][2]='S';
		board.matrix[2][2]='S';
		
		//Turno
		board.matrix[0][0] ='O';
		board.matrix[3][4] ='O';
		board.matrix[1][1] ='X';
		board.matrix[2][2] ='X';
		
		for (int i = 0; i < board.getRow() ; i++) {
			for (int j = 0; j < board.getCol(); j++) {
				if(board.matrix[i][j]=='O') {
					countO++;
				}else if(board.matrix[i][j]=='X'){
					countX++;
				}else if(board.matrix[i][j]=='S'){
					countS++;
				}
			}
		}
		assertEquals(2, countO);
		assertEquals(2, countX);
		assertEquals(3, countS);
		
		//Valores l�mite. El jugador introduce las coordenadas x = 1, y = 1.
		x = 1;y = 1;
		assertEquals(true, (x>0 && y>0 && x<board.getRow()+1 && y<board.getCol()+1));
		
		//Valores l�mite en matriz 5x5. El jugador introduce las coordenadas x = 5, y = 5.
		x = 5;y = 5;
		assertEquals(true, (x>0 && y>0 && x<board.getRow()+1 && y<board.getCol()+1));
		
		//Valores frontera en matriz 5x5. El jugador introduce las coordenadas x = 0, y = 1.
		x = 0;y = 1;
		assertEquals(false, (x>0 && y>0 && x<board.getRow()+1 && y<board.getCol()+1));
		
		//Valores frontera en matriz 5x5. El jugador introduce las coordenadas x = 1, y = 0.
		x = 1;y = 0;
		assertEquals(false, (x>0 && y>0 && x<board.getRow()+1 && y<board.getCol()+1));
		
		//Valores frontera en matriz 5x5. El jugador introduce las coordenadas x = 6, y = 5.
		x = 6;y = 5;
		assertEquals(false, (x>0 && y>0 && x<board.getRow()+1 && y<board.getCol()+1));
		
		//Valores frontera en matriz 5x5. El jugador introduce las coordenadas x = 5, y = 6.
		x = 5;y = 6;
		assertEquals(false, (x>0 && y>0 && x<board.getRow()+1 && y<board.getCol()+1));
		
		//Valores frontera en matriz 5x5. El jugador introduce las coordenadas x = 2, y = 3.
		x = 2;y = 3;
		assertEquals(true, (x>0 && y>0 && x<board.getRow()+1 && y<board.getCol()+1));
		
		//Valores frontera en matriz 5x5. El jugador introduce las coordenadas x = 3, y = 2.
		x = 3;y = 2;
		assertEquals(true, (x>0 && y>0 && x<board.getRow()+1 && y<board.getCol()+1));
		
		//Valores frontera en matriz 5x5. El jugador introduce las coordenadas x = 4, y = 3.
		x = 4;y = 3;
		assertEquals(true, (x>0 && y>0 && x<board.getRow()+1 && y<board.getCol()+1));
				
		//Valores frontera en matriz 5x5. El jugador introduce las coordenadas x = 3, y = 4.
		x = 3;y = 4;
		assertEquals(true, (x>0 && y>0 && x<board.getRow()+1 && y<board.getCol()+1));
		
		
		//Particiones equivalentes en matriz 5x5. Valors v�lids 
		
		//El jugador introduce las coordenadas x = 3, y = 3.
		x = 3;y = 3;
		assertEquals(true, (x>0 && y>0 && x<board.getRow()+1 && y<board.getCol()+1));
		
		//El jugador introduce las coordenadas x = 1, y = 4.
		x = 1;y = 4;
		assertEquals(true, (x>0 && y>0 && x<board.getRow()+1 && y<board.getCol()+1));
		
		//Particiones equivalentes en matriz 5x5. Valors NO v�lids 
		
		//El jugador introduce las coordenadas x = 5, y = 30.
		x = 5;y = 30;
		assertEquals(false, (x>0 && y>0 && x<board.getRow()+1 && y<board.getCol()+1));
				
		//El jugador introduce las coordenadas x = 270, y = 4.
		x = 270;y = 4;
		assertEquals(false, (x>0 && y>0 && x<board.getRow()+1 && y<board.getCol()+1));
		
		//El jugador introduce las coordenadas x = -9, y = 30.
		x = -9;y = 3;
		assertEquals(false, (x>0 && y>0 && x<board.getRow()+1 && y<board.getCol()+1));
						
		//El jugador introduce las coordenadas x = 2, y = -14.
		x = 2;y = -14;
		assertEquals(false, (x>0 && y>0 && x<board.getRow()+1 && y<board.getCol()+1));
		
		//El jugador introduce las coordenadas x = 3, y = a.
		x = 3;y = 'a';
		assertEquals(false, (x>0 && y>0 && x<board.getRow()+1 && y<board.getCol()+1));
								
		//El jugador introduce las coordenadas x = 2, y = !.
		x = 2;y = '!';
		assertEquals(false, (x>0 && y>0 && x<board.getRow()+1 && y<board.getCol()+1));
	
	}
	
	/*
	 * Test que comprueba el getter de ID.
	 * */
	@Test
	public void getIdTest() {
		Shooter Player=new Shooter(3);
		assertEquals(3, Player.getId());
	}
}
