package dao;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LogDao {
	static int prelines = 324;
	static int tdnum = 1000;
	static int uplimit = prelines + tdnum + 31;
	static int count = 0;
	static String logPathString = null;

	public static boolean addaLog(String logstring, String apath, String uname) {
		count = 0;
		logPathString = apath + "pages/LogManage.jsp";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = "<tr><td>" + df.format(new Date()) + "</td>" + "<td>"
				+ logstring + "</td>" + "<td>"+uname+"</td></tr>";

		try {
			BufferedReader first = new BufferedReader(new FileReader(
					logPathString));

			while (first.readLine() != null) {
				count++;
			}
			first.close();
			System.out.println(count);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		if (count >= uplimit) {
			if (modifylog(logstring))
				return true;
			else
				return false;
		} else {
			try {
				BufferedReader read = new BufferedReader(new FileReader(
						logPathString));
				String pre[] = new String[prelines];
				String bnd[] = new String[count];

				for (int i = 0; i < count; i++) {
					if (i < prelines)
						pre[i] = read.readLine();
					else
						bnd[i] = read.readLine();
				}
				read.close();

				BufferedWriter bfwrite = new BufferedWriter(new FileWriter(
						logPathString));
				for (int i = 0; i < count + 1; i++) {
					if (i < prelines) {
						bfwrite.write(pre[i]);
						bfwrite.newLine();
					} else if (i > prelines) {
						bfwrite.write(bnd[i - 1]);
						bfwrite.newLine();
					} else {
						bfwrite.write(str);
						bfwrite.newLine();
					}
				}

				bfwrite.close();
				pre = null;
				bnd = null;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}

			return true;
		}
	}
	
	public static boolean modifylog(String logstring) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = "<tr><td>" + df.format(new Date()) + "</td>" + "<td>"
				+ logstring + "</td>" + "<td><Button>É¾³ý</Button></td></tr>";
		try {
			BufferedReader read = new BufferedReader(new FileReader(
					logPathString));
			String pre[] = new String[prelines];
			String td[] = new String[prelines + tdnum];
			String bnd[] = new String[count];

			for (int i = 0; i < count; i++) {
				if (i < prelines)
					pre[i] = read.readLine();
				else if(i < (prelines + tdnum) && i >= prelines)
					td[i] = read.readLine();
				else
					bnd[i] = read.readLine();
			}
			read.close();
			
			BufferedWriter bfwrite = new BufferedWriter(new FileWriter(
					logPathString));
			for (int i = 0; i < count + 1; i++) {
				if (i < prelines) {
					bfwrite.write(pre[i]);
					bfwrite.newLine();
				} else if (i > prelines && i < (prelines + tdnum)) {
					bfwrite.write(td[i-1]);
					bfwrite.newLine();
				}else if(i > (prelines + tdnum)){
					bfwrite.write(bnd[i-1]);
					bfwrite.newLine();
				} else if(i == prelines){
					bfwrite.write(str);
					bfwrite.newLine();
				}
			}

			bfwrite.close();
			pre = null;
			bnd = null;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}
}
