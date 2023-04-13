package RSA;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;

public class function {
	public static BigInteger mod(BigInteger x,BigInteger y,BigInteger z) { //模运算：x^y mod z
		if(y.equals(BigInteger.ONE)) { return x.mod(z); } //如果y为1，直接运算
		ArrayList<Integer> t=ttt(y); //y转换成2进制列表
		BigInteger res=x; //初始化返回结果res
		for(int i=t.size()-2;i>=0;--i) { //从二进制y的第二位开始扫描
			res=res.multiply(res).mod(z); //res = (res * res) mod z
			if(t.get(i)==1) { res=res.multiply(x).mod(z); } //如果扫描的位为1，多一步运算，res = (res * x) mod z
		}
		return res; //返回BigInteger类型的结果
	}
	
	public static ArrayList<Integer> ttt(BigInteger x) { //10进制转2进制
		ArrayList<Integer> res=new ArrayList<Integer>(); //将结果以列表形式保存
		while(x.compareTo(BigInteger.ZERO)>0) { //循环直到x=0为止
			if(x.mod(BigInteger.TWO).equals(BigInteger.ZERO)) { res.add(0); } //如果x mod 2 = 0， 列表res添加0
			else { res.add(1); } //否则添加1
			//System.out.println(x.toString());
			x=x.divide(BigInteger.TWO); //x = x/2，其中x/2向下取整
		}
		return res; //返回ArrayList<Integer>类型的结果
	}
	
	public static boolean f1(BigInteger x,BigInteger y) { //两数互素判定，采用欧几里德方法（辗转相除法）
		BigInteger t;
		if(x.compareTo(y)<0) { t=x;x=y;y=t; } //令x>y
		if(y.equals(BigInteger.ZERO)) { //如果y为0，进行判定
			if(x.equals(BigInteger.ONE)) {return true;} //如果x为1，返回true
			return false; //否则返回false
		}
		return f1(y, x.mod(y)); //如果y不为0，采用递归的方法继续运算
	}
	
	public static boolean f2(BigInteger x) { //素性判定，x为待判定数
		BigInteger h=new BigInteger("100"); //h是BigInteger类型的100
		if(x.compareTo(h)>0) { //100以上素数判定，采用费马小定理
			if(x.mod(BigInteger.TWO)==BigInteger.ZERO) {return false;} //2的倍数直接返回false，加快判定
			ArrayList<BigInteger> no=new ArrayList<BigInteger>(); //测试过的a值（随机数）放入列表，避免a重复
			while(no.size()<50) {
				BigInteger t=BigInteger.valueOf((int)(Math.random()*10000)); //生成[0,10000)的随机数t
				BigInteger ran=x.multiply(t).divide(h).divide(h); //x乘随机数t，再除以10000，得到[0,x)范围内的随机数ran
				if(ran.compareTo(BigInteger.ONE)>0 && !ran.equals(ran.subtract(BigInteger.ONE))) { //如果ran在[2,x-2]范围内，进行运算判定
					BigInteger m=mod(ran, x.subtract(BigInteger.ONE), x); //m为ran^(x-1) mod x的计算结果
					if(!m.equals(BigInteger.ONE)) {return false;} //如果m不为1，返回false
					if(!no.contains(ran)) { no.add(ran); } //System.out.println(ran.toString());使测试的数不重复
				}			
			}
			return true; //运算50次后返回true
		}else { //100（含）以下素数判定
			int []s= {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97};
			int t=x.intValueExact();
			for(int j=0;j<s.length;++j) { if(t==s[j]) {return true;} }
			return false;
		}
	}
	
	public static BigInteger f3(BigInteger x,BigInteger y) { //求逆元s, s * x mod y=1; gcd(x, y)=1，采用扩展欧几里德方法
		BigInteger s,s0,s1,t,t0,t1,temp,yt=y; //s为当前要计算的，s1为上一个，s0为上上一个，t同理；
		s0=BigInteger.ONE; //初始化s0=1，s1=0，t0=0，t1=1
		s1=BigInteger.ZERO;
		t0=BigInteger.ZERO;
		t1=BigInteger.ONE;
		while(y.compareTo(BigInteger.ZERO)>0) { //当y不为0时循环
			//System.out.println(x.mod(y).toString()+"="+x.toString()+"-"+y.toString()+"*"+x.divide(y).toString());
			s=s0.subtract(s1.multiply(x.divide(y))); //si=(si-2)-(si-1)*q
			t=t0.subtract(t1.multiply(x.divide(y))); //t同上
			s0=s1;s1=s;t0=t1;t1=t; //移位，为下次运算做准备
			temp=x;x=y;y=temp.mod(y); //x与y辗转相除
			//System.out.println(xt+"*"+s.toString()+","+yt+"*"+t.toString());
			//System.out.println(s.toString()+","+t.toString()+","+s1.toString()+","+t1.toString()+","+s0.toString()+","+t0.toString());
		} 
		if(s0.compareTo(BigInteger.ZERO)<0) { s0=s0.add(yt); } //System.out.println(s0+","+s0.add(yt));s0若为负数，要加上原始的y再输出
		return s0; //返回BigInteger类型的结果
	}
	
	public static BigInteger f4(int x) { //生成x位长度的素数（10进制）
		BigInteger res=BigInteger.ONE; //初始化res=1
		BigInteger t=new BigInteger("1000"); //t是类型为BigInteger的1000
		//System.out.println(res.toString().length());
		while(res.toString().length()<x) { //当res的长度不到x
			//System.out.println(res.toString());
			res=res.multiply(BigInteger.valueOf((int)(Math.random()*9998+2))).divide(t); //生成[2,10000)范围内的随机数ran，res * ran/1000
		}
		//System.out.println(f2(res));
		//System.out.println(res.toString());
		while(!f2(res)) {res=res.add(BigInteger.ONE);} //判断res的素性，如果不为素数，res加1，一直到素数出现为止
		return res; //返回BigInteger类型的结果
	}
	
	public static BigInteger[] f5(BigInteger x,BigInteger y) { //密钥生成，x，y应该为2个大素数
		if(f2(x) && f2(y)) { //如果x和y都为素数
			BigInteger []res=new BigInteger[3]; //结果数组，第一个为公钥n，第二个为公钥e，第三个为私钥d
			res[0]=x.multiply(y); //第一个数为n，n=x*y
			BigInteger fn=x.subtract(BigInteger.ONE).multiply(y.subtract(BigInteger.ONE)); //fn表示φ(n)，fn=(x-1)(y-1)
			BigInteger e=BigInteger.TWO; //e从2开始寻找
			while(!f1(e,fn)) { e=e.add(BigInteger.ONE); } //如果e与φ(n)不互质，e + 1，直到找到与φ(n)互质的e为止
			res[1]=e; //第二个数为e
			res[2]=f3(e,fn); //第三个数为d，f3为求逆元函数
			return res; //返回结果数组
		}
		BigInteger []res={BigInteger.ZERO,BigInteger.ZERO,BigInteger.ZERO};
		return  res; //如果x或y不为素数，返回{0,0,0}
	}
	
	
	public static ArrayList<BigInteger> f6(String s,BigInteger e,BigInteger n) { //加密函数，明文s，公钥e，公钥n
		try {
			String ntext=java.net.URLEncoder.encode(s,"GBK"); //转换文本编码格式
			byte ptext[]=ntext.getBytes("GBK"); //将字符串转换成byte类型数组，实质是各个字符的二进制形式
			ArrayList<BigInteger> res=new ArrayList<BigInteger>(); //将加密结果以列表形式保存
			for (int i=0;i<ptext.length;++i) {
				//System.out.println(ptext[i]);
				res.add(mod(BigInteger.valueOf(ptext[i]), e, n)); //每个单独加密
			}
			//BigInteger m=new BigInteger(ptext);//二进制串转换为一个大整数
			//System.out.println(m);
			return res; //返回加密结果
		} catch (UnsupportedEncodingException e1) { //如果发生错误，返回只含一个0的列表
			ArrayList<BigInteger> res=new ArrayList<BigInteger>();
			res.add(BigInteger.ZERO);
			return res;
		}
	}
	
	public static String f7(String m,BigInteger k,BigInteger n) { //解密函数，密文m，私钥k，公钥n
		m=m.replace("[", "").replace("]", ""); //去掉字符串首尾的“[”和“]”
		//System.out.println(m);
		String[] x = m.split(",");  //以逗号分隔
		byte []mt=new byte[x.length]; //将解密结果先转换成二进制存在mt中
		//System.out.println(x.length);
		for(int i=0;i<x.length;++i) {
			//System.out.println("1."+x[i]);
			//System.out.println(mod(new BigInteger(x[i].replace(" ", "")), k, n));
			mt[i]=(byte)Integer.parseInt(mod(new BigInteger(x[i].replace(" ", "")), k, n).toString()); //每个单独解密存入mt中
		}
		//System.out.println(s);
		//byte[]mt=new BigInteger(s).toByteArray();//m为密文的BigInteger类型
		String str;
		try {	//将byte类型数组转换成字符串
			str = (new String(mt,"GBK")); 
			str=java.net.URLDecoder.decode(str,"GBK"); 
		} catch (UnsupportedEncodingException e) { //如果发生错误，返回“error”
			return "error";
		}
		return str; //返回解密结果
	}
}
