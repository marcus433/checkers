package edu.sjsu.cs.cs151.checkers.view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;

import edu.sjsu.cs.cs151.checkers.layout.*;
import edu.sjsu.cs.cs151.checkers.view.Piece.Type;

// custom button was needed for our use case
public class Button extends View implements Layout {	
	public Button(BufferedImage icon) {
		super();
		setOpaque(false);
		usesIcon = true;
		restartIcon = icon;
		setBackground(Color.WHITE);
		Button that = this;
		addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent e) {
				that.onPressDown();
			}
			
			public void mouseClicked(java.awt.event.MouseEvent e) {
				that.onPressUp();
				that.actionHandler(e);
			}
		});
	}

	public Button(String text) {
		super();
		setOpaque(false);
		this.label = new Label(text);
		this.label.setForeground(Color.WHITE);
		add(this.label);
		this.label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(label.getFont().deriveFont(16f));
		setBackground(Color.WHITE);
		Button that = this;
		addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent e) {
				that.onPressDown();
			}
			
			public void mouseClicked(java.awt.event.MouseEvent e) {
				that.onPressUp();
				that.actionHandler(e);
			}
		});
	}

	public void setText(String text) {
		this.label.setText(text);
		this.invalidate();
		this.repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(
	            RenderingHints.KEY_ANTIALIASING,
	            RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(new Color(pressed ? 0x061941 : 0x0A2663));
		int arc = 40;
		g2.fillRoundRect(0, 0, g2.getClipBounds().width, g.getClipBounds().height, arc, arc);
		paintChildren(g);
		if (usesIcon) {
			double iconWidth = g2.getClipBounds().width * 0.50;
			int iconHeight = (int) (iconWidth * (restartIcon.getHeight() / restartIcon.getWidth()));
			
			int x = (int) (g2.getClipBounds().width / 2.0 - (iconWidth / 2.0));
			int y = (int) (g2.getClipBounds().height / 2.0 - (iconHeight / 2.0));
			
			g2.drawImage(restartIcon, x, y, (int)iconWidth, iconHeight, g2.getColor(), null);
		}
	}
	
	public void renderWithSize(Dimension size, Point location) {
		//setSize(140, (int)size.getHeight());
		setLocation(location);
		if (!usesIcon) {
			label.setSize(getSize());
			label.setLocation(0, FONT_OFFSET);
		}
		Layout layout = layoutThatFits();
		if (layout != null)
			layout.renderWithSize(size, location);
	}
	
	public Layout layoutThatFits() {
		return null;
	}
	
	@Override
	public Dimension getDisplaySize(Dimension size, Point location) {
		return usesIcon ? new Dimension(40, 40) : new Dimension(140, 40);
	}
	
	public void actionHandler(java.awt.event.MouseEvent e) {

	}
	
	public void onPressUp() {
		this.pressed = false;
		this.repaint();
	}
	
	public void onPressDown() {
		this.pressed = true;
		this.repaint();
	}
	
	// Private fields
	
	private Label label;
	private static int FONT_OFFSET = 2;
	private boolean pressed = false;
	private boolean usesIcon = false;
	private BufferedImage restartIcon;
}