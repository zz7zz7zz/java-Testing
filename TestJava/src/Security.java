import java.util.HashMap;

/**
 * 加解密算法
 * @author long
 */
public final class Security {

	private static HashMap<Byte,Byte> SEND_MAPPING = new HashMap<Byte,Byte>(256);
	
	private static HashMap<Byte,Byte> RECV_MAPPING = new HashMap<Byte,Byte>(256);
	
	private static final byte[] MAPPING = {
			-13,-96,-82,45,65,-34,3,24,26,97,28,-72,62,55,-89,84,
			32,-30,-66,-40,-60,-104,5,-38,-20,-36,-33,114,54,47,-71,-14,
			10,95,-9,-99,13,104,-50,-27,87,-76,-118,107,57,69,12,-75,
			4,71,68,-123,-110,38,121,86,-126,-108,-58,-8,18,75,99,-23,
			96,25,127,-47,-128,109,78,-12,-84,21,82,27,-57,-64,-19,-77,
			16,-15,-120,-124,36,40,15,-56,61,-94,63,73,125,-54,17,-103,
			80,30,-105,-107,76,102,39,-92,19,-59,49,-90,-93,115,29,74,
			-41,126,-26,-45,93,-44,-16,79,-70,-29,110,-102,91,-73,-25,60,
			9,-116,119,-17,-81,37,-114,64,-74,-39,-78,0,112,33,-22,52,
			-122,-4,59,11,-112,-31,-55,1,-95,-18,-79,98,90,42,48,-119,
			-101,-62,-65,122,66,-11,-49,14,120,85,70,7,100,-100,-127,-1,
			-32,-5,-3,-7,-52,88,-28,72,113,-111,23,-24,-69,31,-87,101,
			103,41,117,77,50,35,-117,-43,-88,-48,94,-63,83,-98,20,6,
			-61,-2,81,51,56,67,123,-121,-53,-83,2,-68,-80,-86,-21,-106,
			58,8,-125,-67,53,-115,-113,-85,22,43,108,34,116,-6,-97,-109,
			-42,46,89,-37,44,-46,-10,105,-35,92,-91,111,106,-51,118,124
	};
	static {
		int count = 0;
		for(byte i = Byte.MIN_VALUE;i<= Byte.MAX_VALUE;i++){
			SEND_MAPPING.put( i, MAPPING[count]);
			RECV_MAPPING.put(MAPPING[count], i);
			count++;
			if(i==Byte.MAX_VALUE){
				break;
			}
		}
	}
	
	/**
	 * 加密
	 * @param data
	 */
	public static void encrypt(byte[] data){
		for(int i = 0;i<data.length;i++){
			data[i] = SEND_MAPPING.get(data[i]);
		}
	}

	/**
	 * 解密
	 * @param data
	 */
	public static void decrypt(byte[] data){
		for(int i = 0;i<data.length;i++){
			data[i] = RECV_MAPPING.get(data[i]);
		}
	}
	
	//---------------------------------------------------
	public static void main(String[] args) {

//		byte[] original = {55,88,99};
		byte[] original = "感恩所有的，好的，坏的!".getBytes();
		print(original);
		
		encrypt(original);
		print(original);
		
		decrypt(original);
		print(original);
		System.out.println(new String(original));
	}
	
	private static void print(byte[] data){
		System.out.print("\r\n");
		for(int i = 0;i<data.length;i++){
			if(i%16 == 0){
				System.out.println();
			}
			System.out.print(data[i]+",");
		}
		System.out.print("\r\n");
	}

}
