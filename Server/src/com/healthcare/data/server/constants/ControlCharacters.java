package com.healthcare.data.server.constants;

public enum ControlCharacters implements CharTableData {
	
	/**
	 * Null
	 */
	NULL{
		public int getCode(){ return 0x00;}
	},
	/**
	 * Start of heading
	 */
	SOH{
		public int getCode(){return 0x01;}
	},
	/**
	 * Start of Text
	 */
	STX{
		public int getCode(){return 0x02;}
	},
	/**
	 * End of Text
	 */
	ETX{
		public int getCode(){return 0x03;}
	},
	/**
	 * ENd of Transmission
	 */
	E0T{
		public int getCode(){return 0x04;}
	},
	/**
	 * Enquiry
	 */
	ENQ{
		public int getCode(){return 0x05;}
	},
	/**
	 * Acknowledge
	 */
	ACK{
		public int getCode(){return 0x06;}
	},
	/**
	 * Bell
	 */
	BEL{
		public int getCode(){return 0x07;}
	},
	/**
	 * Backspace
	 */
	BS{
		public int getCode(){return 0x08;}
	},
	/**
	 * Horizontal Tab
	 */
	TAB{
		public int getCode(){return 0x09;}
	},
	/**
	 * Line Feed
	 */
	LF{
		public int getCode(){return 0x0A;}
	},
	/**
	 * Vertical Tabulation
	 */
	VT{
		public int getCode(){return 0x0B;}
	},
	/**
	 * Form Feed
	 */
	FF{
		public int getCode(){return 0x0C;}
	},
	/**
	 * Carriage Return
	 */
	CR{
		public int getCode(){return 0x0D;}
	},
	/**
	 * Shift Out
	 */
	SO{
		public int getCode(){return 0x0E;}
	},
	/**
	 * Shift In
	 */
	SI{
		public int getCode(){return 0x0F;}
	},
	/**
	 * Data Link Escape
	 */
	DLE{
		public int getCode(){return 0x10;}
	},
	/**
	 * Device Control 1
	 */
	DC1{
		public int getCode(){return 0x11;}
	},
	/**
	 * Device Control 2
	 */
	DC2{
		public int getCode(){return 0x12;}
	},
	/**
	 * Device Control 3
	 */
	DC3{
		public int getCode(){return 0x13;}
	},
	/**
	 * Device Control 4
	 */
	DC4{
		public int getCode(){return 0x14;}
	},
	/**
	 * Negative Acknowledge
	 */
	NAK{
		public int getCode(){return 0x15;}
	},
	/**
	 * Synchronous Idle
	 */
	SYN{
		public int getCode(){return 0x16;}
	},
	/**
	 * End of Transmission Block
	 */
	ETB{
		public int getCode(){return 0x17;}
	},
	/**
	 * Cancel
	 */
	CAN{
		public int getCode(){return 0x18;}
	},
	/**
	 * End of Medium
	 */
	EM{
		public int getCode(){return 0x19;}
	},
	/**
	 * Substitute
	 */
	SUB{
		public int getCode(){return 0x1A;}
	},
	/**
	 * Escape
	 */
	ESC{
		public int getCode(){return 0x1B;}
	},
	/**
	 * File Separator
	 */
	FS{
		public int getCode(){return 0x1C;}
	},
	/**
	 * Group Separator
	 */
	GS{
		public int getCode(){return 0x1D;}
	},
	/**
	 * Record Separator
	 */
	RS{
		public int getCode(){return 0x1E;}
	},
	/**
	 * Unit Separator
	 */
	US{
		public int getCode(){return 0x1F;}
	}
	
	
}
