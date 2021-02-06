


void readF(File f){ //file -> tp
	FileReader fr = null;//���������ʱ�ȭ������Ѵ�.
	BufferedReader br = null;
	try{
		String line = "";
		StringBuffer sb = new StringBuffer(); //��Ʈ������Ƴ��±׸� sb
		fr = new FileReader(f);
		br = new BufferedReader(fr); //����
		while((line = br.readLine()) != null){
			sb.append(line + "\n"); //��ĭ�پ �������ִ´�. ���� \n�������ʰ� �����̵Ǽ� ������°�
		}
		String result = sb.toString(); //���ڿ��ιٲ��
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
		String content = tp.getText(); // ���� �������°�

		FileWriter fw = null;
		PrintWriter pw = null; //����. ��������! ǥ������Ҷ� ���־���.
		try{
			fr = new FileWriter(f);
			pw = new PrintWriter(fw, true); // true�������� flush �����൵�ȴ�.
			pw.println(content);
		}catch(IOException ie){
		}finally{
			try{
				if(pw != null) pw.close();
				if(fw != null) fw.close();
			}catch(IOException ie){}
		}
	}
