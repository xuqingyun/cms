package com.cnv.cms.event;

public enum EventType {
	LIKE(0),
	FOLLOW(1),
	UNFOLLOW(2),
	MESSAGE(3),
	DELETE_ART(4),
	PV_COUNT(5),
	TIME_COUNT(6),
	COMMENT(7),
	NEWS_PUBLISH(8);
	
	private int value;
	EventType(int value){ this.value = value;}
	public int getValue(){ return this.value;}
}
