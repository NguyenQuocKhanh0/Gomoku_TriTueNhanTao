import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.*;


public class MainGUI extends JFrame {
	JPanel bPane = new JPanel();
	Board board = new Board(400, 16);
	JTextArea cmtLabel = new JTextArea();
	//private final JPanel cmtPanel;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int difficulty;
	private boolean computerStarts;
	
	private JPanel boardPanel;
	private final JPanel setupPanel;
	private final JPanel difficultyPanel;
	private final JPanel startingPlayerPanel;
	
	
	private final JButton buttonStart;
	private final JButton buttonReset;
	private final JRadioButton rbNormal;
	private final JRadioButton rbHard;
	
	private final JRadioButton rbHuman;
	private final JRadioButton rbComputer;
	
	private final ButtonGroup bgDifficulty ;
	private final ButtonGroup bgStartingPlayer;
	
	private final JLabel taDifficulty;
	//private final JLabel taStartingPlayer;
	
	public MainGUI(int width, int height, String title) {
		cmtLabel.setText("--------------------------------Minimax Score-------------------------------\n");
		//setDefaultLookAndFeelDecorated(true);
		setLayout(new BorderLayout());
		setSize(width, height);
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//cmtPanel = new JPanel();
		setupPanel = new JPanel();
		setupPanel.setLayout(new BoxLayout(setupPanel, BoxLayout.PAGE_AXIS));
		difficultyPanel = new JPanel();
		startingPlayerPanel = new JPanel();
		
		buttonStart = new JButton("New Game");
		buttonReset = new JButton("Reset");
		rbNormal = new JRadioButton("Normal (Faster)");
		rbHard = new JRadioButton("Hard (Slower)");
		
		rbHuman = new JRadioButton("Người chơi trước");
		rbComputer = new JRadioButton("AI chơi trước");
		
		bgDifficulty = new ButtonGroup();
		bgStartingPlayer = new ButtonGroup();
		
		bgDifficulty.add(rbNormal);
		bgDifficulty.add(rbHard);
		
		bgStartingPlayer.add(rbHuman);
		bgStartingPlayer.add(rbComputer);
		
		taDifficulty = new JLabel("Difficulty: ");
		//taStartingPlayer = new JLabel("starts first.");
		//cmtLabel = new JTextArea();
		
		//cmtLabel.setPreferredSize(new Dimension(350,0));
		//cmtLabel.setSize(100, 200);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(cmtLabel);
		//cmtLabel.setLineWrap(true);
		/* 
		cmtPanel.add(cmtLabel);
		cmtPanel.add(scrollPane);
		cmtPanel.setSize(300,100);
		cmtPanel.setBounds(10, 0, 100, 100);
		*/
		//cmtLabel.setText("title");
		rbNormal.setSelected(true);
		rbComputer.setSelected(true);
		
		difficultyPanel.add(taDifficulty);
		difficultyPanel.add(rbNormal);
		difficultyPanel.add(rbHard);
		
		startingPlayerPanel.add(rbComputer);
		startingPlayerPanel.add(rbHuman);
		//startingPlayerPanel.add(taStartingPlayer);
		
		//setupPanel.add(difficultyPanel);
		setupPanel.add(startingPlayerPanel);
		startingPlayerPanel.add(buttonStart);
		
		startingPlayerPanel.add(buttonReset);
		//bPane.setLayout(new BorderLayout());
		//bPane.add(setupPanel, BorderLayout.EAST);
		//bPane.add(board.getGUI(), BorderLayout.WEST);
		//bPane.add(cmtPanel,BorderLayout.SOUTH);
		//bPane.add(cmtPanel);
		//bPane.add(scrollPane,BorderLayout.SOUTH);
		//scrollPane.setLayout(new BoxLayout(scrollPane, BoxLayout.PAGE_AXIS));
		add(setupPanel,BorderLayout.SOUTH );
		//scrollPane.setSize(400,400);
		add(scrollPane, BorderLayout.EAST);
		add(board.getGUI());
		//add(cmtLabel, BorderLayout.SOUTH);
		

		//bPane.setSize(500, 500);
		//bPane.add(board.getGUI(), BorderLayout.WEST);
		//add(bPane);
		
		//pack();
	}
	/*
	 * 	Reads components to fetch and return the chosen settings.
	 */
	public Object[] fetchSettings() {
		if( rbHard.isSelected() ) {
			difficulty = 4;
		} else difficulty = 3;
		
		computerStarts = rbComputer.isSelected();
		Object[] x = {difficulty, computerStarts};
		return x;
	}
	public void listenGameStartButton(ActionListener listener) {
		buttonStart.addActionListener(listener);
	}
	public void listenGameStartButton2(ActionListener listener) {
		buttonReset.addActionListener(listener);
	}
	public void attachBoard(JPanel board) {
		boardPanel = board;
	}
	public void showBoard() {
	//	bPane.add(boardPanel, BorderLayout.WEST);
		board.getGUI().setVisible(false);
		invalidate();
		validate();
		add(boardPanel,BorderLayout.WEST);
		//pack();
	}
	public void writeLabel(String string){
		this.cmtLabel.setText(string);
	}
	
	
}
