package RSA;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;

public class function {
	public static BigInteger mod(BigInteger x,BigInteger y,BigInteger z) { //ģ���㣺x^y mod z
		if(y.equals(BigInteger.ONE)) { return x.mod(z); } //���yΪ1��ֱ������
		ArrayList<Integer> t=ttt(y); //yת����2�����б�
		BigInteger res=x; //��ʼ�����ؽ��res
		for(int i=t.size()-2;i>=0;--i) { //�Ӷ�����y�ĵڶ�λ��ʼɨ��
			res=res.multiply(res).mod(z); //res = (res * res) mod z
			if(t.get(i)==1) { res=res.multiply(x).mod(z); } //���ɨ���λΪ1����һ�����㣬res = (res * x) mod z
		}
		return res; //����BigInteger���͵Ľ��
	}
	
	public static ArrayList<Integer> ttt(BigInteger x) { //10����ת2����
		ArrayList<Integer> res=new ArrayList<Integer>(); //��������б���ʽ����
		while(x.compareTo(BigInteger.ZERO)>0) { //ѭ��ֱ��x=0Ϊֹ
			if(x.mod(BigInteger.TWO).equals(BigInteger.ZERO)) { res.add(0); } //���x mod 2 = 0�� �б�res���0
			else { res.add(1); } //�������1
			//System.out.println(x.toString());
			x=x.divide(BigInteger.TWO); //x = x/2������x/2����ȡ��
		}
		return res; //����ArrayList<Integer>���͵Ľ��
	}
	
	public static boolean f1(BigInteger x,BigInteger y) { //���������ж�������ŷ����·�����շת�������
		BigInteger t;
		if(x.compareTo(y)<0) { t=x;x=y;y=t; } //��x>y
		if(y.equals(BigInteger.ZERO)) { //���yΪ0�������ж�
			if(x.equals(BigInteger.ONE)) {return true;} //���xΪ1������true
			return false; //���򷵻�false
		}
		return f1(y, x.mod(y)); //���y��Ϊ0�����õݹ�ķ�����������
	}
	
	public static boolean f2(BigInteger x) { //�����ж���xΪ���ж���
		BigInteger h=new BigInteger("100"); //h��BigInteger���͵�100
		if(x.compareTo(h)>0) { //100���������ж������÷���С����
			if(x.mod(BigInteger.TWO)==BigInteger.ZERO) {return false;} //2�ı���ֱ�ӷ���false���ӿ��ж�
			ArrayList<BigInteger> no=new ArrayList<BigInteger>(); //���Թ���aֵ��������������б�����a�ظ�
			while(no.size()<50) {
				BigInteger t=BigInteger.valueOf((int)(Math.random()*10000)); //����[0,10000)�������t
				BigInteger ran=x.multiply(t).divide(h).divide(h); //x�������t���ٳ���10000���õ�[0,x)��Χ�ڵ������ran
				if(ran.compareTo(BigInteger.ONE)>0 && !ran.equals(ran.subtract(BigInteger.ONE))) { //���ran��[2,x-2]��Χ�ڣ����������ж�
					BigInteger m=mod(ran, x.subtract(BigInteger.ONE), x); //mΪran^(x-1) mod x�ļ�����
					if(!m.equals(BigInteger.ONE)) {return false;} //���m��Ϊ1������false
					if(!no.contains(ran)) { no.add(ran); } //System.out.println(ran.toString());ʹ���Ե������ظ�
				}			
			}
			return true; //����50�κ󷵻�true
		}else { //100���������������ж�
			int []s= {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97};
			int t=x.intValueExact();
			for(int j=0;j<s.length;++j) { if(t==s[j]) {return true;} }
			return false;
		}
	}
	
	public static BigInteger f3(BigInteger x,BigInteger y) { //����Ԫs, s * x mod y=1; gcd(x, y)=1��������չŷ����·���
		BigInteger s,s0,s1,t,t0,t1,temp,yt=y; //sΪ��ǰҪ����ģ�s1Ϊ��һ����s0Ϊ����һ����tͬ��
		s0=BigInteger.ONE; //��ʼ��s0=1��s1=0��t0=0��t1=1
		s1=BigInteger.ZERO;
		t0=BigInteger.ZERO;
		t1=BigInteger.ONE;
		while(y.compareTo(BigInteger.ZERO)>0) { //��y��Ϊ0ʱѭ��
			//System.out.println(x.mod(y).toString()+"="+x.toString()+"-"+y.toString()+"*"+x.divide(y).toString());
			s=s0.subtract(s1.multiply(x.divide(y))); //si=(si-2)-(si-1)*q
			t=t0.subtract(t1.multiply(x.divide(y))); //tͬ��
			s0=s1;s1=s;t0=t1;t1=t; //��λ��Ϊ�´�������׼��
			temp=x;x=y;y=temp.mod(y); //x��yշת���
			//System.out.println(xt+"*"+s.toString()+","+yt+"*"+t.toString());
			//System.out.println(s.toString()+","+t.toString()+","+s1.toString()+","+t1.toString()+","+s0.toString()+","+t0.toString());
		} 
		if(s0.compareTo(BigInteger.ZERO)<0) { s0=s0.add(yt); } //System.out.println(s0+","+s0.add(yt));s0��Ϊ������Ҫ����ԭʼ��y�����
		return s0; //����BigInteger���͵Ľ��
	}
	
	public static BigInteger f4(int x) { //����xλ���ȵ�������10���ƣ�
		BigInteger res=BigInteger.ONE; //��ʼ��res=1
		BigInteger t=new BigInteger("1000"); //t������ΪBigInteger��1000
		//System.out.println(res.toString().length());
		while(res.toString().length()<x) { //��res�ĳ��Ȳ���x
			//System.out.println(res.toString());
			res=res.multiply(BigInteger.valueOf((int)(Math.random()*9998+2))).divide(t); //����[2,10000)��Χ�ڵ������ran��res * ran/1000
		}
		//System.out.println(f2(res));
		//System.out.println(res.toString());
		while(!f2(res)) {res=res.add(BigInteger.ONE);} //�ж�res�����ԣ������Ϊ������res��1��һֱ����������Ϊֹ
		return res; //����BigInteger���͵Ľ��
	}
	
	public static BigInteger[] f5(BigInteger x,BigInteger y) { //��Կ���ɣ�x��yӦ��Ϊ2��������
		if(f2(x) && f2(y)) { //���x��y��Ϊ����
			BigInteger []res=new BigInteger[3]; //������飬��һ��Ϊ��Կn���ڶ���Ϊ��Կe��������Ϊ˽Կd
			res[0]=x.multiply(y); //��һ����Ϊn��n=x*y
			BigInteger fn=x.subtract(BigInteger.ONE).multiply(y.subtract(BigInteger.ONE)); //fn��ʾ��(n)��fn=(x-1)(y-1)
			BigInteger e=BigInteger.TWO; //e��2��ʼѰ��
			while(!f1(e,fn)) { e=e.add(BigInteger.ONE); } //���e���(n)�����ʣ�e + 1��ֱ���ҵ����(n)���ʵ�eΪֹ
			res[1]=e; //�ڶ�����Ϊe
			res[2]=f3(e,fn); //��������Ϊd��f3Ϊ����Ԫ����
			return res; //���ؽ������
		}
		BigInteger []res={BigInteger.ZERO,BigInteger.ZERO,BigInteger.ZERO};
		return  res; //���x��y��Ϊ����������{0,0,0}
	}
	
	
	public static ArrayList<BigInteger> f6(String s,BigInteger e,BigInteger n) { //���ܺ���������s����Կe����Կn
		try {
			String ntext=java.net.URLEncoder.encode(s,"GBK"); //ת���ı������ʽ
			byte ptext[]=ntext.getBytes("GBK"); //���ַ���ת����byte�������飬ʵ���Ǹ����ַ��Ķ�������ʽ
			ArrayList<BigInteger> res=new ArrayList<BigInteger>(); //�����ܽ�����б���ʽ����
			for (int i=0;i<ptext.length;++i) {
				//System.out.println(ptext[i]);
				res.add(mod(BigInteger.valueOf(ptext[i]), e, n)); //ÿ����������
			}
			//BigInteger m=new BigInteger(ptext);//�����ƴ�ת��Ϊһ��������
			//System.out.println(m);
			return res; //���ؼ��ܽ��
		} catch (UnsupportedEncodingException e1) { //����������󣬷���ֻ��һ��0���б�
			ArrayList<BigInteger> res=new ArrayList<BigInteger>();
			res.add(BigInteger.ZERO);
			return res;
		}
	}
	
	public static String f7(String m,BigInteger k,BigInteger n) { //���ܺ���������m��˽Կk����Կn
		m=m.replace("[", "").replace("]", ""); //ȥ���ַ�����β�ġ�[���͡�]��
		//System.out.println(m);
		String[] x = m.split(",");  //�Զ��ŷָ�
		byte []mt=new byte[x.length]; //�����ܽ����ת���ɶ����ƴ���mt��
		//System.out.println(x.length);
		for(int i=0;i<x.length;++i) {
			//System.out.println("1."+x[i]);
			//System.out.println(mod(new BigInteger(x[i].replace(" ", "")), k, n));
			mt[i]=(byte)Integer.parseInt(mod(new BigInteger(x[i].replace(" ", "")), k, n).toString()); //ÿ���������ܴ���mt��
		}
		//System.out.println(s);
		//byte[]mt=new BigInteger(s).toByteArray();//mΪ���ĵ�BigInteger����
		String str;
		try {	//��byte��������ת�����ַ���
			str = (new String(mt,"GBK")); 
			str=java.net.URLDecoder.decode(str,"GBK"); 
		} catch (UnsupportedEncodingException e) { //����������󣬷��ء�error��
			return "error";
		}
		return str; //���ؽ��ܽ��
	}
}
