package com.calvin.cake;

public class RectangleIntercept {
	public static class Rectangle {
		public final static Rectangle NULL_RECTANGLE = new Rectangle(0, 0, 0, 0);
		
	    // coordinates of bottom left corner
	    private int leftX;
	    private int bottomY;

	    // dimensions
	    private int width;
	    private int height;

	    public Rectangle(int leftX, int bottomY, int width, int height) {
	        this.leftX = leftX;
	        this.bottomY = bottomY;
	        this.width  = width;
	        this.height = height;
	    }

	    public int getLeftX() {
	        return leftX;
	    }

	    public int getBottomY() {
	        return bottomY;
	    }

	    public int getWidth() {
	        return width;
	    }

	    public int getHeight() {
	        return height;
	    }
	    
	    public boolean overlaps(Rectangle other){
	    	int rightX = this.leftX + this.width;
	    	int topY = this.bottomY + this.height;
	    	int otherRightX = other.leftX + other.width;
	    	int otherTopY = other.bottomY + other.height;
	    	
	    	// Check if X overlaps and Y overlaps.
	    	if (this.leftX > otherRightX || rightX < other.leftX){
	    		return false;
	    	}
	    	else if (this.bottomY > otherTopY || topY < other.bottomY){
	    		return false;
	    	}
	    	return true;
	    }
	    
	    public Rectangle interects(Rectangle other){
	    	if (overlaps(other)){
	    		int leftX = Math.max(other.leftX, this.leftX);
	    		int rightX = Math.min(other.leftX + other.width, this.leftX + this.width);
	    		int bottomY = Math.max(other.bottomY, this.bottomY);
	    		int topY = Math.min(other.bottomY + other.height, this.bottomY + this.height);
	    		return new Rectangle(leftX, bottomY, rightX - leftX, topY - bottomY);
	    	}
	    	return NULL_RECTANGLE;
	    }

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + bottomY;
			result = prime * result + height;
			result = prime * result + leftX;
			result = prime * result + width;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Rectangle other = (Rectangle) obj;
			if (bottomY != other.bottomY)
				return false;
			if (height != other.height)
				return false;
			if (leftX != other.leftX)
				return false;
			if (width != other.width)
				return false;
			return true;
		}
	    
	    @Override
	    public String toString() {
	    	return "leftX: " + this.leftX + ", rightX: " + (this.leftX + this.width) + ", bottomY: " + this.bottomY + ", topY: " + (this.bottomY + this.height);
	    }
	}
	
	/**
	 * Given two rectangles are parallel to x-axis or y-axis
	 * 
	 * 
	 * @param rect1
	 * @param rect2
	 * @return
	 */
	public static Rectangle intercept(Rectangle rect1, Rectangle rect2){
		return rect1.interects(rect2);
	}
}
