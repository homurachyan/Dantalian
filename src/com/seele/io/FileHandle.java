package com.seele.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandle {

	public static void main(String[] args) {
		//File.separator适应系统的分隔符
		File file = new File("M:"+File.separator+"Working"+File.separator+"GitHub"+File.separator+"Dantalian"+File.separator+"hio.txt");  
		String path = "M:"+File.separator+"Working"+File.separator+"GitHub"+File.separator+"Dantalian"+File.separator+"hio.txt";
		try {
			//fileWriter(path);
			//fileReader(path);
			fileInputStream(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//使用字符流读文件
	public static void fileReader(String path) throws IOException{
		FileReader reader = null;
		try {
			reader = new FileReader(path);
			//不同的读取方式
			//方式一：读取单个字符的方式
            //每读取一次，向下移动一个字符单位
/*            int temp1 = r.read();
            System.out.println((char)temp1);
            int temp2 = r.read();
            System.out.println((char)temp2);*/
/*			while(r.read()!=-1){
				int temp = r.read(); //once read a char
				System.out.println((char)temp);
			}*/
                         
            //方式二：循环读取
            //read()方法读到文件末尾会返回-1
            
            while (true) {
                int temp = reader.read();
                if (temp == -1) {
                    break;
                }
                System.out.print((char)temp);
            }
            
             
            //方式三：循环读取的简化操作
            //单个字符读取，当temp不等于-1的时候打印字符
            /*int temp = 0;
            while ((temp = r.read()) != -1) {
                System.out.print((char)temp);
            }
            */
             
            //方式四：读入到字符数组
            /*
            char[] buf = new char[1024];
            int temp = r.read(buf);
            //将数组转化为字符串打印,后面参数的意思是
            //如果字符数组未满，转化成字符串打印后尾部也许会出现其他字符
            //因此，读取的字符有多少个，就转化多少为字符串
            System.out.println(new String(buf,0,temp));
            */
             
            //方式五：读入到字符数组的优化
            //由于有时候文件太大，无法确定需要定义的数组大小
            //因此一般定义数组长度为1024，采用循环的方式读入
            /*
            char[] buf = new char[1024];
            int temp = 0;
            while((temp = r.read(buf)) != -1) {
                System.out.print(new String(buf,0,temp));
            }
            */
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//使用字符流写文件
	public static void fileWriter(String path){
		FileWriter writer = null;
		try {
			//以path为路径创建一个新的FileWriter对象
	        //如果需要追加数据，而不是覆盖，则使用FileWriter（path，true）构造方法
			writer = new FileWriter(path,true);
			//将字符串写入到流中，\r\n表示换行想有好的
			writer.write("Nerxious is a good boy\r\n");
            //如果想马上看到写入效果，则需要调用w.flush()方法
			writer.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            //如果前面发生异常，那么是无法产生w对象的
            //因此要做出判断，以免发生空指针异常
            if(writer != null) {
                try {
                    //关闭流资源，需要再次捕捉异常
                	writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }		
	}
	//使用字节流读文件
	public static void fileInputStream(String path) throws IOException{
		FileInputStream fileInStream = null;
		
		try {
			fileInStream = new FileInputStream(path);
            //方式一：单个字符读取
            //需要注意的是，此处我用英文文本测试效果良好
            //但中文就悲剧了，不过下面两个方法效果良好
/*            int ch = 0;
            while((ch=fileInStream.read()) != -1){
                System.out.print((char)ch);
            }*/
             
            //方式二：数组循环读取
            
            byte[] buf = new byte[1024];
            int len = 0;
            while((len = fileInStream.read(buf)) != -1) {
                System.out.println(new String(buf,0,len));
            }
            
             
             
            //方式三：标准大小的数组读取
            /*
            //定一个一个刚好大小的数组
            //available()方法返回文件的字节数
            //但是，如果文件过大，内存溢出，那就悲剧了
            //所以，亲们要慎用！！！上面那个方法就不错
            byte[] buf = new byte[i.available()];
            i.read(buf);
            //因为数组大小刚好，所以转换为字符串时无需在构造函数中设置起始点
            System.out.println(new String(buf));
            */
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//使用字节流写文件
	public static void fileOutputStream(String path) throws IOException{
		FileOutputStream fileOutStream = null;
		try {
			fileOutStream = new FileOutputStream(path);
			String str = "Nerxious is a good boy\r\n";
            byte[] buf = str.getBytes();
            //也可以直接使用fileOutStream.write("String".getBytes());
            //因为字符串就是一个对象，能直接调用方法
            fileOutStream.write(buf);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
