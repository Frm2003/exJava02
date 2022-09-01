package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import view.main;

public class KillController {
	public void chamaProcesso(String processo) {
		try {
			Process r = Runtime.getRuntime().exec(processo); 
			InputStream in = r.getInputStream();
			InputStreamReader inR = new InputStreamReader(in);
			BufferedReader buffer = new BufferedReader(inR);
			String linha = buffer.readLine();
			
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			
			buffer.close(); inR.close(); in.close();
			
 		} catch (Exception e) { System.out.println(e); }
	}
	
	public void mataProcessoPid(int param, String so) {
		String cmdPid = " ";
		if (so.contains("Windows")) { cmdPid = "TASKKILL /PID"; } else { cmdPid = "kill -9"; }
		StringBuffer buffer = new StringBuffer();
		
		try {
			buffer.append(cmdPid);
			buffer.append(" ");
			buffer.append(param);
		} catch (Exception e) { System.out.println(e); }
		
		chamaProcesso(buffer.toString());
	}
	
	public void mataProcessoNome(String param, String so) {
		String cmdNome = " ";
		if (so.contains("Windows")) { cmdNome = "TASKKILL /IM"; } else { cmdNome = "pkill -f"; } 
		StringBuffer buffer = new StringBuffer();
		
		try {
			buffer.append(cmdNome);
			buffer.append(" ");
			buffer.append(param);
		} catch (Exception e) { System.out.println(e); }
		
		chamaProcesso(buffer.toString());
	}
}
