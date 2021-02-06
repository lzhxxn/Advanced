


void readF(File f){ //file -> tp
	FileReader fr = null;//지역변수초기화해줘야한다.
	BufferedReader br = null;
	try{
		String line = "";
		StringBuffer sb = new StringBuffer(); //스트링을담아놓는그릇 sb
		fr = new FileReader(f);
		br = new BufferedReader(fr); //필터
		while((line = br.readLine()) != null){
			sb.append(line + "\n"); //한칸뛰어서 라인을넣는다. 간격 \n을읽지않고 기준이되서 띄어지는것
		}
		String result = sb.toString(); //문자열로바뀐다
		tp.setText(result);
	}catch(IOException ie){
	}finally{
		try{
			if(br != null) br.close();
			if(fr != null) fr.close();
		}catch(IOException ie){}
	}
}
	void writeF(File f){ //tp -> file
		String content = tp.getText(); // 값을 가져오는거

		FileWriter fw = null;
		PrintWriter pw = null; //필터. 좋은필터! 표준출력할때 자주쓴다.
		try{
			fr = new FileWriter(f);
			pw = new PrintWriter(fw, true); // true가있으면 flush 안해줘도된다.
			pw.println(content);
		}catch(IOException ie){
		}finally{
			try{
				if(pw != null) pw.close();
				if(fw != null) fw.close();
			}catch(IOException ie){}
		}
	}
