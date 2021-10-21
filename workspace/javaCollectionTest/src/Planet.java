	public enum Planet {
		수성(2439), 
		금성(6052), 
		지구(6371), 
		화성(3390), 
		목성(69911), 
		토성(58232), 
		천왕성(25362), 
		해왕성(24622);
	
	private int p;
	

	Planet(int data) {
		p = data;
	}
	
	public int getL() {
		return p;
	}
	
	public static void main(String[] args) {
		
		Planet[] enumArr = Planet.values();
		float pi = 3.141592f;
		for(int i = 0; i < enumArr.length; i++) {
			System.out.println(enumArr[i].name() + " : " + enumArr[i].getL() 
					+ "\t=>\t" + "면적 : "+ enumArr[i].getL()*enumArr[i].getL()*pi*4 +" Km²");
		}
	}	
}