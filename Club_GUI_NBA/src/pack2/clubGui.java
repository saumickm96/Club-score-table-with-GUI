package pack2;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

public class clubGui implements ActionListener {
		public static void main (String args[]) {
			JFrame f = new JFrame("club GUI");
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setLayout(new GridLayout(0,3));
			f.setSize(300, 300);
			f.setVisible(true);
			
			
			List<Club> table = Arrays.asList(
					new Club(1, "Warriors", 60, 57, 1, 2, 52, 30, 27),
					new Club(2, "Nuggets", 60, 54, 0, 6, 48, 34, 20),
					new Club(3, "Trail Blazers", 60, 53, 1, 6, 42, 32, 21),
					new Club(4, "Rockets", 60, 53, 1, 6, 40, 31, 22),
					new Club(5, "Jazz", 60, 50, 2, 8, 40, 29, 21),
					new Club(6, "Thunder", 60, 50, 2, 8, 38, 27, 23),
					new Club(7, "Spurs", 60, 49, 0, 11, 36, 32, 17),
					new Club(8, "Clippers", 60, 48, 0, 12, 35, 20, 28),
					new Club(9, "Kingsr", 60, 48, 1, 11, 32, 26, 22),
					new Club(10, "Lakers", 60, 39, 1, 20, 27, 26, 13),
					new Club(11, "Timberwolves", 60, 37, 1, 22, 21, 20, 17),
					new Club(12, "Grizzlies", 60, 36, 0, 24, 11, 22, 14));
			
			
			JButton b1 = new JButton("FunctionList");
			b1.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				Club.functionalList(table);
				}
			});
			JButton b2 = new JButton("streamToList");
			b2.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				Club.streamToList();
				}
			});
			JButton b3 = new JButton("integerStreams");
			b3.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				Club.integerStreams(table);
				}
			});
			JButton b4 = new JButton("reduceStream");
			b4.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				Club.reduceStream(table);
				}
			});
			JButton b5 = new JButton("transformStream");
			b5.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				Club.transformStream(table);
				}
			});
			JButton b6 = new JButton("customisedSorting");
			b6.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Club.customisedSorting();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			});
			JButton b7 = new JButton("processFile");
			b7.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Club.processFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			});
			
			JButton b8 = new JButton("Exit");
			b8.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				}
			});
			
			f.add(b1);
			f.add(b2);
			f.add(b3);
			f.add(b4);
			f.add(b5);
			f.add(b6);
			f.add(b7);
			f.add(b8);
			
			
			
			
		}
		

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}


