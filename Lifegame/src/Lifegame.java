import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Lifegame extends JFrame{
private final Map map;
	
	public Lifegame(int rows, int columns)
	{
		map = new Map(rows, columns);
		new Thread(map).start();
		add(map);
	}

	public static void main(String[] args)
    {
	    	Lifegame frame = new Lifegame(40, 50);
	    	
	        JMenuBar menu = new JMenuBar();
	        frame.setJMenuBar(menu);
	        
	        JMenu options = new JMenu("Options");
	        menu.add(options);
	        
	        JMenuItem start = options.add("start");
	        start.addActionListener(frame.new startActionListener());
	        
	        //此功能暂不可用
	        JMenuItem setmap = options.add("set map");
	        setmap.addActionListener(frame.new setmapActionListener());
	        JMenuItem help = options.add("help");
	        
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(1007, 859);
	        frame.setTitle("Cell Life Game");
	        frame.setVisible(true);
	        frame.setResizable(false);
	    
	    }	
	  class startActionListener implements ActionListener
	    {
	    	public void actionPerformed(ActionEvent e) 
	    	{
	    		map.setMap();
	    	}
	    }
	    
	  class setmapActionListener implements ActionListener
	    {
	    	public void actionPerformed(ActionEvent e) 
	    	{
	    		map.setMapByself();
	    	}
	    }
	}