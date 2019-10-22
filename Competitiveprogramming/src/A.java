class A{
	
	public static void main(String args[]){
		String[] str = {"123","des12","redsd"};


		for(String s:str){
			if(s.matches("\\d+")){
				System.out.println(s);
			}
		} 
	}
}
