## 什么是JWT？

加密后：
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJleGFtcGxldXNlciIsInVzZXJpZCI6IjEyMzQ1NiIsImV4cCI6MTcxMjY2NDk4OH0.embrgQLH7ht-bwFrUOD5J8HsPoOmYt1RCe78_b1iFMs

解析后：
Header: {"alg":"HS256"}
Payload: {"sub":"exampleuser","exp":1712664988,"userid":"123456"}
Signature: embrgQLH7ht-bwFrUOD5J8HsPoOmYt1RCe78_b1iFMs

* **Header** : 描述 JWT 的元数据，定义了生成签名的算法以及 `Token` 的类型。
* **Payload** : 用来存放实际需要传递的数据
* **Signature（签名）**：服务器通过 Payload、Header 和一个密钥(Secret)使用 Header 里面指定的签名算法（默认是 HMAC SHA256）生成。

密钥是自定义的一串字符串，目前版本的密钥要求大于256个bit
