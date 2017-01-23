package com.jun.dpms.util;

import java.util.Arrays;

public class SecurityCode {
	/**
	 * 楠岃瘉鐮侀毦搴︾骇鍒紝simple鍙寘鍚暟瀛楋紝medium鍖呭惈鏁板瓧鍜屽皬鍐欒嫳鏂囷紝hard鍖呭惈鏁板瓧鍜屽ぇ灏忓啓鑻辨枃
	 * @author 绗ㄨ泲
	 *
	 */
	public enum SecurityCodeLevel{simple,medium,hard};
	/**
	 * 浜х敓楠岃瘉鐮侊紝4浣嶄腑绛夐毦搴�
	 * @return String 楠岃瘉鐮�
	 */
	public static String getSecurityCode(){
		return getSecurityCode(6,SecurityCodeLevel.hard,false);
	}
	/**
	 * 浜х敓闀垮害鍜岄毦搴︿换鎰忕殑楠岃瘉鐮�
	 * @param length 闀垮害
	 * @param level 闅惧害绾у埆
	 * @param isCanRepeat 鏄惁鑳藉鍑虹幇閲嶅瀛楃锛屽鏋滀负true锛屽垯鍙兘鍑虹幇5575杩欐牱鍖呭惈3涓�5锛屼负false鍒欎笉鍏佽鍑虹幇	 
	 * @return String楠岃瘉鐮�
	 */
	public static String getSecurityCode(int length,SecurityCodeLevel level,boolean isCanRepeat){
		int len=length;		//闅忔満鎶藉彇len涓瓧绗�
		
		//瀛楃闆嗗悎
		char[] codes={'1','2','3','4','5','6','7','8','9',
				                       'a','b','c','d','e','f','g','h','i',
				                       'j','k','m','n','p','q','r','s','t',
				                       'u','v','w','x','y','z','A','B','C',
				                       'D','E','F','G','H','I','J','K','L',
				                       'M','N','P','Q','R','S','T','U','V',
				                       'W','X','Y','Z'};
		//鏍规嵁涓嶅悓闅惧害鎴彇瀛楃鏁扮粍
		if(level==SecurityCodeLevel.simple){
			codes=Arrays.copyOfRange(codes, 0, 9);
		}else if(level==SecurityCodeLevel.medium){
			codes=Arrays.copyOfRange(codes, 0, 33);
		}
		
		//瀛楃闆嗗悎闀垮害
		int n=codes.length;
		//鎶涘嚭杩愯鏃跺紓甯�
		if(len>n&&isCanRepeat==false){
			throw new RuntimeException(
						String.format("璋冪敤SecurityCode.getSecurityCode(%1$s,%2$s,%3$s)鍑虹幇寮傚父锛屽綋isCanRepeat涓�%3$s鏃讹紝浼犲叆鍙傛暟%1$s涓嶈兘澶т簬%4$s", len,level,isCanRepeat,n)
					);
		}
		
		//瀛樻斁鎶藉彇鍑烘潵鐨勫瓧绗�
		char[] result = new char[len];
		
		//鍒ゆ柇鏄惁鍑虹幇閲嶅鐨勫瓧绗�
		if(!isCanRepeat){
			for(int i=0;i<result.length;i++){
				//绱㈠紩0andn-1
				int r =(int)(Math.random()*n);
				
				//灏唕esult涓殑绗琲涓厓绱犺缃负codes[r]瀛樻斁鐨勬暟鍊�
				result[i]=codes[r];
				//蹇呴』纭繚涓嶄細鍐嶆鎶藉彇鍒扮浉鍚屽瓧绗︼紝灏嗘渶鍚庝竴涓瓧绗︽斁鍦╮涓猴紝骞跺皢闀垮害鍑�1
				codes[r]=codes[n-1];
			}
			}else{
				for(int i=0;i<result.length;i++){
					//绱㈠紩0andn-1
					int r =(int)(Math.random()*n);
					
					//灏唕esult涓殑绗琲涓厓绱犺缃负codes[r]瀛樻斁鐨勬暟鍊�
					result[i]=codes[r];
					//蹇呴』纭繚涓嶄細鍐嶆鎶藉彇鍒扮浉鍚屽瓧绗︼紝灏嗘渶鍚庝竴涓瓧绗︽斁鍦╮涓猴紝骞跺皢闀垮害鍑�1
					codes[r]=codes[n-1];
					n--;
				}
			}
		
		return String.valueOf(result);
	}
}
