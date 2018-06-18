package project20;


public class Setproject {

	public static void main(String[] args) {
		int a = 0,b = 0,c = 0,d = 0;
		a = (int) (Math.random()*20)+1;
		System.out.println("a="+a);
		b = (int) (Math.random()*20)+1;
		System.out.println("b="+b);
		d = (int) (Math.random()*20)+1;
		System.out.println("d="+d);
		int fuhao = (int) (Math.random()*2);
		System.out.println("fuhao="+fuhao);
		if(fuhao<1) {
			c= d-(a+b);
			System.out.println("第三个数="+c);
			int absc;
			if((absc=Math.abs(c))>20 || c==0) {
				main(args);
			}else {
				if (c<0) {
					System.out.println(a+"+"+b+"-"+Math.abs(c)+"="+d);
					show(a,b,absc,d,"+","-");
				} else {
					System.out.println(a+"+"+b+"+"+Math.abs(c)+"="+d);
					show(a,b,absc,d,"+","+");
				}
			}
		}else {
			c = d-(a-b);
			System.out.println("第三个数="+c);
			int absc;
			if ((absc=Math.abs(c))>20 || c==0) {
				main(args);
			} else {
				if (c<0) {
					System.out.println(a+"-"+b+"-"+Math.abs(c)+"="+d);
					show(a,b,absc,d,"-","-");
				} else {
					System.out.println(a+"-"+b+"+"+Math.abs(c)+"="+d);
					show(a,b,absc,d,"-","+");
				}
			}
			
		}
		
	}
	
	static void show(int a, int b, int c, int d, String fuhao1, String fuhao2) {
		int random = (int) (Math.random()*4);
		System.out.println("随机显示:"+random);
		switch (random) {
		case 0:
			System.out.println("x"+fuhao1+b+fuhao2+c+"="+d);
			break;
		case 1:
			System.out.println(a+fuhao1+"x"+fuhao2+c+"="+d);
			break;
		case 2:
			System.out.println(a+fuhao1+b+fuhao2+"x"+"="+d);
			break;
		case 3:
			System.out.println(a+fuhao1+b+fuhao2+c+"="+"x");
			break;
		default:
			break;
		}
	}

}
