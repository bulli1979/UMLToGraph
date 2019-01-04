package com.me.umltograph.files;

public enum ShapeType {
	INITIAL("Initial node",0), 
	ACTION("Action",1), 
	CONNECTOR("Dynamic connector",2), 
	DECISION("Decision",3),
	FINAL("Final node",4),
	MERGE("Merge Node",5),
	FORK_NODE("Fork node",6),
	JOIN_NODE("Join node",7);
	private String uName;
	private int master = 0;
	private int type;
	private ShapeType(String uname,int type) {
		this.uName = uname;
		this.type = type;
	}

	public static ShapeType getByMasterOrName(int master, String uName) {
		
		for (ShapeType st : ShapeType.values()) {
			if (uName != null && uName.equals(st.uName)) {
				st.master = master;
				return st;
			}else if(st.master == master) {
				return st;
			}
		}
		System.out.println(master + " " + uName);
		return null;
	}
	
	public int getType() {
		return this.type;
	}

}
