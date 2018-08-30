package practice_1;
//
//public class Calculator_1 {
//
//	public static void main(String[] args){
//		int result;
//		 int num1=10;
//		int num2=5;
//		result=multiply(num1, num2);
//		int result2 = divide( num1, num2);
//	}
//	
//	public static int multiply(int num1 ,int num2){
//		return num1*num2;
//	}
//	
//	public static int divide(int num1 ,int num2){
////		if(num2!=0)
//		return num1/num2;
////		else 
////		return (Integer) null;
//	}
//}
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
 
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
 
 
public class Calculator {
    public static void main(String[] args){
        try{
            String command = "ls -la";
            String host = "192.168.35.59";
            String user = "amans";
            String password = "Saini@9op0";
             
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, 22);
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);;
            session.setPassword(password);
            session.connect();
             
            Channel channel = session.openChannel("exec");
            ((ChannelExec)channel).setCommand(command);
            channel.setInputStream(null);
            ((ChannelExec)channel).setErrStream(System.err);
             
            InputStream input = channel.getInputStream();
            channel.connect();
             
            System.out.println("Channel Connected to machine " + host + " server with command: " + command ); 
             
            try{
                InputStreamReader inputReader = new InputStreamReader(input);
                BufferedReader bufferedReader = new BufferedReader(inputReader);
                String line = null;
                 
                while((line = bufferedReader.readLine()) != null){
                    System.out.println(line);
                }
                bufferedReader.close();
                inputReader.close();
            }catch(IOException ex){
                ex.printStackTrace();
            }
             
            channel.disconnect();
            session.disconnect();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}