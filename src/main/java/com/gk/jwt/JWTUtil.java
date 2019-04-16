package com.gk.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtil {
	
	/**
	 * 加密的key
	 * @return
	 */
	public SecretKey generalKey() {
		String keyString = Constants.JWT_SECRET;
		byte[] bytes = keyString.getBytes();
		SecretKey key = new SecretKeySpec(bytes, 0, bytes.length, "AES");
		
		return key;
	}
	
	/**
	 * 创建JWT
	 * @param id
	 * @param issuer
	 * @param subject
	 * @param ttlmillis
	 * @return
	 */
	public String createJWT(String id,String issuer, String subject, long ttlmillis) {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		
		long now = System.currentTimeMillis();
		Date date = new Date(now);
		
		// 创建payload的私有声明（根据特定的业务需要添加，如果要拿这个做验证，一般是需要和jwt的接收方提前沟通好验证方式的）
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("uid", "123456");
		claims.put("user_name", "gk");
		
		// 生成签名的时候使用的秘钥secret，切记这个秘钥不能外露哦。它就是你服务端的私钥，在任何场景都不应该流露出去。
        // 一旦客户端得知这个secret, 那就意味着客户端是可以自我签发jwt了。
		SecretKey secretKey = generalKey();
		
		//下面就是在为payload添加各种标准声明和私有声明了
		JwtBuilder builder = Jwts.builder()
			.setClaims(claims)
			.setId(id)	// 设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
			.setIssuedAt(date)	// iat: jwt的签发时间
			.setIssuer(issuer)	// issuer：jwt签发人
			.setSubject(subject)	// sub(Subject)：代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，可以存放什么userid，roldid之类的，作为什么用户的唯一标志。
			.signWith(signatureAlgorithm, secretKey);
		if(ttlmillis >= 0) {
			long expireMillis = now + ttlmillis;
			Date expire = new Date(expireMillis);
			builder.setExpiration(expire);	//设置过期时间
		}
		return builder.compact();
	}
	
	/**
	 * 解密JWT
	 * @param jwt
	 * @return
	 */
	public Claims parseJWT(String jwt) {
		SecretKey secretKey = generalKey();	//签名秘钥，和生成的签名的秘钥一模一样
		Claims claims = Jwts.parser().setSigningKey(secretKey)
			.parseClaimsJws(jwt).getBody();
		return claims;
	}
	
	public static void main(String[] args) throws JsonProcessingException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName", "gk_test");
		map.put("userAge", "30");
		map.put("userqq", "122212121");
		ObjectMapper mapper = new ObjectMapper();
		String subject = mapper.writeValueAsString(map);
		JWTUtil jwtUtil = new JWTUtil();
		String jwt = jwtUtil.createJWT(Constants.JWT_ID, "gk_dev", subject, Constants.JWT_TTL);
		System.out.println("JWT: " + jwt);
		
		System.out.println("解密：");
		
		Claims claims = jwtUtil.parseJWT(jwt);
		System.out.println(claims.getId());
		System.out.println(claims.getIssuedAt());
		System.out.println(claims.getIssuer());
		System.out.println(claims.getSubject());
		System.out.println(claims.get("uid",String.class));
		
	}
	
}
