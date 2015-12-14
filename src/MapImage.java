import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Vector;

import javax.swing.JComponent;

	public class MapImage extends JComponent {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Image background;
		private Vector<LocImage> sprites;
		
		public MapImage() {
			this( null );
		}

		public MapImage( Image background ) {
			this.background = background;
			sprites = new Vector<LocImage>();
		}

		public Dimension getPreferredSize() {
			Dimension d = super.getPreferredSize();
			if( background != null ) {            
				d = new Dimension( background.getWidth( this ), background.getHeight( this ) );
			} 
			return( d );
		}

		public void paintComponent( Graphics g ) {      
			if ( background != null ) {          
				g.drawImage( background, 0, 0, this );        
			}
			LocImage s = null;
			int size = sprites.size();
			for ( int i = 0; i < size; i++ ) 
			{
				s = (LocImage)sprites.get( i );
				s.paintLocImage( g );
			}
		}

		public Image getBackgroundImage() {
			return background;
		}

		public void setBackgroundImage( Image i ) {
			background = i;
			validate();
			repaint(); 
		}

		public void addLocImage( Image locOrClose, Location location ) {
			LocImage s = new LocImage( locOrClose );
			s.setX( location.getPos_x()-10 );
			s.setY( location.getPos_y()-10 );
			sprites.add( s );
			repaint();
		}


		private class LocImage {
			private boolean drawBorder;
			private Image image;
			private int x, y;

			public LocImage( Image image ) {
				this.image = image;
			}

			public void paintLocImage( Graphics g ) {
				if ( image != null ) {
					g.drawImage( image, x, y, null );
				}
				if ( drawBorder ) {
					g.setColor( Color.red );
					g.drawRect( x, y, getWidth(), getHeight() );
				}
			}

			public void setX( int x ) {
				this.x = x;
			}

			public void setY( int y ) {
				this.y = y;
			}

			public int getWidth() {
				int w = 0;
				if ( image != null ) {
					w = image.getWidth( null );
				}
				return w;
			}

			public int getHeight() {
				int h = 0;
				if ( image != null ) {
					h = image.getHeight( null );
				}
				return h;
			}

		}

	}