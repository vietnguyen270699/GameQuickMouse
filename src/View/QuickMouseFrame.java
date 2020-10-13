package View;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class QuickMouseFrame extends JFrame {
	private JButton play, help, information, exit;
	private ImageIcon backgroudgame;
	private boolean active = false;
	GamePanel gamePanel;
	JPanel pnbutton;

	public QuickMouseFrame() {
		pnbutton = new JPanel();

		backgroudgame = new ImageIcon("image/backgroundframe.jpg");
		play = new JButton("Play Game");
		help = new JButton("Help");
		information = new JButton("About");
		exit = new JButton("Exit");
		pnbutton.setLayout(new BorderLayout());
		pnbutton.add(play, BorderLayout.CENTER);
		JPanel pn1 = new JPanel();
		pn1.setLayout(new GridLayout(3, 1));
		pn1.add(information);
		pn1.add(help);
		pn1.add(exit);
		pnbutton.add(pn1, BorderLayout.EAST);
		setTitle("QuickMouse");
		addListenner();
		setSize(700, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	public void paint(Graphics g) {
		if (!active) {
			g.drawImage(backgroudgame.getImage(), 0, 0, 700, 600, null);
			setLayout(new BorderLayout());
			add(pnbutton, BorderLayout.SOUTH);
		} else {
			paintComponents(g);
		}
	}

	public void addListenner() {
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gamePanel = new GamePanel();
				active = true;
				repaint();
				setContentPane(gamePanel);
				gamePanel.requestFocusInWindow();
			}
		});

		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,
						"Bạn sẽ có 3 mạng chơi." + "\n" + "Sử dụng chuột để điều khiển sang trái hoặc phải,"
								+ "hứng pho_mát , mỗi mẫu pho_mát hứng được sẽ được cộng một điểm" + "\n"
								+ "không hứng được sẽ bị mất một mạng." + "\n"
								+ "Đồng thời cũng phải tránh các chú mèo , nếu va phải mèo thì trò chơi kết thúc.",
						"Hướng dẫn :", EXIT_ON_CLOSE);
			}
		});

		information.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "17130272__Nguyễn Quốc Việt", "Thành viên :", EXIT_ON_CLOSE);
			}
		});
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int kq = JOptionPane.showConfirmDialog(null, "Bạn muốn thoát game", "Thông báo",
						JOptionPane.YES_NO_OPTION);
				if (kq == 0) {
					System.exit(0);

				}
			}
		});
	}
}