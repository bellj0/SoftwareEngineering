/**
 * This module was created mainly to assist in the painting of multiple images
 * on top of one another. This makes it possible to display the location of
 * the incidents and the closest vehicle on the map without having a ton of
 * storage space for the maps.
 *  @author Joshua Bell
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Vector;
import javax.swing.JComponent;

	public class MapImage extends JComponent 
	{
		private static final long serialVersionUID = 1L;
		private Image background;
		private Vector<LocImage> sprites;
		
		/**
		 * Constructor with no parameters.
		 */
		public MapImage() 
		{
			this( null );
		}

		/**
		 * Constructor that takes the background image and sets up the images
		 * that are being placed over it .
		 * @param background
		 */
		public MapImage( Image background ) 
		{
			this.background = background;
			sprites = new Vector<LocImage>();
		}

		/* (non-Javadoc)
		 * @see javax.swing.JComponent#getPreferredSize()
		 */
		public Dimension getPreferredSize() 
		{
			Dimension d = super.getPreferredSize();
			if( background != null ) 
			{            
				d = new Dimension( background.getWidth( this ), background.getHeight( this ) );
			} 
			return( d );
		}

		/* (non-Javadoc)
		 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
		 */
		public void paintComponent( Graphics g ) 
		{      
			if ( background != null ) 
			{          
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

		/**
		 * Gets the current background image.
		 * @return background image
		 */
		public Image getBackgroundImage() 
		{
			return background;
		}

		/**
		 * Sets up a new background image.
		 * @param image for the background
		 */
		public void setBackgroundImage( Image i ) 
		{
			background = i;
			validate();
			repaint(); 
		}

		/**
		 * Used to add an overlaying image based on the image and location
		 * given.
		 * @param locOrClose
		 * @param location
		 */
		public void addLocImage( Image locOrClose, Location location ) 
		{
			LocImage s = new LocImage( locOrClose );
			s.setX( location.getPos_x()-10 );
			s.setY( location.getPos_y()-10 );
			sprites.add( s );
			repaint();
		}


		/**
		 * @author Joshua
		 *
		 */
		private class LocImage 
		{
			private boolean drawBorder;
			private Image image;
			private int x, y;

			/**
			 * Constructor that takes an image ready to be placed on top
			 * of the background.
			 * @param image
			 */
			public LocImage( Image image ) 
			{
				this.image = image;
			}

			/**
			 * Used to help with painting image on top of background
			 * @param graphic
			 */
			public void paintLocImage( Graphics g ) 
			{
				if ( image != null ) 
				{
					g.drawImage( image, x, y, null );
				}
				if ( drawBorder ) 
				{
					g.setColor( Color.red );
					g.drawRect( x, y, getWidth(), getHeight() );
				}
			}

			/**
			 * Sets the x-position of the overlaying image.
			 * @param x
			 */
			public void setX( int x ) 
			{
				this.x = x;
			}

			/**
			 * Sets the y-position of the overlaying image.
			 * @param y
			 */
			public void setY( int y ) 
			{
				this.y = y;
			}

			
			/**
			 * Returns the width of the image
			 * @return width
			 */
			public int getWidth() 
			{
				int w = 0;
				if ( image != null ) 
				{
					w = image.getWidth( null );
				}
				return w;
			}

			/**
			 * Returns the height of the image
			 * @return height
			 */
			public int getHeight() 
			{
				int h = 0;
				if ( image != null ) 
				{
					h = image.getHeight( null );
				}
				return h;
			}

		}

	}