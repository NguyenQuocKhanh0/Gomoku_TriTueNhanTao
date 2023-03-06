import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.*;
import java.awt.Desktop;

public class MainClass {
	static ArrayList<Board> boardn = new ArrayList<Board>();
	static ArrayList<Game> gamen =  new ArrayList<Game>();
	static int i=-1;
	final static int width = 400;
	public static MainGUI gui = new MainGUI(width*2-10,500, "Gomoku");
		
	public static void main(String[] args) {
		
		// Create the MainGUI instance.
		
		
		
		Board board = new Board(width, 16);
		
		// Create the Game manager instance.
		final Game game = new Game(board);
		
		// Attach the game board's GUI component to the main frame.
		gui.attachBoard(board.getGUI());
		
		// Make the frame wrap the contents and set it visible.
		//gui.pack();
		gui.setVisible(true);
		
		// Start listening for the Game Start button click.
		gui.listenGameStartButton(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				// Get the settings from the Main GUI manager.
				Object[] settings = gui.fetchSettings();
				int indepth = (Integer)(settings[0]);
				boolean computerStarts = (Boolean)(settings[1]);
				
				System.out.println("Depth: " + indepth + " AI Makes the first move: " + computerStarts );
 /*
				
				i++;
				boardn.add(new Board(400,15+i));
				gamen.add(new Game(boardn.get(i)));
				//gamen.get(i).Reset();
				//gamen.get(i).setBoard(boardn.get(i));
				// Make the game board visible to the user.
				
				//Board board2 = new Board(width, 15);;
				//Game game = new Game(board);
				gui.attachBoard(boardn.get(i).getGUI());
				
				
				
				
				
				// Apply the settings.
				gamen.get(i).setAIDepth(depth);
				gamen.get(i).setAIStarts(computerStarts);
				gui.showBoard();
				// Start the game.
				gamen.get(i).start();
				*/
				
				gui.showBoard();
				game.setAIStarts(computerStarts);
				game.start();
				
			}
			
		});
		
		gui.listenGameStartButton2(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn chơi lại từ đầu không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) {
					RestartGame();
					System.exit(0);
				}
			}
		});
	}
	public static void RestartGame() {
	Desktop desktop = Desktop.getDesktop();
    	try {desktop.open(new File("Gomoku.jar").getCanonicalFile());
	// desktop.open(new File("name_of_your_exe.exe").getCanonicalFile());//for exe
        } catch (IOException e) {
            //if this happen try looking whether the name of your jar file is correct
            e.printStackTrace();
        }
}	
}
